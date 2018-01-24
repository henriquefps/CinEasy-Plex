package controladores;


import beans.Conta;
import fachada.CinemaFachada;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Tela_AdicionarContaController {
	@FXML private TextField usuarioTextField;
	@FXML private PasswordField senhaPasswordField;
	@FXML private PasswordField confirmarSenhaPasswordField;
	
	@FXML public void cadastrarConta(){
		try {
			if(CinemaFachada.getInstance().buscarContaLogin(usuarioTextField.getText()) == null &&
					senhaPasswordField.getText().equals(confirmarSenhaPasswordField.getText()) &&
					!senhaPasswordField.getText().equals("")){
				CinemaFachada.getInstance().cadastrarConta(new Conta(usuarioTextField.getText(), senhaPasswordField.getText()));
				usuarioTextField.setText("");
				senhaPasswordField.setText("");
				confirmarSenhaPasswordField.setText("");
				
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("CinEasy Plex");
				alert.setHeaderText(null);
				alert.setContentText("Conta cadastrada com sucesso!");
				alert.showAndWait();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML public void voltarParaConfiguracoes(){
		ScreenManager.setScene(ScreenManager.getInstance().getTelaConfiguracao());
	}
}
