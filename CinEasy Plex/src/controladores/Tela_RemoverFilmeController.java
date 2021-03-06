package controladores;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import beans.Filme;
import fachada.CinemaFachada;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;
import repositorios.RepositorioFilmes;

public class Tela_RemoverFilmeController implements Initializable {
	@FXML
	private TableView<Filme> tableViewFilmes;
	@FXML
	private TableColumn<Filme, String> tableColumnTituloFilme;

	private Filme selecionado = null;

	@FXML
	public void voltarParaConfiguracoes() {
		ScreenManager.setScene(ScreenManager.getInstance().getTelaConfiguracao());
	}

	@FXML
	public void removerFilme() {
		try {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("CinEasy Plex");
			alert.setHeaderText("Deseja remover o filme " + selecionado.getTitulo() + "?");
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				CinemaFachada.getInstance().removerFilme(selecionado);

				alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("CinEasy Plex");
				alert.setHeaderText(null);
				alert.setContentText("Filme removido com sucesso!");
				alert.showAndWait();
				
				RepositorioFilmes.getInstance().salvarArquivo();
				
				preencherTabela();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void selecionarItem() {
		selecionado = tableViewFilmes.getSelectionModel().getSelectedItem();
	}

	private void preencherTabela() {
		ArrayList<Filme> listaDeFilmes = CinemaFachada.getInstance().listarTodasFilme();
		tableColumnTituloFilme
				.setCellValueFactory(new Callback<CellDataFeatures<Filme, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(CellDataFeatures<Filme, String> todosOsFilmes) {
						return new SimpleStringProperty(todosOsFilmes.getValue().getTitulo());
					}
				});
		tableViewFilmes.setItems(FXCollections.observableArrayList(listaDeFilmes));
		tableViewFilmes.refresh();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		preencherTabela();
	}

}
