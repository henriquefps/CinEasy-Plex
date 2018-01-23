package controladores;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import beans.Conta;
import fachada.CinemaFachada;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;

public class Tela_AlterarContaController implements Initializable {

	@FXML
	private TextField usuarioTextField;
	@FXML
	private PasswordField senhaPasswordField;
	@FXML
	private PasswordField confirmarSenhaPasswordField;

	@FXML
	private TableView<Conta> tableViewContas;
	@FXML
	private TableColumn<Conta, String> colunaLogin;

	private Conta selecionada = null;

	@FXML
	public void voltarParaConfiguracoes() {
		ScreenManager.setScene(ScreenManager.getInstance().getTelaConfiguracao());
	}

	@FXML
	public void alterarConta() {
		if ((CinemaFachada.getInstance().buscarContaLogin(usuarioTextField.getText()) == null
				|| usuarioTextField.getText().equals(selecionada.getLogin())) // Se não existir ou se for ele mesmo
				&& senhaPasswordField.getText().equals(confirmarSenhaPasswordField.getText())
				&& !senhaPasswordField.getText().equals("")) {
			
			selecionada.setLogin(usuarioTextField.getText());
			selecionada.setSenha(senhaPasswordField.getText());
			
			usuarioTextField.setText("");
			senhaPasswordField.setText("");
			confirmarSenhaPasswordField.setText("");
			preencherTabela();
		}
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

	@FXML
	public void selecionarConta() {
		selecionada = tableViewContas.getSelectionModel().getSelectedItem();
		if (selecionada != null) {
			usuarioTextField.setText(selecionada.getLogin());
			senhaPasswordField.setText(selecionada.getSenha());
			confirmarSenhaPasswordField.setText(selecionada.getSenha());
		}
	}

}
