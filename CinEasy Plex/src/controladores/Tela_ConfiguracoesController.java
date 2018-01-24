package controladores;

import javafx.fxml.FXML;

public class Tela_ConfiguracoesController {

	@FXML public void voltarParaMenuPrincipal(){
		ScreenManager.setScene(ScreenManager.getInstance().getTelaMenuPrincipal());
	}
	
	@FXML public void abrirAdicionarContas(){
		ScreenManager.setScene(ScreenManager.getInstance().getTelaAdicionarConta());
	}
	@FXML public void abrirAdicionarFilmes(){
		ScreenManager.setScene(ScreenManager.getInstance().getTelaAdicionarFilme());
	}
	@FXML public void abrirAdicionarSalas(){
		ScreenManager.setScene(ScreenManager.getInstance().getTelaAdicionarSala());
	}
	@FXML public void abrirAdicionarSessoes(){
		ScreenManager.setScene(ScreenManager.getInstance().getTelaAdcionarSessao());
	}
	@FXML public void abrirRemover_ListarContas(){
		ScreenManager.setScene(ScreenManager.getInstance().getTelaRemover_ListarConta());
	}
	@FXML public void abrirRemoverFilmes(){
		ScreenManager.setScene(ScreenManager.getInstance().getTelaRemoverFilme());
	}
	@FXML public void abrirRemoverSalas(){
		ScreenManager.setScene(ScreenManager.getInstance().getTelaRemoverSala());
	}
	@FXML public void abrirRemoverSessoes(){
		ScreenManager.setScene(ScreenManager.getInstance().getTelaRemoverSessao());
	}
	@FXML public void abrirAlterarContas(){
		ScreenManager.setScene(ScreenManager.getInstance().getTelaAlterarConta());
	}
	@FXML public void abrirAlterarFilmes(){
		ScreenManager.setScene(ScreenManager.getInstance().getTelaAlterarFilme());
	}
	@FXML public void abrirAlterarSalas(){
		ScreenManager.setScene(ScreenManager.getInstance().getTelaAlterarSala());
	}
	@FXML public void abrirAlterarSessoes(){
		ScreenManager.setScene(ScreenManager.getInstance().getTelaAlterarSessao());
	}
	@FXML public void abrirListarFilmes(){
		ScreenManager.setScene(ScreenManager.getInstance().getTelaListarFilme());
	}
	@FXML public void abrirListarSalas(){
		ScreenManager.setScene(ScreenManager.getInstance().getTelaListarSala());
	}
	@FXML public void abrirListarSessoes(){
		ScreenManager.setScene(ScreenManager.getInstance().getTelaListarSessao());
	}
	@FXML public void abrirTelaVendas(){
		ScreenManager.setScene(ScreenManager.getInstance().getTelaVendas());
	}
}
