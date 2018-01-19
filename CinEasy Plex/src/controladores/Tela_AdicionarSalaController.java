package controladores;

import java.util.ArrayList;

import beans.Sala;
import beans.TipoSala;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;

public class Tela_AdicionarSalaController {
	
	Sala a = new Sala();
	ObservableList<TipoSala> tiposSalaS = FXCollections.observableArrayList(TipoSala.values());
	
	@FXML TextField id;
	@FXML ChoiceBox tipoSala;
	@FXML Spinner linhas;
	@FXML Spinner colunas;
	@FXML CheckBox d3;
	

	@FXML private void initialize()
	{	
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

		
	a = new Sala((int) linhas.getValue(), (int) colunas.getValue(), (TipoSala) tipoSala.getValue(), d3.isSelected());
	System.out.println(a.toString());
	
	}

	
	



}
