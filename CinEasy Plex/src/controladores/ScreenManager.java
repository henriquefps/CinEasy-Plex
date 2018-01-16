package controladores;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScreenManager {
	private Scene telaLogin;
	private Scene telaConfiguracao;
	private Scene telaMenuPrincipal;
	private Scene telaAdicionarFilme;
	
	private static Stage mainStage;
	
	private static ScreenManager instance;
	
	private ScreenManager(){
		
	}
	
	public static ScreenManager getInstance(){
		if(instance == null){
			instance = new ScreenManager(); 
		}
		return instance;
	}

	public static void setScene(Scene a){
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
		try{
			if(telaLogin == null){
				telaLogin = new Scene(FXMLLoader.load(getClass().getResource("/graficos/Tela_Login.fxml")), 1280, 720);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return telaLogin;
	}

	public Scene getTelaConfiguracao() {
		try{
			if(telaConfiguracao == null){
				telaConfiguracao = new Scene(FXMLLoader.load(getClass().getResource("/graficos/Tela_Configuracoes.fxml")), 1280, 720);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return telaConfiguracao;
	}

	public Scene getTelaMenuPrincipal() {
		try{
			if(telaMenuPrincipal == null){
				telaMenuPrincipal = new Scene(FXMLLoader.load(getClass().getResource("/graficos/Tela_MenuPrincipal.fxml")), 1280, 720);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return telaMenuPrincipal;
	}

	public Scene getTelaAdicionarFilme() {try{
		if(telaAdicionarFilme == null){
			telaAdicionarFilme = new Scene(FXMLLoader.load(getClass().getResource("/graficos/Tela_AdicionarFilme.fxml")), 1280, 720);
		}
	}catch (Exception e) {
		e.printStackTrace();
	}
	return telaAdicionarFilme;
	}

	
}
