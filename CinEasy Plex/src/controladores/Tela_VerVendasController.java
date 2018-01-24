package controladores;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import beans.Venda;
import fachada.CinemaFachada;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;

public class Tela_VerVendasController implements Initializable {
	@FXML
	private TableView<Venda> tabelaVendas;

	@FXML
	private TableColumn<Venda, String> colunaIdVenda;
	@FXML
	private TableColumn<Venda, String> colunaFilme;
	@FXML
	private TableColumn<Venda, String> colunaData;
	@FXML
	private TableColumn<Venda, String> colunaHorario;
	@FXML
	private TableColumn<Venda, String> ColunaIdSala;
	@FXML
	private TableColumn<Venda, String> colunaPosicao;
	@FXML
	private TableColumn<Venda, String> colunaMeiaEntrada;
	@FXML
	private TableColumn<Venda, String> colunaValorIngresso;

	@FXML
	private Label valorLabel;

	private Venda selecionada = null;

	@FXML
	public void removerVenda() {
		if (selecionada != null) {
			try {

				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Remover Sala");
				alert.setHeaderText("Deseja remover a venda com ID de valor " + selecionada.getIdVenda() + "?");
				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK) {
					CinemaFachada.getInstance().removerVenda(selecionada);
					preencherTabela();
					calcularArrecadacao();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@FXML
	public void voltarParaMenuPrincipal() {
		ScreenManager.setScene(ScreenManager.getInstance().getTelaConfiguracao());
	}

	@FXML
	public void selecionarVenda() {
		selecionada = tabelaVendas.getSelectionModel().getSelectedItem();
	}

	private void preencherTabela() {
		ArrayList<Venda> listaDeVendas = CinemaFachada.getInstance().listarTodasVenda();
		colunaFilme.setCellValueFactory(new Callback<CellDataFeatures<Venda, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Venda, String> todosAsVendas) {
				return new SimpleStringProperty(
						todosAsVendas.getValue().getSessaoVendida().getFilmeExibido().getTitulo());
			}
		});
		colunaIdVenda.setCellValueFactory(new Callback<CellDataFeatures<Venda, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Venda, String> todosAsVendas) {
				return new SimpleStringProperty(Integer.valueOf(todosAsVendas.getValue().getIdVenda()).toString());
			}
		});
		colunaData.setCellValueFactory(new Callback<CellDataFeatures<Venda, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Venda, String> todosAsVendas) {
				return new SimpleStringProperty(
						todosAsVendas.getValue().getSessaoVendida().getInicioDaSessao().toLocalDate().toString());
			}
		});
		colunaHorario.setCellValueFactory(new Callback<CellDataFeatures<Venda, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Venda, String> todosAsVendas) {
				return new SimpleStringProperty(
						todosAsVendas.getValue().getSessaoVendida().getInicioDaSessao().toLocalTime().toString());
			}
		});
		ColunaIdSala.setCellValueFactory(new Callback<CellDataFeatures<Venda, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Venda, String> todosAsVendas) {
				return new SimpleStringProperty(
						Byte.valueOf(todosAsVendas.getValue().getSessaoVendida().getSalaDeExibicao().getIdSala())
								.toString());
			}
		});
		colunaPosicao.setCellValueFactory(new Callback<CellDataFeatures<Venda, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Venda, String> todosAsVendas) {
				return new SimpleStringProperty(
						todosAsVendas.getValue().getIngressoVendido().getCadeiraVendida().toString());
			}
		});
		colunaMeiaEntrada.setCellValueFactory(new Callback<CellDataFeatures<Venda, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Venda, String> todosAsVendas) {
				if(todosAsVendas.getValue().getIngressoVendido().isMeia())
					return new SimpleStringProperty("sim");
				else	
				return new SimpleStringProperty("não");
			}
		});
		colunaValorIngresso
				.setCellValueFactory(new Callback<CellDataFeatures<Venda, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(CellDataFeatures<Venda, String> todosAsVendas) {
						return new SimpleStringProperty(Float
								.valueOf(todosAsVendas.getValue().getIngressoVendido().getValorIngresso()).toString());
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

	private void calcularArrecadacao() {
		Float valor = Float.valueOf(0);
		for (int i = 0; i < CinemaFachada.getInstance().listarTodasVenda().size(); i++) {
			valor += CinemaFachada.getInstance().listarTodasVenda().get(i).getIngressoVendido().getValorIngresso();
		}
		valorLabel.setText(valor.toString());
	}
}
