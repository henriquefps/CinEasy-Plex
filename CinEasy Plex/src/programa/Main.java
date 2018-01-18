package programa;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import beans.Filme;
import beans.Sala;
import beans.Sessao;
import beans.TipoSala;
import beans.TipoVisual;
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
		try {
			CinemaFachada.getInstance().cadastrarSala(new Sala((byte) 1, 20, 20, TipoSala.Convencional, TipoVisual.D2));
			CinemaFachada.getInstance().cadastrarSala(new Sala((byte) 2, 20, 20, TipoSala.IMAX, TipoVisual.D2));
			CinemaFachada.getInstance().cadastrarSala(new Sala((byte) 3, 20, 20, TipoSala.XD, TipoVisual.D3));
			CinemaFachada.getInstance().cadastrarSala(new Sala((byte) 4, 20, 20, TipoSala.Convencional, TipoVisual.D2));
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Contas
		
		// Sessoes
		try {
			CinemaFachada.getInstance().cadastrarSessao(new Sessao(1,new Filme("Logan", "Ação", LocalTime.of(2, 15), "18") , new Sala((byte) 1, 20, 20, TipoSala.Convencional, TipoVisual.D2), 10, LocalDateTime.of(LocalDate.of(2018, 1, 19),LocalTime.of(14, 20))));
			CinemaFachada.getInstance().cadastrarSessao(new Sessao(2,new Filme("It: A Coisa", "Terror", LocalTime.of(2, 10), "18") , new Sala((byte) 1, 20, 20, TipoSala.Convencional, TipoVisual.D2), 10, LocalDateTime.of(LocalDate.of(2018, 1, 19),LocalTime.of(18, 20))));
			CinemaFachada.getInstance().cadastrarSessao(new Sessao(3,new Filme("It: A Coisa", "Terror", LocalTime.of(2, 10), "18") , new Sala((byte) 1, 20, 20, TipoSala.Convencional, TipoVisual.D2), 10, LocalDateTime.of(LocalDate.of(2018, 1, 19),LocalTime.of(10, 20))));
			CinemaFachada.getInstance().cadastrarSessao(new Sessao(4,new Filme("Logan", "Ação", LocalTime.of(2, 15), "18") , new Sala((byte) 1, 20, 20, TipoSala.Convencional, TipoVisual.D2), 10, LocalDateTime.of(LocalDate.of(2018, 1, 19),LocalTime.of(8, 20))));
		} catch (Exception e) {
			e.printStackTrace();
		}
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
