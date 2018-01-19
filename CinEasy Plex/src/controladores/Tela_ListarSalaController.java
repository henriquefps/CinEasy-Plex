package controladores;

import java.net.URL;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.ResourceBundle;

import beans.Sala;
import beans.Sala;
import fachada.CinemaFachada;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;

public class Tela_ListarSalaController implements Initializable{
	@FXML private TableView<Sala> tableViewSala;
	@FXML private TableColumn<Sala, String> colunaIdSala;//colunaTitulo;
	@FXML private TableColumn<Sala, String> colunaTipo;//colunaGenero;
	@FXML private TableColumn<Sala, String> colunaNumeroCadeiras;//colunaDuracao;
	@FXML private TableColumn<Sala, String> colunaClassificacao;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		preencherTabela();
		
	}
	@FXML public void voltarParaConfiguracoes(){
		ScreenManager.setScene(ScreenManager.getInstance().getTelaConfiguracao());
	}
	
	// Este método preenche a TableView da Cena
	private void preencherTabela(){
		// Esta primeira linha carrega todas as intancias do repositório, nesse caso, de salas.
		ArrayList<Sala> listaDeSalas = CinemaFachada.getInstance().listarTodasSala();
		
		// Os próximos 4 comandos são um pouco confusos, mas tudo o que você precisa prestar atenção são
		//<sala, String> Você vai trocar sala pela classe do atributo, E pode deixar a String, Pois vc vai chamar
		//		toString dos atributos que não forem strings, ou um String.valueOf
		// todasAsSalas é uma variável criada no final da linha 51
		// O método dentro do comando, com override, está aí o new Callback pede a implementação dele.
		// Na linha 52 você vai trocar o todasAsSalas por sua variavel todosOsX.getValue().getAtributo()
		// Se o atributo for um LocalTime/LocalDateTime, use o .toString()
		// Se o atributo for um int, byte, float, use String.ValueOf(todosOsX.getValue().getAtributo())
		colunaIdSala.setCellValueFactory(new Callback<CellDataFeatures<Sala,String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Sala, String> todasAsSalas) {
				return new SimpleStringProperty(todasAsSalas.getValue().getIdSala()+"");
				}
			});
		colunaTipo.setCellValueFactory(new Callback<CellDataFeatures<Sala,String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Sala, String> todasAsSalas) {
				return new SimpleStringProperty(todasAsSalas.getValue().getTipo().toString());
				}
			});
		colunaNumeroCadeiras.setCellValueFactory(new Callback<CellDataFeatures<Sala,String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Sala, String> todasAsSalas) {
				return new SimpleStringProperty(todasAsSalas.getValue().getQuantColunas() * todasAsSalas.getValue().getQuantLinhas() +"");
				}
			});
		
		//Depois de preparar cada coluna da tabela para receber os atributos de um arrayList
		// Basta usar o setItems e o refresh para carregar na tabela.
		// Não sei exatamente o que o método refresh faz, mas ele sozinho não atualiza a tabela após
		//		modificações no repositório, é necessário chamar todo o método preencher tabela.
		
		// Neste exemplo carreguei todos os campos de fimle, mas também pode fazer com menos campos, como fiz em
		// removersala e Alterar sala.
		tableViewSala.setItems(FXCollections.observableArrayList(listaDeSalas));
		tableViewSala.refresh();
	}
	
}
