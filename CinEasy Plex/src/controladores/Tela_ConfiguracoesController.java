package controladores;

import javafx.fxml.FXML;

public class Tela_ConfiguracoesController {

	@FXML public void voltarParaMenuPrincipal(){
		// Com a implementaÃ§Ã£o do ScreenManager, tudo que preciso Ã© usar o mÃ©todo statico setScene e dar como parÃ¢metro
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
		ScreenManager.setScene(ScreenManager.getInstance().getTelaAdicionarSala());
	}
	@FXML public void abrirAdicionarSessoes(){
		// TODO abrir tela adicionar Sessoes
		ScreenManager.setScene(ScreenManager.getInstance().getTelaAdcionarSessao());
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
		// TODO abrir tela remover sessoes
		ScreenManager.setScene(ScreenManager.getInstance().getTelaRemoverSessao());
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
		ScreenManager.setScene(ScreenManager.getInstance().getTelaAlterarSessao());
	}
	@FXML public void abrirListarContas(){
		// TODO
	}
	@FXML public void abrirListarFilmes(){
		ScreenManager.setScene(ScreenManager.getInstance().getTelaListarFilme());
	}
	@FXML public void abrirListarSalas(){
		// TODO
		ScreenManager.setScene(ScreenManager.getInstance().getTelaListarSala());
	}
	@FXML public void abrirListarSessoes(){
		// TODO
	}
}
