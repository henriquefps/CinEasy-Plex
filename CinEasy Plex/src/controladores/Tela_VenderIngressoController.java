package controladores;

import java.net.URL;
import java.util.ResourceBundle;

import beans.Sessao;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

public class Tela_VenderIngressoController implements Initializable {
	
	
	@FXML
	private TableView<Sessao> tbSessao;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void voltarParaMenuPrincipal(){
		ScreenManager.setScene(ScreenManager.getInstance().getTelaMenuPrincipal());
	}

}
