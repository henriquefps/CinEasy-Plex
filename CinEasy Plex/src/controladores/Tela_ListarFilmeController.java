package controladores;

import java.net.URL;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.ResourceBundle;

import beans.Filme;
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

public class Tela_ListarFilmeController implements Initializable{
	@FXML private TableView<Filme> tableViewFilmes;
	@FXML private TableColumn<Filme, String> colunaTitulo;
	@FXML private TableColumn<Filme, String> colunaGenero;
	@FXML private TableColumn<Filme, String> colunaDuracao;
	@FXML private TableColumn<Filme, String> colunaClassificacao;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		preencherTabela();
		
	}
	@FXML public void voltarParaConfiguracoes(){
		ScreenManager.setScene(ScreenManager.getInstance().getTelaConfiguracao());
	}
	
	// Este método preenche a TableView da Cena
	private void preencherTabela(){
		// Esta primeira linha carrega todas as intancias do repositório, nesse caso, de filmes.
		ArrayList<Filme> listaDeFilmes = CinemaFachada.getInstance().listarFilmes();
		
		// Os próximos 4 comandos são um pouco confusos, mas tudo o que você precisa prestar atenção são
		//<Filme, String> Você vai trocar Filme pela classe do atributo, E pode deixar a String, Pois vc vai chamar
		//		toString dos atributos que não forem strings, ou um String.valueOf
		// todosOsFilmes é uma variável criada no final da linha 51
		// O método dentro do comando, com override, está aí o new Callback pede a implementação dele.
		// Na linha 52 você vai trocar o todosOsFilmes por sua variavel todosOsX.getValue().getAtributo()
		// Se o atributo for um LocalTime/LocalDateTime, use o .toString()
		// Se o atributo for um int, byte, float, use String.ValueOf(todosOsX.getValue().getAtributo())
		colunaTitulo.setCellValueFactory(new Callback<CellDataFeatures<Filme,String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Filme, String> todosOsFilmes) {
				return new SimpleStringProperty(todosOsFilmes.getValue().getTitulo());
				}
			});
		colunaGenero.setCellValueFactory(new Callback<CellDataFeatures<Filme,String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Filme, String> todosOsFilmes) {
				return new SimpleStringProperty(todosOsFilmes.getValue().getGenero());
				}
			});
		colunaDuracao.setCellValueFactory(new Callback<CellDataFeatures<Filme,String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Filme, String> todosOsFilmes) {
				return new SimpleStringProperty(todosOsFilmes.getValue().getDuracao().toString());
				}
			});
		colunaClassificacao.setCellValueFactory(new Callback<CellDataFeatures<Filme,String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Filme, String> todosOsFilmes) {
				return new SimpleStringProperty(todosOsFilmes.getValue().getTitulo());
				}
			});
		
		//Depois de preparar cada coluna da tabela para receber os atributos de um arrayList
		// Basta usar o setItems e o refresh para carregar na tabela.
		// Não sei exatamente o que o método refresh faz, mas ele sozinho não atualiza a tabela após
		//		modificações no repositório, é necessário chamar todo o método preencher tabela.
		
		// Neste exemplo carreguei todos os campos de fimle, mas também pode fazer com menos campos, como fiz em
		// removerFilme e Alterar Filme.
		tableViewFilmes.setItems(FXCollections.observableArrayList(listaDeFilmes));
		tableViewFilmes.refresh();
	}
	
}
