package controladores;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import beans.Sala;
import beans.Sessao;
import fachada.CinemaFachada;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;

public class Tela_RemoverSalaController implements Initializable {
	@FXML
	private TableView<Sala> tableViewSalas;
	@FXML
	private TableColumn<Sala, String> tableColumnIdSala;

	private Sala selecionada = null;

	@FXML
	public void selecionarSala() {
		selecionada = tableViewSalas.getSelectionModel().getSelectedItem();
	}

	@FXML
	public void removerSala() {
		if (selecionada != null) {
			try {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("CinEasy Plex");
				alert.setHeaderText("Deseja remover a sala " + selecionada.getIdSala()
						+ "?\nAo remover uma sala você irá remover todas as sessoes relacionadas à sala " + selecionada.getIdSala() + ".\nDeseja Continuar?");
				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK) {
					ArrayList<Sessao> sessoesARemover = CinemaFachada.getInstance().sessoesPorSala(selecionada);
					for (int i = 0; i < sessoesARemover.size(); i++) {
						CinemaFachada.getInstance().removerSessao(sessoesARemover.get(i));
					}
					CinemaFachada.getInstance().removerSala(selecionada);
					
					alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("CinEasy Plex");
					alert.setHeaderText(null);
					alert.setContentText("Sala removida com sucesso!");
					alert.showAndWait();
					
					preencherTabela();

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@FXML
	public void voltarParaConfiguracoes() {
		ScreenManager.setScene(ScreenManager.getInstance().getTelaConfiguracao());
	}

	private void preencherTabela() {
		ArrayList<Sala> listaDeSalas = CinemaFachada.getInstance().listarTodasSala();
		tableColumnIdSala.setCellValueFactory(new Callback<CellDataFeatures<Sala, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Sala, String> todosAsSalas) {
				return new SimpleStringProperty(Byte.valueOf(todosAsSalas.getValue().getIdSala()).toString());
			}
		});
		tableViewSalas.setItems(FXCollections.observableArrayList(listaDeSalas));
		tableViewSalas.refresh();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		preencherTabela();
	}
}
