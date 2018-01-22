package controladores;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.ResourceBundle;

import beans.Filme;
import beans.Sala;
import beans.Sessao;
import beans.TipoSala;
import fachada.CinemaFachada;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.converter.LocalDateTimeStringConverter;
import javafx.util.converter.LocalTimeStringConverter;

public class Tela_AdicionarSessaoController implements Initializable{
	
	
	@FXML
	private DatePicker dtSessao;
	@FXML
	private Label filmeSelecionado, salaSelecionada;
	@FXML
	private TextField inicio_hr;
	@FXML
	private TextField inicio_min, valorIngresso;
	@FXML
	private TableView<Filme> tvFilmes;
	@FXML
	private TableColumn<Filme, String> titulo;
	@FXML
	private TableColumn<Filme, LocalDate> duracao ;
	@FXML
	private TableView<Sala> tvSalas;
	@FXML
	private TableColumn<Sala, Byte> id;
	@FXML
	private TableColumn<Sala, TipoSala> tipo;
	
	private Filme filmeAtual;
	private Sala salaAtual;
	
	private CinemaFachada f;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		f = CinemaFachada.getInstance();
		preencherTabelaFilme();
		preencherTabelaSala();
		tvFilmes.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Filme>(){

			@Override
			public void changed(ObservableValue<? extends Filme> arg0, Filme arg1, Filme arg2) {
				// TODO Auto-generated method stub
				if(arg2 != null)
					filmeSelecionado.setText(arg2.getTitulo());
				filmeAtual = arg2;
			}
			
		});
		
		tvSalas.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Sala>() {

			@Override
			public void changed(ObservableValue<? extends Sala> observable, Sala oldValue, Sala newValue) {
				// TODO Auto-generated method stub
				if(newValue != null)
					salaSelecionada.setText(newValue.getTipo().toString());
				salaAtual = newValue;
			}
		
		});
		
		dtSessao.valueProperty().addListener(new ChangeListener<LocalDate>() {

			@Override
			public void changed(ObservableValue<? extends LocalDate> observable, LocalDate oldValue,
					LocalDate newValue) {
				// TODO Auto-generated method stub
				LocalDate agora = LocalDate.now();
				if(newValue != null){
					if(newValue.isBefore(agora)){
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("Erro!");
						alert.setHeaderText("Data inválida!");
						alert.setContentText("Não é permitido marcar sessao antes do dia atual!");
						alert.showAndWait();
					}
				}	
			}
		});
	}
	
	@FXML
	public void cadastrarSessao(){  
		try {
			int valor1 = Integer.parseInt(inicio_hr.getText());
			int valor2 = Integer.parseInt(inicio_min.getText());
			float valor3 = Float.parseFloat(valorIngresso.getText());
			LocalDate i = dtSessao.getValue();
			LocalTime i2 = LocalTime.of(valor1, valor2);
			LocalDateTime inicioDaSessao = LocalDateTime.of(i, i2);
			
			f.cadastrarSessao(new Sessao(filmeAtual, salaAtual, valor3, inicioDaSessao));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			Alert a = new Alert(AlertType.ERROR);
			a.setTitle("Erro");
			a.setHeaderText("Horário ou Dia");
			a.setContentText("Parâmetro Inválido");
			a.showAndWait();
		} catch (NullPointerException e2){
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
		dtSessao.setValue(dtSessao.getValue().plusDays(1));
	}
	
	@FXML
	public void zerar(){
		inicio_hr.setPromptText("Hora");
		inicio_min.setPromptText("Min");
		inicio_hr.setText(null);
		inicio_min.setText(null);
		filmeSelecionado.setText(null);
		salaSelecionada.setText(null);
		dtSessao.setValue(null);
		valorIngresso.setText(null);
		valorIngresso.setPromptText("Preço");
	
	}
	@FXML
	public void voltarParaConfiguracoes() {
		ScreenManager.setScene(ScreenManager.getInstance().getTelaConfiguracao());
	}
	
	public void preencherTabelaFilme(){
		ArrayList<Filme> filmes = f.listarTodasFilme();		
		titulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
		duracao.setCellValueFactory(new PropertyValueFactory<>("duracao"));
		tvFilmes.setItems(FXCollections.observableArrayList(filmes));
	}
	
	public void preencherTabelaSala(){
		ArrayList<Sala> salas = f.listarTodasSala();
		tipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
		id.setCellValueFactory(new PropertyValueFactory<>("idSala"));
		tvSalas.setItems(FXCollections.observableArrayList(salas));
	}
}