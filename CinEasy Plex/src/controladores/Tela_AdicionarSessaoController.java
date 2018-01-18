package controladores;

import java.time.LocalDate;
import java.util.ArrayList;

import beans.Filme;
import beans.Sala;
import beans.Sessao;
import fachada.CinemaFachada;
import interfaces.IRepositorioSala;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class Tela_AdicionarSessaoController {
	
	private CinemaFachada f = CinemaFachada.getInstance();
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
		
	}
	
	@FXML
	public void buscarSalas(){
		ArrayList<Sala> s = new ArrayList<>();
		s = f.listarTodasSala();
		for(int i = 0; i < s.size(); i++){
			System.out.println(s.get(i).getIdSala()+ s.get(i).getTipo().toString() + '\n');
		}
	}
	
	@FXML
	public void cadastrarSessao(){
		System.out.println("teste");
	}
	
	@FXML
	public void voltarParaConfiguracoes() {
		ScreenManager.setScene(ScreenManager.getInstance().getTelaConfiguracao());
	}
	
	public void preencherTabelas(){
		ArrayList<Filme> filmes = CinemaFachada.getInstance().listarTodasFilme();
		ArrayList<Sala> salas = CinemaFachada.getInstance().listarTodasSala();
		
		
	}
}
