package controladores;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;

public class Tela_VenderIngressoController implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void voltarParaMenuPrincipal(){
		ScreenManager.setScene(ScreenManager.getInstance().getTelaMenuPrincipal());
	}

}
