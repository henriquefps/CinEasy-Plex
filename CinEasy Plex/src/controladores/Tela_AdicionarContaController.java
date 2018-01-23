package controladores;

import java.awt.TextField;

import beans.Conta;
import fachada.CinemaFachada;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;

public class Tela_AdicionarContaController {
	@FXML private TextField usuarioTextField;
	@FXML private PasswordField senhaPasswordField;
	@FXML private PasswordField confirmarSenhaPasswordField;
	
	@FXML public void cadastrarConta(){
		try {
			if(CinemaFachada.getInstance().buscarContaLogin(usuarioTextField.getText()) == null &&
					senhaPasswordField.getText().equals(confirmarSenhaPasswordField.getText())){
				CinemaFachada.getInstance().cadastrarConta(new Conta(usuarioTextField.getText(), senhaPasswordField.getText()));
				usuarioTextField.setText("");
				senhaPasswordField.setText("");
				confirmarSenhaPasswordField.setText("");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML public void voltarParaConfiguracoes(){
		ScreenManager.setScene(ScreenManager.getInstance().getTelaConfiguracao());
	}
}