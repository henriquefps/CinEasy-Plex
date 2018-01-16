package controladores;

import java.time.LocalTime;

import fachada.Fachada;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Tela_AdicionarFilmeController {
	@FXML
	private TextField tituloTextField;
	@FXML
	private TextField generoTextField;
	@FXML
	private TextField duracao_horaTextField;
	@FXML
	private TextField duracao_minutoTextField;
	@FXML
	private TextField classificacaoTextField;

	@FXML
	public void voltarParaConfiguracoes() {
		ScreenManager.setScene(ScreenManager.getInstance().getTelaConfiguracao());
	}

	@FXML
	public void cadastrarFilme() {
		if (Integer.parseInt(duracao_minutoTextField.getText()) < 60
				&& Integer.parseInt(duracao_minutoTextField.getText()) >= 0) {
			
			Fachada.getInstance().criarFilme(
					tituloTextField.getText(), 
					generoTextField.getText(),
					LocalTime.of(Integer.parseInt(duracao_horaTextField.getText()),
						Integer.parseInt(duracao_minutoTextField.getText())),
					classificacaoTextField.getText());
			
			tituloTextField.setText("");
			generoTextField.setText("");
			duracao_horaTextField.setText("");
			duracao_minutoTextField.setText("");
			classificacaoTextField.setText("");
		}
	}

}
