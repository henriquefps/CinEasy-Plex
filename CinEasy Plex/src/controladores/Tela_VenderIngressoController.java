package controladores;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import beans.Cadeira;
import beans.Filme;
import beans.Ingresso;
import beans.Sessao;
import beans.Venda;
import fachada.CinemaFachada;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.util.Callback;

public class Tela_VenderIngressoController implements Initializable {
	@FXML
	private TableView<Filme> tabelaFilmes;
	@FXML
	private TableView<Sessao> tabelaSessoes;
	@FXML
	private TableView<Cadeira> tabelaCadeira;

	@FXML
	private TableColumn<Filme, String> colunaFilme;
	@FXML
	private TableColumn<Filme, String> colunaGenero;
	@FXML
	private TableColumn<Filme, String> colunaClassificacao;

	@FXML
	private TableColumn<Sessao, String> colunaData;
	@FXML
	private TableColumn<Sessao, String> colunaHorario;
	@FXML
	private TableColumn<Sessao, String> colunaDiaDaSemana;
	@FXML
	private TableColumn<Sessao, String> colunaSala;
	@FXML
	private TableColumn<Sessao, String> colunaTipoSala;
	@FXML
	private TableColumn<Sessao, String> colunaValor;
	@FXML
	private TableColumn<Sessao,String> coluna3D;

	@FXML
	private TableColumn<Cadeira, String> colunaCadeira;

	@FXML
	private CheckBox meiaEntradaCheckBox;
	
	@FXML
	private Button btnComprar;

	private Filme filmeSelecionado = null;
	private Sessao sessaoSelecionada = null;
	private Cadeira cadeiraSelecionada = null;

	@FXML
	public void comprarIngresso() {
		try {
			if (filmeSelecionado != null && sessaoSelecionada != null && cadeiraSelecionada != null) {
				Ingresso vendido = new Ingresso(meiaEntradaCheckBox.isSelected(), cadeiraSelecionada,
						sessaoSelecionada);
				vendido.setValorIngresso(sessaoSelecionada.getValorDoIngresso());
				mexeNasCadeiras();
				if(meiaEntradaCheckBox.isSelected()) {
					sessaoSelecionada.setValorDoIngresso(sessaoSelecionada.getValorDoIngresso()*2);
					meiaEntradaCheckBox.setSelected(false);
				}
				CinemaFachada.getInstance().cadastrarIngresso(vendido);
				CinemaFachada.getInstance().cadastrarVenda(new Venda(vendido, sessaoSelecionada));
				CinemaFachada.getInstance().alterarSessao(sessaoSelecionada);
				despreencherTabelas();
				preencherTabelaFilmes();
				filmeSelecionado = null;
				sessaoSelecionada = null;
				cadeiraSelecionada = null;
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Sucesso");
				alert.setHeaderText("Compra realizada com sucesso");
				alert.showAndWait();
			}
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erro");
			alert.setHeaderText("Houve um erro na compra do ingresso");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}
	
	private void mexeNasCadeiras() {
		ArrayList<Cadeira> cadeiras = sessaoSelecionada.getCadeirasDaSessao();
		for(int i = 0; i < cadeiras.size(); i++) {
			if(cadeiraSelecionada.equals(cadeiras.get(i))) {
				cadeiraSelecionada.setDisponivel(false);
				cadeiras.set(i, cadeiraSelecionada);
			}
		}
		sessaoSelecionada.setCadeirasDaSessao(cadeiras);
		
	}

	@FXML
	public void selecionarFilme() {
		filmeSelecionado = tabelaFilmes.getSelectionModel().getSelectedItem();
		if (filmeSelecionado != null) {
			preencherTabelaSessoes();
		}
	}

	@FXML
	public void selecionarSessoes() {
		sessaoSelecionada = tabelaSessoes.getSelectionModel().getSelectedItem();
		if (sessaoSelecionada != null) {
			preencherTabelaCadeiras();
			meiaEntradaCheckBox.setDisable(false);
		}
	}

	@FXML
	public void selecionarCadeira() {
		cadeiraSelecionada = tabelaCadeira.getSelectionModel().getSelectedItem();
		btnComprar.setDisable(false);
	}

	@FXML
	private TableView<Sessao> tbSessao;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		preencherTabelaFilmes();
	}

	public void voltarParaMenuPrincipal() {
		ScreenManager.setScene(ScreenManager.getInstance().getTelaMenuPrincipal());
	}

	private void preencherTabelaFilmes() {
		ArrayList<Filme> listaDeFilmes = CinemaFachada.getInstance().listarTodasFilme();
		colunaFilme.setCellValueFactory(new Callback<CellDataFeatures<Filme, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Filme, String> todosOsFilmes) {
				return new SimpleStringProperty(todosOsFilmes.getValue().getTitulo());
			}
		});
		colunaGenero.setCellValueFactory(new Callback<CellDataFeatures<Filme, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Filme, String> todosOsFilmes) {
				return new SimpleStringProperty(todosOsFilmes.getValue().getGenero());
			}
		});
		colunaClassificacao
				.setCellValueFactory(new Callback<CellDataFeatures<Filme, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(CellDataFeatures<Filme, String> todosOsFilmes) {
						return new SimpleStringProperty(todosOsFilmes.getValue().getClassificacao());
					}
				});
		tabelaFilmes.setItems(FXCollections.observableArrayList(listaDeFilmes));
		tabelaFilmes.refresh();
	}

	private void preencherTabelaSessoes() {
		ArrayList<Sessao> sessoes = CinemaFachada.getInstance()
				.filtrarSessoesFuturas(CinemaFachada.getInstance().listarSessoesPorFilme(filmeSelecionado));

		colunaData.setCellValueFactory(new Callback<CellDataFeatures<Sessao, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Sessao, String> todosAsSessoes) {
				return new SimpleStringProperty(
						ScreenManager.formatarLocalDate(todosAsSessoes.getValue().getInicioDaSessao().toLocalDate()));
			}
		});

		colunaHorario.setCellValueFactory(new Callback<CellDataFeatures<Sessao, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Sessao, String> todosAsSessoes) {
				return new SimpleStringProperty(
						ScreenManager.formatarLocalTime(todosAsSessoes.getValue().getInicioDaSessao().toLocalTime()));
			}
		});
		colunaDiaDaSemana
				.setCellValueFactory(new Callback<CellDataFeatures<Sessao, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(CellDataFeatures<Sessao, String> todosAsSessoes) {
						return new SimpleStringProperty(ScreenManager
								.formatarDayOfWeek(todosAsSessoes.getValue().getInicioDaSessao().getDayOfWeek()));
					}
				});
		colunaSala.setCellValueFactory(new Callback<CellDataFeatures<Sessao, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Sessao, String> todosAsSessoes) {
				return new SimpleStringProperty(
						Byte.valueOf(todosAsSessoes.getValue().getSalaDeExibicao().getIdSala()).toString());
			}
		});
		colunaTipoSala.setCellValueFactory(new Callback<CellDataFeatures<Sessao, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Sessao, String> todosAsSessoes) {
				return new SimpleStringProperty(todosAsSessoes.getValue().getSalaDeExibicao().getTipo().toString());
			}
		});
		colunaValor.setCellValueFactory(new Callback<CellDataFeatures<Sessao, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Sessao, String> todosAsSessoes) {
				return new SimpleStringProperty(
						Float.valueOf(todosAsSessoes.getValue().getValorDoIngresso()).toString());
			}
		});
		
		coluna3D.setCellValueFactory(new Callback<CellDataFeatures<Sessao, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Sessao, String> todosAsSessoes) {
				if(todosAsSessoes.getValue().getSalaDeExibicao().isD3())
					return new SimpleStringProperty("sim");
				
				return new SimpleStringProperty("não");
			}
		});

		tabelaSessoes.setItems(FXCollections.observableArrayList(sessoes));
		tabelaSessoes.refresh();
	}

	private void preencherTabelaCadeiras() {
		ArrayList<Cadeira> cadeiras = CinemaFachada.getInstance().listarCadeirasDisponiveis(sessaoSelecionada);
		colunaCadeira.setCellValueFactory(new Callback<CellDataFeatures<Cadeira, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Cadeira, String> todosAsCadeiras) {
				return new SimpleStringProperty(todosAsCadeiras.getValue().toString());
			}
		});
		tabelaCadeira.setItems(FXCollections.observableArrayList(cadeiras));
		tabelaCadeira.refresh();
	}
	
	public void despreencherTabelas(){
		tabelaFilmes.setItems(FXCollections.observableArrayList(new ArrayList<Filme>()));
		tabelaFilmes.refresh();
		
		tabelaSessoes.setItems(FXCollections.observableArrayList(new ArrayList<Sessao>()));
		tabelaSessoes.refresh();

		tabelaCadeira.setItems(FXCollections.observableArrayList(new ArrayList<Cadeira>()));
		tabelaCadeira.refresh();
		
		meiaEntradaCheckBox.setDisable(true);
		if(meiaEntradaCheckBox.isSelected()) {
			meiaEntradaCheckBox.setSelected(false);
		}
		btnComprar.setDisable(true);
	}
	
	public void selecionaMeia() {
		if(meiaEntradaCheckBox.isSelected()) {
			sessaoSelecionada.setValorDoIngresso(sessaoSelecionada.getValorDoIngresso()/2);
			tabelaSessoes.refresh();
		}
		else {
			sessaoSelecionada.setValorDoIngresso(sessaoSelecionada.getValorDoIngresso()*2);
			tabelaSessoes.refresh();
		}
	}
}
