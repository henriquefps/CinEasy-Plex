package controladores;

import beans.Filme;
import beans.Sala;
import beans.Sessao;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class Tela_AdicionarSessaoController {
	@FXML
	private TextField pesquisarFilme;
	@FXML
	private TextField pesquisarSala;
	@FXML
	private TextField inicio_hr;
	@FXML
	private TextField inicio_min;
	@FXML
	private TableView<Filme> tvFilmes;
	@FXML
	private TableView<Sala> tvSalas;
	
	@FXML
	public void pesquisarFilme(){
		
	}
	
	@FXML
	public void pesquisarSalas(){
		
	}
	
	@FXML
	public void cadastrarSessao(){
		
	}
	
	@FXML
	public void voltarParaConfiguracoes() {
		ScreenManager.setScene(ScreenManager.getInstance().getTelaConfiguracao());
	}
}
