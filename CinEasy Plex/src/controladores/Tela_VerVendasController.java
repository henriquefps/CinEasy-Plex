package controladores;

import java.net.URL;
import java.util.ResourceBundle;

import beans.Venda;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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
	
	@FXML public void removerVenda(){
		
	}
	
	@FXML public void voltarParaMenuPrincipal(){
		ScreenManager.setScene(ScreenManager.getInstance().getTelaMenuPrincipal());
	}
	
	@FXML public void selecionarVenda(){
		
	}
	
	private void preencherTabela(){
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		preencherTabela();
	}
}
