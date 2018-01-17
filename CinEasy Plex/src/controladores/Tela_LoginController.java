package controladores;

import beans.Conta;
import fachada.CinemaFachada;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Tela_LoginController {
	private CinemaFachada fachada = CinemaFachada.getInstance();
	
	@FXML private TextField loginTextField;
	@FXML private PasswordField senhaPasswordField;
	
	@FXML public void validarLogin(){
		Conta procurado = fachada.buscarContaPorNome(loginTextField.getText());
		if (procurado != null && procurado.getSenha().equals(senhaPasswordField.getText())) {
			ScreenManager.setScene(ScreenManager.getInstance().getTelaMenuPrincipal());
		}
	}
}
