package controladores;

import beans.Conta;
import fachada.Fachada;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Tela_LoginController {
	private Fachada fachada = Fachada.getInstance();
	
	@FXML private TextField loginTextField;
	@FXML private PasswordField senhaPasswordField;
	
	@FXML public void validarLogin(){
		Conta procurado = fachada.buscarConta(loginTextField.getText());
		if (procurado != null && procurado.getSenha().equals(senhaPasswordField.getText())) {
			//TODO Chamar o controlador de telas para a próxima tela.
		}
	}
}