package controladores;

import beans.Conta;
import fachada.CinemaFachada;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Tela_LoginController {
	@FXML private TextField loginTextField;
	@FXML private PasswordField senhaPasswordField;
	
	@FXML public void validarLogin(){
		Conta procurado = CinemaFachada.getInstance().buscarContaLogin(loginTextField.getText());
		if (procurado != null && procurado.getSenha().equals(senhaPasswordField.getText())) {
			ScreenManager.setScene(ScreenManager.getInstance().getTelaMenuPrincipal());
		}
		else{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("CinEasy Plex");
			alert.setHeaderText(null);
			alert.setHeaderText("Sua Conta ou Senha são inválidas");
			alert.showAndWait();
		}
	}
}
