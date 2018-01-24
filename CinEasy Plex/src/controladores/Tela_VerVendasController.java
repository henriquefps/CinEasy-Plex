package controladores;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import beans.Venda;
import fachada.CinemaFachada;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;

public class Tela_VerVendasController implements Initializable{
	@FXML private TableView<Venda> tabelaVendas;
	
	@FXML private TableColumn<Venda, String> colunaIdVenda;
	@FXML private TableColumn<Venda, String> colunaFilme;
	@FXML private TableColumn<Venda, String> colunaData;
	@FXML private TableColumn<Venda, String> colunaHorario;
	@FXML private TableColumn<Venda, String> ColunaIdSala;
	@FXML private TableColumn<Venda, String> colunaPosicao;
	@FXML private TableColumn<Venda, String> colunaMeiaEntrada;
	@FXML private TableColumn<Venda, String> colunaValorIngresso;
	
	@FXML private Label valorLabel;
	
	private Venda selecionada = null;
	
	@FXML public void removerVenda(){
		if(selecionada != null){
			try {
				CinemaFachada.getInstance().removerVenda(selecionada);
				preencherTabela();
				calcularArrecadacao();
			} catch (Exception e) {e.printStackTrace();}
		}
	}
	
	@FXML public void voltarParaMenuPrincipal(){
		ScreenManager.setScene(ScreenManager.getInstance().getTelaMenuPrincipal());
	}
	
	@FXML public void selecionarVenda(){
		selecionada = tabelaVendas.getSelectionModel().getSelectedItem();
	}
	
	private void preencherTabela(){
		ArrayList<Venda> listaDeVendas = CinemaFachada.getInstance().listarTodasVenda();
		colunaFilme.setCellValueFactory(new Callback<CellDataFeatures<Venda,String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Venda, String> todosAsVendas) {
				return new SimpleStringProperty(todosAsVendas.getValue().getSessaoVendida().getFilmeExibido().getTitulo());
				}
			});
		colunaIdVenda.setCellValueFactory(new Callback<CellDataFeatures<Venda,String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Venda, String> todosAsVendas) {
				return new SimpleStringProperty(Integer.valueOf(todosAsVendas.getValue().getIdVenda()).toString());
				}
			});
		colunaData.setCellValueFactory(new Callback<CellDataFeatures<Venda,String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Venda, String> todosAsVendas) {
				return new SimpleStringProperty(todosAsVendas.getValue().getSessaoVendida().getInicioDaSessao().toLocalDate().toString());
				}
			});
		colunaHorario.setCellValueFactory(new Callback<CellDataFeatures<Venda,String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Venda, String> todosAsVendas) {
				return new SimpleStringProperty(todosAsVendas.getValue().getSessaoVendida().getInicioDaSessao().toLocalTime().toString());
				}
			});
		ColunaIdSala.setCellValueFactory(new Callback<CellDataFeatures<Venda,String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Venda, String> todosAsVendas) {
				return new SimpleStringProperty(Byte.valueOf(todosAsVendas.getValue().getSessaoVendida().getSalaDeExibicao().getIdSala()).toString());
				}
			});
		colunaPosicao.setCellValueFactory(new Callback<CellDataFeatures<Venda,String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Venda, String> todosAsVendas) {
				return new SimpleStringProperty(todosAsVendas.getValue().getIngressoVendido().getCadeiraVendida().toString());
				}
			});
		colunaMeiaEntrada.setCellValueFactory(new Callback<CellDataFeatures<Venda,String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Venda, String> todosAsVendas) {
				return new SimpleStringProperty(Boolean.valueOf(todosAsVendas.getValue().getIngressoVendido().isMeia()).toString());
				}
			});
		colunaValorIngresso.setCellValueFactory(new Callback<CellDataFeatures<Venda,String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Venda, String> todosAsVendas) {
				return new SimpleStringProperty(Float.valueOf(todosAsVendas.getValue().getSessaoVendida().getValorDoIngresso()).toString());
				}
			});
		tabelaVendas.setItems(FXCollections.observableArrayList(listaDeVendas));
		tabelaVendas.refresh();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		preencherTabela();
		calcularArrecadacao();
	}
	
	private void calcularArrecadacao(){
		Float valor = Float.valueOf(0);
		for (int i = 0; i < CinemaFachada.getInstance().listarTodasVenda().size(); i++) {
			valor += CinemaFachada.getInstance().listarTodasVenda().get(i).getSessaoVendida().getValorDoIngresso();
		}
		valorLabel.setText(valor.toString());
	}
}