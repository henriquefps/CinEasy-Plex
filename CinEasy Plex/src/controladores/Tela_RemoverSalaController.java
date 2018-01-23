package controladores;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import beans.Sala;
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

public class Tela_RemoverSalaController implements Initializable{
	@FXML private TableView<Sala> tableViewSalas;
	@FXML private TableColumn<Sala, String> tableColumnIdSala;
	
	private Sala selecionada = null;
	
	@FXML public void selecionarSala(){
		selecionada = tableViewSalas.getSelectionModel().getSelectedItem();
	}
	
	@FXML public void removerSala(){
		if(selecionada != null){
			try {
				//TODO LANCAR ALERTA PARA REMOVER TODAS AS SESSOES
				CinemaFachada.getInstance().removerSala(selecionada);
				preencherTabela();
			} catch (Exception e) {e.printStackTrace();}
		}
	}
	
	@FXML public void voltarParaConfiguracoes(){
		ScreenManager.setScene(ScreenManager.getInstance().getTelaConfiguracao());
	}
	
	private void preencherTabela(){
		ArrayList<Sala> listaDeSalas = CinemaFachada.getInstance().listarTodasSala();
		tableColumnIdSala.setCellValueFactory(new Callback<CellDataFeatures<Sala,String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Sala, String> todosAsSalas) {
				return new SimpleStringProperty(Byte.valueOf(todosAsSalas.getValue().getIdSala()).toString());
				}
			});
		tableViewSalas.setItems(FXCollections.observableArrayList(listaDeSalas));
		tableViewSalas.refresh();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		preencherTabela();
	}
}
