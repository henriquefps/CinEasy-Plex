package controladores;

import javafx.fxml.FXML;

public class Tela_ConfiguracoesController {

	@FXML public void voltarParaMenuPrincipal(){
		// Com a implementação do ScreenManager, tudo que preciso é usar o método statico setScene e dar como parâmetro
		// A cena a ser carregada no Stage
		ScreenManager.setScene(ScreenManager.getInstance().getTelaMenuPrincipal());
	}
	
	@FXML public void abrirAdicionarContas(){
		// TODO
	}
	@FXML public void abrirAdicionarFilmes(){
		ScreenManager.setScene(ScreenManager.getInstance().getTelaAdicionarFilme());
	}
	@FXML public void abrirAdicionarSalas(){
		// TODO
	}
	@FXML public void abrirAdicionarSessoes(){
		// TODO
	}
	@FXML public void abrirRemoverContas(){
		// TODO
	}
	@FXML public void abrirRemoverFilmes(){
		ScreenManager.setScene(ScreenManager.getInstance().getTelaRemoverFilme());
	}
	@FXML public void abrirRemoverSalas(){
		// TODO	
	}
	@FXML public void abrirRemoverSessoes(){
		// TODO
	}
	@FXML public void abrirAlterarContas(){
		// TODO
	}
	@FXML public void abrirAlterarFilmes(){
		ScreenManager.setScene(ScreenManager.getInstance().getTelaAlterarFilme());
	}
	@FXML public void abrirAlterarSalas(){
		// TODO
	}
	@FXML public void abrirAlterarSessoes(){
		// TODO
	}
	@FXML public void abrirListarContas(){
		// TODO
	}
	@FXML public void abrirListarFilmes(){
		ScreenManager.setScene(ScreenManager.getInstance().getTelaListarFilme());
	}
	@FXML public void abrirListarSalas(){
		// TODO
	}
	@FXML public void abrirListarSessoes(){
		// TODO
	}
}
