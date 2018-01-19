package controladores;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

import beans.Sessao;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Tela_ListarSessaoController implements Initializable {

	@FXML private TableView<Sessao> tvSessao;
	@FXML private TableColumn<Sessao, Integer> id;
	@FXML private TableColumn<Sessao, String> filme;
	@FXML private TableColumn<Sessao, LocalDate> data;
	@FXML private TableColumn<Sessao, LocalTime> duracao;
	@FXML private TableColumn<Sessao, LocalTime> horaInicio;
	@FXML private TableColumn<Sessao, LocalTime> horaFim;
	@FXML private TableColumn<Sessao, Integer> sala;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	public void voltarParaConfiguracoes() {
		ScreenManager.setScene(ScreenManager.getInstance().getTelaConfiguracao());
	}
	
	

}
