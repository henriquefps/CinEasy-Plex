package controladores;

import java.util.ArrayList;

import beans.Filme;
import fachada.Fachada;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;

public class Tela_AlterarFilmeController {
	@FXML
	private TextField tituloTextField;
	@FXML
	private TextField generoTextField;
	@FXML
	private TextField duracao_horaTextField;
	@FXML
	private TextField duracao_minutoTextField;
	@FXML
	private TextField classificacaoTextField;
	
	@FXML private TableView<Filme> tableViewFilmes;
	@FXML private TableColumn<Filme, String>tableColumnTituloFilme;
	
	private Filme selecionado = null;

	@FXML
	public void voltarParaConfiguracoes() {
		ScreenManager.setScene(ScreenManager.getInstance().getTelaConfiguracao());
	}
	
	
	private void preencherTabela(){
		ArrayList<Filme> listaDeFilmes = Fachada.getInstance().listarFilmes();
		tableColumnTituloFilme.setCellValueFactory(new Callback<CellDataFeatures<Filme,String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Filme, String> todosOsFilmes) {
				return new SimpleStringProperty(todosOsFilmes.getValue().getTitulo());
				}
			});
		tableViewFilmes.setItems(FXCollections.observableArrayList(listaDeFilmes));
		tableViewFilmes.refresh();
	}
	
	
}
