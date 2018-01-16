package controladores;

import java.net.URL;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.ResourceBundle;

import beans.Filme;
import fachada.Fachada;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;

public class Tela_ListarFilmeController implements Initializable{
	@FXML private TableView<Filme> tableViewFilmes;
	@FXML private TableColumn<Filme, String> colunaTitulo;
	@FXML private TableColumn<Filme, String> colunaGenero;
	@FXML private TableColumn<Filme, String> colunaDuracao;
	@FXML private TableColumn<Filme, String> colunaClassificacao;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		preencherTabela();
		
	}
	@FXML public void voltarParaConfiguracoes(){
		ScreenManager.setScene(ScreenManager.getInstance().getTelaConfiguracao());
	}
	
	private void preencherTabela(){
		ArrayList<Filme> listaDeFilmes = Fachada.getInstance().listarFilmes();
		colunaTitulo.setCellValueFactory(new Callback<CellDataFeatures<Filme,String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Filme, String> todosOsFilmes) {
				return new SimpleStringProperty(todosOsFilmes.getValue().getTitulo());
				}
			});
		colunaGenero.setCellValueFactory(new Callback<CellDataFeatures<Filme,String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Filme, String> todosOsFilmes) {
				return new SimpleStringProperty(todosOsFilmes.getValue().getGenero());
				}
			});
		colunaDuracao.setCellValueFactory(new Callback<CellDataFeatures<Filme,String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Filme, String> todosOsFilmes) {
				return new SimpleStringProperty(todosOsFilmes.getValue().getDuracao().toString());
				}
			});
		colunaClassificacao.setCellValueFactory(new Callback<CellDataFeatures<Filme,String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Filme, String> todosOsFilmes) {
				return new SimpleStringProperty(todosOsFilmes.getValue().getTitulo());
				}
			});
		tableViewFilmes.setItems(FXCollections.observableArrayList(listaDeFilmes));
		tableViewFilmes.refresh();
	}
	
}
