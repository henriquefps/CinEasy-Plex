package controladores;

import java.net.URL;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.ResourceBundle;

import beans.Sala;
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

public class Tela_ListarSalaController implements Initializable{
	@FXML private TableView<Sala> tableViewSalas;
	@FXML private TableColumn<Sala, String> colunaIdSala;//colunaTitulo;
	@FXML private TableColumn<Sala, String> colunaTipo;//colunaGenero;
	@FXML private TableColumn<Sala, String> colunaNumeroCadeiras;//colunaDuracao;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		preencherTabela();
		
	}
	@FXML public void voltarParaConfiguracoes(){
		ScreenManager.setScene(ScreenManager.getInstance().getTelaConfiguracao());
	}
	
	private void preencherTabela(){
		ArrayList<Sala> listaDeSalas = CinemaFachada.getInstance().listarTodasSala();
		colunaIdSala.setCellValueFactory(new Callback<CellDataFeatures<Sala,String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Sala, String> todosAsSalas) {
				return new SimpleStringProperty(Byte.valueOf(todosAsSalas.getValue().getIdSala()).toString());
				}
			});
		colunaNumeroCadeiras.setCellValueFactory(new Callback<CellDataFeatures<Sala,String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Sala, String> todosAsSalas) {
				return new SimpleStringProperty(Integer.valueOf(todosAsSalas.getValue().getQuantColunas() * todosAsSalas.getValue().getQuantLinhas()).toString());
				}
			});
		colunaTipo.setCellValueFactory(new Callback<CellDataFeatures<Sala,String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Sala, String> todosAsSalas) {
				return new SimpleStringProperty(todosAsSalas.getValue().getTipo().toString());
				}
			});
		
		tableViewSalas.setItems(FXCollections.observableArrayList(listaDeSalas));
		tableViewSalas.refresh();
	}
	
}
