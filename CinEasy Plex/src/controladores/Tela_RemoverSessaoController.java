package controladores;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import beans.Sessao;
import fachada.CinemaFachada;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class Tela_RemoverSessaoController implements Initializable {

	@FXML
	private TableView<Sessao> tvSessao;
	@FXML
	private TableColumn<Sessao, Integer> id;
	@FXML
	private TableColumn<Sessao, String> filme;
	@FXML
	private TableColumn<Sessao, String> data;
	@FXML
	private TableColumn<Sessao, String> duracao;
	@FXML
	private TableColumn<Sessao, String> horaFim;
	@FXML
	private TableColumn<Sessao, String> sala;
	@FXML
	private TextField tfFilme, tfIdSala;

	private Sessao sessaoAtual;
	private ArrayList<Sessao> todasSessao;

	private CinemaFachada f;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		f = CinemaFachada.getInstance();
		todasSessao = f.listarTodasSessao();
		preencherTabela(todasSessao);
		tvSessao.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Sessao>() {

			@Override
			public void changed(ObservableValue<? extends Sessao> arg0, Sessao arg1, Sessao arg2) {
				// TODO Auto-generated method stub
				if (arg2 != null)
					sessaoAtual = arg2;
			}

		});

	}

	@FXML
	public void removerSessao() {
		try {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Remover Sala");
			alert.setHeaderText("Deseja remover a sessão do filme " + sessaoAtual.getFilmeExibido().getTitulo() + " no dia "
					+ ScreenManager.formatarLocalDateTime(sessaoAtual.getInicioDaSessao()) + "?");
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				f.removerSessao(sessaoAtual);
				
				alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("CinEasy Plex");
				alert.setHeaderText(null);
				alert.setContentText("Sessão removida com sucesso!");
				alert.showAndWait();
				
				preencherTabela(todasSessao);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erro!");
			alert.setHeaderText("Remorção inválida");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
		todasSessao = f.listarTodasSessao();
		preencherTabela(todasSessao);
	}

	@FXML
	public void pesquisarFilme() {
		String titulo = tfFilme.getText();
		todasSessao = f.buscarSessaoPorTitulo(titulo);
		preencherTabela(todasSessao);
	}

	@FXML
	public void pesquisarSala() {
		int valor1 = Integer.parseInt(tfIdSala.getText());
		todasSessao = f.buscarSessaoPorSala((byte) valor1);
		preencherTabela(todasSessao);
	}

	@FXML
	public void listarTodas() {
		todasSessao = f.listarTodasSessao();
		preencherTabela(todasSessao);
	}

	@FXML
	public void voltarParaConfiguracoes() {
		ScreenManager.setScene(ScreenManager.getInstance().getTelaConfiguracao());
	}

	public void preencherTabela(ArrayList<Sessao> todasSessoes) {
		id.setCellValueFactory(new PropertyValueFactory<>("idSessao"));
		filme.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<Sessao, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(CellDataFeatures<Sessao, String> param) {
						// TODO Auto-generated method stub
						return new SimpleStringProperty(param.getValue().getFilmeExibido().getTitulo());
					}
				});
		data.setCellValueFactory(new Callback<CellDataFeatures<Sessao, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Sessao, String> todosAsSessoes) {
				return new SimpleStringProperty(ScreenManager.formatarLocalDateTime(todosAsSessoes.getValue().getInicioDaSessao()));
			}
		});
		horaFim.setCellValueFactory(new Callback<CellDataFeatures<Sessao, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Sessao, String> todosAsSessoes) {
				return new SimpleStringProperty(ScreenManager.formatarLocalDateTime(todosAsSessoes.getValue().getFimDaSessao()));
			}
		});
		duracao.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<Sessao, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(CellDataFeatures<Sessao, String> arg0) {
						// TODO Auto-generated method stub
						return new SimpleStringProperty(arg0.getValue().getFilmeExibido().getDuracao().toString());
					}
				});
		sala.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Sessao, String>, ObservableValue<String>>() {

			@Override
			public ObservableValue<String> call(CellDataFeatures<Sessao, String> arg0) {
				// TODO Auto-generated method stub
				return new SimpleStringProperty(arg0.getValue().getSalaDeExibicao().getTipo().toString());
			}
		});
		tvSessao.setItems(FXCollections.observableArrayList(todasSessoes));
	}

}
