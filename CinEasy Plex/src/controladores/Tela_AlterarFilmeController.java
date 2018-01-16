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
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;

public class Tela_AlterarFilmeController implements Initializable{
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
	
	@FXML public void selecionarItem(){
		selecionado = tableViewFilmes.getSelectionModel().getSelectedItem();
		if(selecionado != null){
			tituloTextField.setText(selecionado.getTitulo());
			generoTextField.setText(selecionado.getGenero());
			duracao_horaTextField.setText(String.valueOf(selecionado.getDuracao().getHour()));
			duracao_minutoTextField.setText(String.valueOf(selecionado.getDuracao().getMinute()));
			classificacaoTextField.setText(selecionado.getClassificacao());
		}
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		preencherTabela();
	}
	
	@FXML public void salvarAlteracoes(){
		selecionado.setTitulo(tituloTextField.getText());
		selecionado.setGenero(generoTextField.getText());
		selecionado.setDuracao(LocalTime.of(Integer.parseInt(duracao_horaTextField.getText()),
				Integer.parseInt(duracao_minutoTextField.getText())));
		selecionado.setClassificacao(classificacaoTextField.getText());
		
		
		selecionado = null;
		
		tituloTextField.setText("");
		generoTextField.setText("");
		duracao_horaTextField.setText("");
		duracao_minutoTextField.setText("");
		classificacaoTextField.setText("");
		
		preencherTabela();
	}
	
	
	
}
