package controladores;

import java.time.LocalDate;

import beans.Filme;
import beans.Sala;
import beans.Sessao;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
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
	private TableColumn<Filme, String> titulo;
	@FXML
	private TableColumn<Filme, LocalDate> duracao ;
	@FXML
	private TableView<Sala> tvSalas;
	@FXML
	private TableColumn<Sala, Byte> id;
	@FXML
	private TableColumn<Sala, String> tipo;
	@FXML
	private TableColumn<Sala, Integer > nCadeiras; 
	
	@FXML
	public void buscarFilmes(){
		System.out.println("teste");
	}
	
	@FXML
	public void buscarSalas(){
		System.out.println("teste");
	}
	
	@FXML
	public void cadastrarSessao(){
		System.out.println("teste");
	}
	
	@FXML
	public void voltarParaConfiguracoes() {
		ScreenManager.setScene(ScreenManager.getInstance().getTelaConfiguracao());
	}
}
