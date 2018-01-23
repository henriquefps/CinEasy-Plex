package controladores;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.sun.glass.ui.Screen;

import beans.Conta;
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

public class Tela_Remover_ListarContasController implements Initializable{
	@FXML private TableView<Conta> tableViewContas;
	@FXML private TableColumn<Conta, String>colunaLogin;
	
	private Conta selecionada = null;
	
	@FXML public void removerConta(){
		try {
			if (selecionada != null) {
				CinemaFachada.getInstance().removerConta(selecionada);
				preencherTabela();
			}
		} catch (Exception e) {e.printStackTrace();}
	}
	@FXML public void voltarParaConfiguracoes(){
		ScreenManager.setScene(ScreenManager.getInstance().getTelaConfiguracao());
	}
	@FXML public void selecionarConta(){
		selecionada = tableViewContas.getSelectionModel().getSelectedItem();
	}
	
	private void preencherTabela(){
		ArrayList<Conta> listaDeContas = CinemaFachada.getInstance().listarTodasConta();
		colunaLogin.setCellValueFactory(new Callback<CellDataFeatures<Conta,String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Conta, String> todosAsContas) {
				return new SimpleStringProperty(todosAsContas.getValue().getLogin());
				}
			});
		
		tableViewContas.setItems(FXCollections.observableArrayList(listaDeContas));
		tableViewContas.refresh();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		preencherTabela();
	}
}
