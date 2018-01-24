package controladores;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScreenManager {
	// Instancias das scenas. Cada Stage(A janela do programa em si, nessa
	// implementaÃ§Ã£o sÃ³ temos um stage)
	// recebe uma cena.
	private Scene telaLogin;
	private Scene telaConfiguracao;
	private Scene telaMenuPrincipal;

	private Scene telaAdicionarConta;
	private Scene telaAlterarConta;
	private Scene telaRemover_ListarConta;

	private Scene telaAdicionarFilme;
	private Scene telaRemoverFilme;
	private Scene telaAlterarFilme;
	private Scene telaListarFilme;

	private Scene telaAdcionarSessao;
	private Scene telaRemoverSessao;
	private Scene telaAlterarSessao;
	private Scene telaListarSessao;

	private Scene telaAdicionarSala;
	private Scene telaListarSala;
	private Scene telaRemoverSala;
	private Scene telaAlterarSala;
	
	private Scene telaVendas;

	private Scene telaVenderIngresso;
	private static Stage mainStage;

	private static ScreenManager instance;

	private ScreenManager() {

	}

	public static ScreenManager getInstance() {
		if (instance == null) {
			instance = new ScreenManager();
		}
		return instance;
	}

	
	public static String formatarLocalDate(LocalDate a){
		return a.getDayOfMonth() + "/" + a.getMonthValue() + "/" + a.getYear();
	}
	public static String formatarLocalTime(LocalTime a){
		return a.getHour() + ":" + a.getMinute();
	}
	public static String formatarLocalDateTime(LocalDateTime a){
		return formatarLocalDate(a.toLocalDate()) + " às " + formatarLocalTime(a.toLocalTime());
	}
	public static String formatarDayOfWeek(DayOfWeek a){
		if(a.equals(DayOfWeek.MONDAY)){
			return "Segunda-Feira";
		} else if(a.equals(DayOfWeek.TUESDAY)){
			return "Terça-Feira";
		} else if(a.equals(DayOfWeek.WEDNESDAY)){
			return "Quarta-Feira";
		} else if(a.equals(DayOfWeek.THURSDAY)){
			return "Quinta-Feira";
		} else if(a.equals(DayOfWeek.FRIDAY)){
			return "Sexta-Feira";
		} else if(a.equals(DayOfWeek.SATURDAY)){
			return "Sábado";
		} else {
			return "Domingo";
		}  
	}
	
	public static void setScene(Scene a) {
		mainStage.setScene(a);
		mainStage.show();
	}

	public static Stage getMainStage() {
		return mainStage;
	}

	public void setMainStage(Stage stage) {
		mainStage = stage;
	}

	public Scene getTelaLogin() {
		try {
			if (telaLogin == null) { // Repare no IF.
				// Esta linha cria uma Scene a partir de um Root, O root Ã©
				// gerado pelo FXMLLoader e ele lanÃ§a uma exceÃ§Ã£o.
				telaLogin = new Scene(FXMLLoader.load(getClass().getResource("/graficos/Tela_Login.fxml")), 1280, 720);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return telaLogin;
	}

	public Scene getTelaConfiguracao() {
		try {
			if (telaConfiguracao == null) {
				telaConfiguracao = new Scene(
						FXMLLoader.load(getClass().getResource("/graficos/Tela_Configuracoes.fxml")), 1280, 720);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return telaConfiguracao;
	}

	public Scene getTelaMenuPrincipal() {
		try {
			if (telaMenuPrincipal == null) {
				telaMenuPrincipal = new Scene(
						FXMLLoader.load(getClass().getResource("/graficos/Tela_MenuPrincipal.fxml")), 1280, 720);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return telaMenuPrincipal;
	}

	public Scene getTelaAdicionarFilme() {
		try {
			if (telaAdicionarFilme == null) {
				telaAdicionarFilme = new Scene(
						FXMLLoader.load(getClass().getResource("/graficos/Tela_AdicionarFilme.fxml")), 1280, 720);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return telaAdicionarFilme;
	}

	public Scene getTelaRemoverFilme() {
		try {
			telaRemoverFilme = new Scene(FXMLLoader.load(getClass().getResource("/graficos/Tela_RemoverFilme.fxml")),
					1280, 720);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return telaRemoverFilme;
	}

	public Scene getTelaAlterarFilme() {
		try {
			telaAlterarFilme = new Scene(FXMLLoader.load(getClass().getResource("/graficos/Tela_AlterarFilme.fxml")),
					1280, 720);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return telaAlterarFilme;
	}

	public Scene getTelaListarFilme() {
		try {
			telaListarFilme = new Scene(FXMLLoader.load(getClass().getResource("/graficos/Tela_ListarFilme.fxml")),
					1280, 720);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return telaListarFilme;
	}

	/**
	 * @return the telaAdcionarSessao
	 */
	public Scene getTelaAdcionarSessao() {
		if (telaAdcionarSessao == null) {
			try {

				telaAdcionarSessao = new Scene(
						FXMLLoader.load(getClass().getResource("/graficos/Tela_AdicionarSessao.fxml")), 1280, 720);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return telaAdcionarSessao;
	}

	public Scene getTelaRemoverSessao() {
		if (telaRemoverSessao == null) {
			try {
				telaRemoverSessao = new Scene(
						FXMLLoader.load(getClass().getResource("/graficos/Tela_RemoverSessao.fxml")), 1280, 720);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return telaRemoverSessao;
	}

	public Scene getTelaAlterarSessao() {
		try {
			telaAlterarSessao = new Scene(FXMLLoader.load(getClass().getResource("/graficos/Tela_AlterarSessao.fxml")),
					1280, 720);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return telaAlterarSessao;
	}

	public Scene getTelaAdicionarSala() {

		try {
			telaAdicionarSala = new Scene(FXMLLoader.load(getClass().getResource("/graficos/Tela_AdicionarSala.fxml")),
					1280, 720);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return telaAdicionarSala;
	}

	public Scene getTelaListarSala() {
		try {
			telaListarSala = new Scene(FXMLLoader.load(getClass().getResource("/graficos/Tela_ListarSala.fxml")), 1280,
					720);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return telaListarSala;
	}

	public Scene getTelaListarSessao() {
		try {
			telaListarSessao = new Scene(FXMLLoader.load(getClass().getResource("/graficos/Tela_ListarSessao.fxml")),
					1280, 720);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return telaListarSessao;

	}

	public Scene getTelaVenderIngresso() {
		try {
			telaVenderIngresso = new Scene(
					FXMLLoader.load(getClass().getResource("/graficos/Tela_VenderIngresso.fxml")), 1280, 720);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return telaVenderIngresso;
	}

	public Scene getTelaAdicionarConta() {
		try {
			telaAdicionarConta = new Scene(
					FXMLLoader.load(getClass().getResource("/graficos/Tela_AdicionarConta.fxml")), 1280, 720);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return telaAdicionarConta;
	}

	public Scene getTelaAlterarConta() {
		try {
			telaAlterarConta = new Scene(FXMLLoader.load(getClass().getResource("/graficos/Tela_AlterarConta.fxml")),
					1280, 720);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return telaAlterarConta;
	}

	public Scene getTelaRemover_ListarConta() {
		try {
			telaRemover_ListarConta = new Scene(
					FXMLLoader.load(getClass().getResource("/graficos/Tela_Remover_ListarContas.fxml")), 1280, 720);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return telaRemover_ListarConta;
	}

	public Scene getTelaRemoverSala() {
		try {
			telaRemoverSala = new Scene(
					FXMLLoader.load(getClass().getResource("/graficos/Tela_RemoverSala.fxml")), 1280, 720);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return telaRemoverSala;
	}

	public Scene getTelaAlterarSala() {
		try {
			telaAlterarSala = new Scene(
					FXMLLoader.load(getClass().getResource("/graficos/Tela_AlterarSala.fxml")), 1280, 720);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return telaAlterarSala;
	}

	public Scene getTelaVendas() {
		try {
			telaVendas = new Scene(
					FXMLLoader.load(getClass().getResource("/graficos/Tela_VerVendas.fxml")), 1280, 720);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return telaVendas;
	}

}