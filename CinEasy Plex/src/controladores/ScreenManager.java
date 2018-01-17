package controladores;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScreenManager {
	// Instancias das scenas. Cada Stage(A janela do programa em si, nessa implementação só temos um stage) 
	// recebe uma cena.
	private Scene telaLogin;
	private Scene telaConfiguracao;
	private Scene telaMenuPrincipal;
	private Scene telaAdicionarFilme;
	private Scene telaRemoverFilme;
	private Scene telaAlterarFilme;
	private Scene telaListarFilme;
	

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
	
	// Coloca o Stage para mostrar a Cena a. É necessário chamar o setScene(a) e depois o 
	// show() para atualizar a imagem da janela
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
			if (telaLogin == null) { //Repare no IF.
				//Esta linha cria uma Scene a partir de um Root, O root é gerado pelo FXMLLoader e ele lança uma exceção.
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
			// Nas telas que tem tabela eu não usei o if. Pois assim eu consigo atualizar a tabela usando o método
			// initialize da interface Initialize, esse método é chamado sempre que a Cena é criada.
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

}
