package controladores;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import beans.Sessao;
import fachada.CinemaFachada;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class Tela_ListarSessaoController implements Initializable {

	@FXML private TableView<Sessao> tvSessao;
	@FXML private TableColumn<Sessao, Integer> id;
	@FXML private TableColumn<Sessao, String> filme;
	@FXML private TableColumn<Sessao, String> data;
	@FXML private TableColumn<Sessao, String> duracao;
	@FXML private TableColumn<Sessao, String> horaFim;
	@FXML private TableColumn<Sessao, String> sala;
	@FXML private TextField tfIdSessao, tfFilme, tfIdSala;
	
	private ArrayList<Sessao> todasSessao;
	private CinemaFachada f;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		f = CinemaFachada.getInstance();
		todasSessao = f.listarTodasSessao();
		preencherTabela(todasSessao);
	}
	
	@FXML
	public void pesquisarFilme(){
		String titulo = tfFilme.getText();
		todasSessao = f.buscarSessaoPorTitulo(titulo);
		preencherTabela(todasSessao);
	}
	
	@FXML
	public void pesquisarSala(){
		int valor1 = Integer.parseInt(tfIdSala.getText());
		todasSessao = f.buscarSessaoPorSala((byte) valor1);
		preencherTabela(todasSessao);
	}
	
	@FXML
	public void pesquisarSessao(){
		
	}
	
	@FXML
	public void listarTodas(){
		todasSessao = f.listarTodasSessao();
		preencherTabela(todasSessao);
	}
	@FXML
	public void voltarParaConfiguracoes() {
		ScreenManager.setScene(ScreenManager.getInstance().getTelaConfiguracao());
	}
	
	public void preencherTabela(ArrayList<Sessao> todaSessao){
		id.setCellValueFactory(new PropertyValueFactory<>("idSessao"));
		filme.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Sessao,String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Sessao, String> param) {
				return new SimpleStringProperty(param.getValue().getFilmeExibido().getTitulo());
			}
		});
		data.setCellValueFactory(new Callback<CellDataFeatures<Sessao, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Sessao, String> todosAsSessoes) {
				return new SimpleStringProperty(ScreenManager.formatarLocalDateTime(todosAsSessoes.getValue().getInicioDaSessao()));
			}
		});
		horaFim.setCellValueFactory(new Callback<CellDataFeatures<Sessao, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Sessao, String> todosAsSessoes) {
				return new SimpleStringProperty(ScreenManager.formatarLocalDateTime(todosAsSessoes.getValue().getFimDaSessao()));
			}
		});
		duracao.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Sessao,String>, ObservableValue<String>>() {

			@Override
			public ObservableValue<String> call(CellDataFeatures<Sessao, String> arg0) {
				return new SimpleStringProperty(arg0.getValue().getFilmeExibido().getDuracao().toString());
			}
		});
		sala.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Sessao,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<Sessao, String> arg0) {
				return new SimpleStringProperty(arg0.getValue().getSalaDeExibicao().getTipo().toString());
			}
		});
		tvSessao.setItems(FXCollections.observableArrayList(todasSessao));
	}
}
