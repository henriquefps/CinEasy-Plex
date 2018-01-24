package controladores;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import beans.Conta;
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
import repositorios.RepositorioContasArray;

public class Tela_Remover_ListarContasController implements Initializable {
	@FXML
	private TableView<Conta> tableViewContas;
	@FXML
	private TableColumn<Conta, String> colunaLogin;

	private Conta selecionada = null;

	@FXML
	public void removerConta() {
		try {
			if (selecionada != null) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("CinEasy Plex");
				alert.setHeaderText("Deseja remover a conta de Login " + selecionada.getLogin() + "?");
				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK) {
					CinemaFachada.getInstance().removerConta(selecionada);

					alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("CinEasy Plex");
					alert.setHeaderText(null);
					alert.setContentText("Conta removida com sucesso!");
					alert.showAndWait();
					
					RepositorioContasArray.getInstance().salvarArquivo();
					
					preencherTabela();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void voltarParaConfiguracoes() {
		ScreenManager.setScene(ScreenManager.getInstance().getTelaConfiguracao());
	}

	@FXML
	public void selecionarConta() {
		selecionada = tableViewContas.getSelectionModel().getSelectedItem();
	}

	private void preencherTabela() {
		ArrayList<Conta> listaDeContas = CinemaFachada.getInstance().listarTodasConta();
		colunaLogin.setCellValueFactory(new Callback<CellDataFeatures<Conta, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Conta, String> todosAsContas) {
				return new SimpleStringProperty(todosAsContas.getValue().getLogin());
			}
		});

		tableViewContas.setItems(FXCollections.observableArrayList(listaDeContas));
		tableViewContas.refresh();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		preencherTabela();
	}
}
