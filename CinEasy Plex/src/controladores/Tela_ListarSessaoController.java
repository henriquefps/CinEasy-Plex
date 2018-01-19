package controladores;

import java.beans.PropertyDescriptor;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.ResourceBundle;

import com.sun.javafx.property.PropertyReference;

import beans.Filme;
import beans.Sessao;
import fachada.CinemaFachada;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Tela_ListarSessaoController implements Initializable {

	@FXML private TableView<Sessao> tvSessao;
	@FXML private TableColumn<Sessao, Integer> id;
	@FXML private TableColumn<Sessao, String> filme;
	@FXML private TableColumn<Sessao, LocalDate> data;
	@FXML private TableColumn<Sessao, LocalTime> duracao;
	@FXML private TableColumn<Sessao, LocalTime> horaInicio;
	@FXML private TableColumn<Sessao, LocalTime> horaFim;
	@FXML private TableColumn<Sessao, Integer> sala;
	private CinemaFachada f;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		f = CinemaFachada.getInstance();
		preencherTabela();
	}
	
	@FXML
	public void voltarParaConfiguracoes() {
		ScreenManager.setScene(ScreenManager.getInstance().getTelaConfiguracao());
	}
	
	public void preencherTabela(){
		id.setCellValueFactory(new PropertyValueFactory<>("idSessao"));
		filme.setCellValueFactory(new PropertyValueFactory<>("titulo"));
		tvSessao.setItems(FXCollections.observableArrayList(f.listarTodasSessao()));
	}
	
	

}
