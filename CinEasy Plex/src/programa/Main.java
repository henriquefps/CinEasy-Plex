package programa;


import java.time.LocalTime;

import beans.Filme;
import controladores.ScreenManager;
import fachada.CinemaFachada;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{
	public void scriptsDePovoamento(){
		// Filmes
		try {
			CinemaFachada.getInstance().cadastrarFilme(new Filme("Logan", "Ação", LocalTime.of(2, 15), "18"));
			CinemaFachada.getInstance().cadastrarFilme(new Filme("Titanic", "Drama", LocalTime.of(3, 10), "14"));
			CinemaFachada.getInstance().cadastrarFilme(new Filme("Thor: Ragnarok", "Comédia", LocalTime.of(2, 0), "3"));
			CinemaFachada.getInstance().cadastrarFilme(new Filme("It: A Coisa", "Terror", LocalTime.of(2, 10), "18"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Salas
		
		// Contas
		
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
