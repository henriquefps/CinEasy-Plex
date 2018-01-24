package controladores;

import java.time.LocalTime;

import beans.Filme;
import fachada.CinemaFachada;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

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
		try {
			if (!tituloTextField.getText().equals("") && !generoTextField.getText().equals("")
					&& !duracao_horaTextField.getText().equals("") && !duracao_minutoTextField.getText().equals("")
					&& !classificacaoTextField.getText().equals("")) {
				if (Integer.parseInt(duracao_minutoTextField.getText()) < 60
						&& Integer.parseInt(duracao_minutoTextField.getText()) >= 0) {

					CinemaFachada.getInstance()
							.cadastrarFilme(new Filme(tituloTextField.getText(), generoTextField.getText(),
									LocalTime.of(Integer.parseInt(duracao_horaTextField.getText()),
											Integer.parseInt(duracao_minutoTextField.getText())),
									classificacaoTextField.getText()));

					tituloTextField.setText("");
					generoTextField.setText("");
					duracao_horaTextField.setText("");
					duracao_minutoTextField.setText("");
					classificacaoTextField.setText("");
					
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("CinEasy Plex");
					alert.setHeaderText(null);
					alert.setContentText("Filme cadastrado com sucesso!");
					alert.showAndWait();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
