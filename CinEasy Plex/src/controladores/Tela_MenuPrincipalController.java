package controladores;

import javafx.fxml.FXML;

public class Tela_MenuPrincipalController {
	
	
	@FXML public void sairParaLogin(){
		ScreenManager.setScene(ScreenManager.getInstance().getTelaLogin());
	}
	
	@FXML public void abrirVenderIngressos(){
		// TODO abrir tela Vender Ingressos
	}
	
	@FXML public void abrirConfiguracoes(){
		ScreenManager.setScene(ScreenManager.getInstance().getTelaConfiguracao());
	}
}
