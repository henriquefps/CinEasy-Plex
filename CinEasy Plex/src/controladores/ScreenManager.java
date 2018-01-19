package controladores;

import java.io.IOException;

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

	// Coloca o Stage para mostrar a Cena a. Ã‰ necessÃ¡rio chamar o setScene(a) e
	// depois o
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
		// TODO tela Adicionar Sessao
		if (telaAdcionarSessao == null) {
			try {

				telaAdcionarSessao = new Scene(
						FXMLLoader.load(getClass().getResource("/graficos/Tela_AdicionarSessao.fxml")), 1280, 720);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return telaAdcionarSessao;
	}

	public Scene getTelaRemoverSessao() {
		// TODO tela Remover Sessao
		if (telaRemoverSessao == null) {
			try {
				telaRemoverSessao = new Scene(
						FXMLLoader.load(getClass().getResource("/graficos/Tela_RemoverSessao.fxml")), 1280, 720);
			} catch (IOException e) {
				// TODO Auto-generated catch block
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
			telaAdicionarSala = new Scene(FXMLLoader.load(getClass().getResource("/graficos/Tela_AdicionarSala.fxml")), 1280,720);
			
		
		}
	catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return telaAdicionarSala;
	}
	
	public Scene getTelaListarSala() {
		try {
			telaListarFilme = new Scene(FXMLLoader.load(getClass().getResource("/graficos/Tela_ListarSala.fxml")),
					1280, 720);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return telaListarFilme;
	}


	public Scene getTelaListarSessao() {
		// TODO
		return null;
	}
}