package controladores;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import beans.Filme;
import beans.Sala;
import beans.TipoSala;
import fachada.CinemaFachada;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Tela_AdicionarSessaoController implements Initializable{
	
	private CinemaFachada f;
	@FXML
	private DatePicker dtSessao;
	@FXML
	private Label filmeSelecionado, salaSelecionada;
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
	private TableColumn<Sala, TipoSala> tipo;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		f = CinemaFachada.getInstance();
		preencherTabelaFilme();
		preencherTabelaSala();
	}
	
	@FXML
	public void cadastrarSessao(){
		System.out.println("teste");
	}
	
	@FXML
	public void voltarParaConfiguracoes() {
		ScreenManager.setScene(ScreenManager.getInstance().getTelaConfiguracao());
	}
	
	public void preencherTabelaFilme(){
		ArrayList<Filme> filmes = f.listarTodasFilme();		
		titulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
		duracao.setCellValueFactory(new PropertyValueFactory<>("duracao"));
		tvFilmes.setItems(FXCollections.observableArrayList(filmes));
	}
	
	public void preencherTabelaSala(){
		ArrayList<Sala> salas = f.listarTodasSala();
		tipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
		id.setCellValueFactory(new PropertyValueFactory<>("idSala"));
		tvSalas.setItems(FXCollections.observableArrayList(salas));
	}
}