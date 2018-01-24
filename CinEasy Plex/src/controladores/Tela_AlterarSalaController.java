package controladores;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import beans.Sala;
import beans.TipoSala;
import fachada.CinemaFachada;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;
import repositorios.RepositorioSalasArray;

public class Tela_AlterarSalaController implements Initializable{
	@FXML private TableView<Sala> tableViewSalas;
	@FXML private TableColumn<Sala, String> tableColumnIdSala;
	@FXML private TableColumn<Sala, String> tableColumnTipoSala;
	@FXML private ChoiceBox<TipoSala> tipoSala;
	@FXML private CheckBox d3;
	
	private Sala selecionada = null;
	
	@FXML public void selecionarSala(){
		selecionada = tableViewSalas.getSelectionModel().getSelectedItem();
		if(selecionada != null){
			d3.selectedProperty().set(selecionada.isD3());
		}
	}
	public void atualizarSalaSelecionada(){
		if (selecionada != null ) {
			selecionada.setTipo(tipoSala.getValue());
			selecionada.setVisual(d3.isSelected());
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("CinEasy Plex");
			alert.setHeaderText(null);
			alert.setContentText("Sala alterada com sucesso!");
			alert.showAndWait();
			
			RepositorioSalasArray.getInstance().salvarArquivo();
			
			preencherTabela();
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
		tableColumnTipoSala.setCellValueFactory(new Callback<CellDataFeatures<Sala,String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Sala, String> todosAsSalas) {
				return new SimpleStringProperty(todosAsSalas.getValue().getTipo().toString());
				}
			});
		tableViewSalas.setItems(FXCollections.observableArrayList(listaDeSalas));
		tableViewSalas.refresh();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		preencherTabela();
		ObservableList<TipoSala> tiposSalaS = FXCollections.observableArrayList(TipoSala.values());
		tipoSala.setItems(tiposSalaS);
	}
}
