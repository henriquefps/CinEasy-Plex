package controladores;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.ResourceBundle;

import beans.Filme;
import beans.Sala;
import beans.Sessao;
import fachada.CinemaFachada;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;

public class Tela_AlterarSessaoController implements Initializable {
	@FXML
	private TableView<Sessao> sessoesTableView;
	@FXML
	private TableView<Filme> filmesTableView;
	@FXML
	private TableView<Sala> salasTableView;

	@FXML
	private TableColumn<Sessao, String> colunaSessaoFilme;
	@FXML
	private TableColumn<Sessao, String> colunaSessaoSala;
	@FXML
	private TableColumn<Sessao, String> colunaSessaoHorario;
	@FXML
	private TableColumn<Filme, String> colunaFilmeFilme;
	@FXML
	private TableColumn<Filme, String> colunaFilmeDuracao;
	@FXML
	private TableColumn<Sala, String> colunaSalaSala;
	@FXML
	private TableColumn<Sala, String> colunaSalaTipo;

	@FXML
	private TextField diaTextField;
	@FXML
	private TextField mesTextField;
	@FXML
	private TextField anoTextField;
	@FXML
	private TextField horaInicioTextField;
	@FXML
	private TextField minutoInicioTextField;
	@FXML
	private TextField valorTextField;

	private Sessao sessaoSelecionada = null;
	private Filme filmeSelecionado = null;
	private Sala salaSelecionada = null;
	private CinemaFachada fachada;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		fachada = CinemaFachada.getInstance(); 
		preencherTabelaSessoes();
	}

	@FXML
	public void voltarParaConfiguracoes() {
		ScreenManager.setScene(ScreenManager.getInstance().getTelaConfiguracao());
	}

	@FXML
	public void selecionarSessao() {
		sessaoSelecionada = sessoesTableView.getSelectionModel().getSelectedItem();
		System.out.println(sessaoSelecionada.getFilmeExibido().getTitulo());
		preencherCampos();
		preencherTabelaFilmes();
		preencherTabelaSalas();
	}

	@FXML
	public void selecionarFilme() {
		filmeSelecionado = filmesTableView.getSelectionModel().getSelectedItem();
	}

	@FXML
	public void selecionarSala() {
		salaSelecionada = salasTableView.getSelectionModel().getSelectedItem();
	}

	@FXML
	public void salvarAlteracoes() {	
		if (sessaoSelecionada != null && filmeSelecionado != null && salaSelecionada != null
				&& !anoTextField.getText().equals("") && !mesTextField.getText().equals("")
				&& !diaTextField.getText().equals("") && !horaInicioTextField.getText().equals("")
				&& !minutoInicioTextField.getText().equals("")) {
			try {
				Filme f = filmeSelecionado;
				int val1 = Integer.parseInt(anoTextField.getText());
				int val2 = Integer.parseInt(mesTextField.getText());
				int val3 = Integer.parseInt(diaTextField.getText());
				int val4 = Integer.parseInt(horaInicioTextField.getText());
				int val5 = Integer.parseInt(minutoInicioTextField.getText());
				LocalDateTime l	= LocalDateTime.of(val1, val2,val3, val4,val5);
				Sala s = salaSelecionada;
				float val = Float.parseFloat(valorTextField.getText());
				
				Sessao newObj = new Sessao(f, s, val, l);
				newObj.setIdSessao(sessaoSelecionada.getIdSessao());
				
				fachada.alterarSessao(newObj);
			} catch (NumberFormatException e){
				Alert a = new Alert(AlertType.ERROR);
				a.setTitle("Erro");
				a.setHeaderText("Horário ou Dia");
				a.setContentText("Parâmetro Inválido");
				a.showAndWait();
			} catch(NullPointerException e2){
				Alert a = new Alert(AlertType.ERROR);
				a.setTitle("Erro");
				a.setHeaderText(null);
				a.setContentText("Preencha todos os dados");
				a.showAndWait();
			} catch (Exception e3){
				Alert a = new Alert(AlertType.ERROR);
				a.setTitle("Erro");
				a.setHeaderText(null);
				a.setContentText(e3.getMessage());
				a.showAndWait();
			}
		}	
		
		despreencherTabelasECampos();
		preencherTabelaSessoes();
		sessaoSelecionada = null;
		filmeSelecionado = null;
		salaSelecionada = null;
	
	}

	private void preencherTabelaSessoes() {
		ArrayList<Sessao> sessoes = new ArrayList<>(); 
		ArrayList<Sessao> s = CinemaFachada.getInstance().listarTodasSessao();
		for(int i = 0 ; i < s.size(); i++){
			if(!s.get(i).getInicioDaSessao().isBefore(LocalDateTime.now())){
				sessoes.add(s.get(i));
			}
		}

		colunaSessaoFilme
				.setCellValueFactory(new Callback<CellDataFeatures<Sessao, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(CellDataFeatures<Sessao, String> todosAsSessoes) {
						return new SimpleStringProperty(todosAsSessoes.getValue().getFilmeExibido().getTitulo());
					}
				});
		colunaSessaoHorario
				.setCellValueFactory(new Callback<CellDataFeatures<Sessao, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(CellDataFeatures<Sessao, String> todosAsSessoes) {
						return new SimpleStringProperty(ScreenManager.formatarLocalDateTime(todosAsSessoes.getValue().getInicioDaSessao()));
					}
				});
		colunaSessaoSala.setCellValueFactory(new Callback<CellDataFeatures<Sessao, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Sessao, String> todosAsSessoes) {
				return new SimpleStringProperty(Byte.toString(todosAsSessoes.getValue().getSalaDeExibicao().getIdSala())); 
				}
		});

		sessoesTableView.setItems(FXCollections.observableArrayList(sessoes));
		sessoesTableView.refresh();
	}

	private void preencherTabelaFilmes() {
		ArrayList<Filme> listaDeFilmes = CinemaFachada.getInstance().listarTodasFilme();
		colunaFilmeFilme.setCellValueFactory(new Callback<CellDataFeatures<Filme, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Filme, String> todosOsFilmes) {
				return new SimpleStringProperty(todosOsFilmes.getValue().getTitulo());
			}
		});
		colunaFilmeDuracao
				.setCellValueFactory(new Callback<CellDataFeatures<Filme, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(CellDataFeatures<Filme, String> todosOsFilmes) {
						return new SimpleStringProperty(todosOsFilmes.getValue().getDuracao().toString());
					}
				});
		filmesTableView.setItems(FXCollections.observableArrayList(listaDeFilmes));
		filmesTableView.refresh();
	}

	private void preencherTabelaSalas() {
		ArrayList<Sala> listaDeSalas = CinemaFachada.getInstance().listarTodasSala();
		colunaSalaSala.setCellValueFactory(new Callback<CellDataFeatures<Sala, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Sala, String> todosAsSalas) {
				return new SimpleStringProperty(String.valueOf(todosAsSalas.getValue().getIdSala()));
			}
		});
		colunaSalaTipo.setCellValueFactory(new Callback<CellDataFeatures<Sala, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Sala, String> todosAsSalas) {
				return new SimpleStringProperty(todosAsSalas.getValue().getTipo().toString());
			}
		});

		salasTableView.setItems(FXCollections.observableArrayList(listaDeSalas));
		salasTableView.refresh();
	}

	private void preencherCampos() {
		anoTextField.setText(String.valueOf(sessaoSelecionada.getInicioDaSessao().getYear()));
		mesTextField.setText(String.valueOf(sessaoSelecionada.getInicioDaSessao().getMonthValue()));
		diaTextField.setText(String.valueOf(sessaoSelecionada.getInicioDaSessao().getDayOfMonth()));
		horaInicioTextField.setText(String.valueOf(sessaoSelecionada.getInicioDaSessao().getHour()));
		minutoInicioTextField.setText(String.valueOf(sessaoSelecionada.getInicioDaSessao().getMinute()));
	}

	private void despreencherTabelasECampos() {
		ArrayList<Filme> listaDeFilmes = new ArrayList<Filme>();
		colunaFilmeFilme.setCellValueFactory(new Callback<CellDataFeatures<Filme, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Filme, String> todosOsFilmes) {
				return new SimpleStringProperty(todosOsFilmes.getValue().getTitulo());
			}
		});
		colunaFilmeDuracao
				.setCellValueFactory(new Callback<CellDataFeatures<Filme, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(CellDataFeatures<Filme, String> todosOsFilmes) {
						return new SimpleStringProperty(todosOsFilmes.getValue().getDuracao().toString());
					}
				});
		filmesTableView.setItems(FXCollections.observableArrayList(listaDeFilmes));
		filmesTableView.refresh();

		ArrayList<Sala> listaDeSalas = new ArrayList<Sala>();
		colunaSalaSala.setCellValueFactory(new Callback<CellDataFeatures<Sala, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Sala, String> todosAsSalas) {
				return new SimpleStringProperty(String.valueOf(todosAsSalas.getValue().getIdSala()));
			}
		});
		colunaSalaTipo.setCellValueFactory(new Callback<CellDataFeatures<Sala, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Sala, String> todosAsSalas) {
				return new SimpleStringProperty(todosAsSalas.getValue().getTipo().toString());
			}
		});

		salasTableView.setItems(FXCollections.observableArrayList(listaDeSalas));
		salasTableView.refresh();

		anoTextField.setText("");
		mesTextField.setText("");
		diaTextField.setText("");
		horaInicioTextField.setText("");
		minutoInicioTextField.setText("");
		valorTextField.setText("");
	}
}
