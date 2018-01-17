package controladores;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import beans.Filme;
import fachada.CinemaFachada;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;

public class Tela_RemoverFilmeController implements Initializable{
	@FXML private TableView<Filme> tableViewFilmes;
	@FXML private TableColumn<Filme, String>tableColumnTituloFilme;
	
	private Filme selecionado = null;
	
	@FXML public void voltarParaConfiguracoes(){
		ScreenManager.setScene(ScreenManager.getInstance().getTelaConfiguracao());
	}
	
	@FXML public void removerFilme(){
		try {
			CinemaFachada.getInstance().removerFilme(selecionado);
			preencherTabela();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML public void selecionarItem(){
		selecionado = tableViewFilmes.getSelectionModel().getSelectedItem();
	}
	
	private void preencherTabela(){
		ArrayList<Filme> listaDeFilmes = CinemaFachada.getInstance().listarTodasFilme();
		tableColumnTituloFilme.setCellValueFactory(new Callback<CellDataFeatures<Filme,String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Filme, String> todosOsFilmes) {
				return new SimpleStringProperty(todosOsFilmes.getValue().getTitulo());
				}
			});
		tableViewFilmes.setItems(FXCollections.observableArrayList(listaDeFilmes));
		tableViewFilmes.refresh();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		preencherTabela();
	}
	
}
