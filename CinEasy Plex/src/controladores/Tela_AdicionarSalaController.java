package controladores;

import java.util.ArrayList;

import beans.Sala;
import beans.TipoSala;
import fachada.CinemaFachada;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.paint.Color;

public class Tela_AdicionarSalaController {

	Sala a = new Sala();
	ObservableList<TipoSala> tiposSalaS = FXCollections.observableArrayList(TipoSala.values());

	@FXML
	TextField id;
	@FXML
	ChoiceBox<TipoSala> tipoSala;
	@FXML
	Spinner<Integer> linhas;
	@FXML
	Spinner<Integer> colunas;
	@FXML
	CheckBox d3;
	@FXML
	Label texto;

	@FXML
	private void initialize() {
		tipoSala.setItems(tiposSalaS);

		SpinnerValueFactory<Integer> valor = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 20);
		SpinnerValueFactory<Integer> valor1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 20);
		this.linhas.setValueFactory(valor);
		this.colunas.setValueFactory(valor1);

	}

	@FXML
	public void voltarParaConfiguracoes() {
		ScreenManager.setScene(ScreenManager.getInstance().getTelaConfiguracao());
	}

	@FXML
	public void cadastrarSala() {

		try {
			a = new Sala((int) linhas.getValue(), (int) colunas.getValue(), (TipoSala) tipoSala.getValue(),
					d3.isSelected());
			System.out.println(a.toString());
			CinemaFachada.getInstance().cadastrarSala(a);
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Cadastrar Sala");
			alert.setHeaderText(null);
			alert.setContentText("Salaa cadastrada com sucesso!");
			alert.showAndWait();

		} catch (Exception e) {

			texto.setTextFill(Color.RED);
			texto.setText("Um erro ocorreu!");

		}

		tipoSala.setValue(null);
		linhas.getValueFactory().setValue(0);

		colunas.getValueFactory().setValue(0);

		d3.setSelected(false);
	}

}
