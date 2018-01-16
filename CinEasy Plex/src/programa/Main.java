package programa;


import java.time.LocalTime;

import controladores.ScreenManager;
import fachada.Fachada;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{
	public void scriptsDePovoamento(){
		// Filmes
		Fachada.getInstance().criarFilme("Logan", "Ação", LocalTime.of(2, 15), "18");
		Fachada.getInstance().criarFilme("Titanic", "Drama", LocalTime.of(3, 10), "14");
		Fachada.getInstance().criarFilme("Thor: Ragnarok", "Comédia", LocalTime.of(2, 0), "3");
		Fachada.getInstance().criarFilme("It: A Coisa", "Terror", LocalTime.of(2, 10), "18");
		// Salas
		
		// Contas
		Fachada.getInstance().criarConta("adm", "adm");
		
		// Sessoes
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			ScreenManager.getInstance().setMainStage(primaryStage);
			ScreenManager.getMainStage().setTitle("Cine EasyPlex");
			ScreenManager.getMainStage().setResizable(false);
			ScreenManager.setScene(ScreenManager.getInstance().getTelaMenuPrincipal());
			scriptsDePovoamento();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
			launch(args);
		
	}
}
