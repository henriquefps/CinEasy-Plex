package controladores;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import beans.Sessao;
import fachada.CinemaFachada;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class Tela_RemoverSessaoController implements Initializable {

	@FXML private TableView<Sessao> tvSessao;
	@FXML private TableColumn<Sessao, Integer> id;
	@FXML private TableColumn<Sessao, String> filme;
	@FXML private TableColumn<Sessao, LocalDateTime> data;
	@FXML private TableColumn<Sessao, String> duracao;
	@FXML private TableColumn<Sessao, LocalDateTime> horaFim;
	@FXML private TableColumn<Sessao, String> sala;
	@FXML private TextField tfIdSessao, tfFilme, tfIdSala;
	
	
	private CinemaFachada f;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		f = CinemaFachada.getInstance();
		preencherTabela();
	}
	
	@FXML 
	public void removerSessao(){
		
	}
	
	@FXML 
	public void pesquisarSessao(){
		
	}
	
	@FXML
	public void pesquisarFilme(){
		
	}
	
	@FXML
	public void pesquisarSala(){
		
	}
	
	@FXML
	public void voltarParaConfiguracoes() {
		ScreenManager.setScene(ScreenManager.getInstance().getTelaConfiguracao());
	}
	
	public void preencherTabela(){
		id.setCellValueFactory(new PropertyValueFactory<>("idSessao"));
		filme.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Sessao,String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Sessao, String> param) {
				// TODO Auto-generated method stub
				return new SimpleStringProperty(param.getValue().getFilmeExibido().getTitulo());
			}
		});
		data.setCellValueFactory(new PropertyValueFactory<>("inicioDaSessao"));
		horaFim.setCellValueFactory(new PropertyValueFactory<>("fimDaSessao"));
		duracao.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Sessao,String>, ObservableValue<String>>() {

			@Override
			public ObservableValue<String> call(CellDataFeatures<Sessao, String> arg0) {
				// TODO Auto-generated method stub
				return new SimpleStringProperty(arg0.getValue().getFilmeExibido().getDuracao().toString());
			}
		});
		sala.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Sessao,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<Sessao, String> arg0) {
				// TODO Auto-generated method stub
				return new SimpleStringProperty(arg0.getValue().getSalaDeExibicao().getTipo().toString());
			}
		});
		tvSessao.setItems(FXCollections.observableArrayList(f.listarTodasSessao()));
	}

	
	

}
