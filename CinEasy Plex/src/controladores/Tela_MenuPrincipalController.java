package controladores;

import javafx.fxml.FXML;

public class Tela_MenuPrincipalController {
	
	
	@FXML public void sairParaLogin(){
		ScreenManager.setScene(ScreenManager.getInstance().getTelaLogin());
	}
	
	@FXML public void abrirVenderIngressos(){
		ScreenManager.setScene(ScreenManager.getInstance().getTelaVenderIngresso());
	}
	
	@FXML public void abrirConfiguracoes(){
		ScreenManager.setScene(ScreenManager.getInstance().getTelaConfiguracao());
	}
}
