package programa;


import java.time.LocalDateTime;
import java.time.LocalTime;

import beans.Cadeira;
import beans.Conta;
import beans.Filme;
import beans.Ingresso;
import beans.Sala;
import beans.Sessao;
import beans.TipoSala;
import beans.Venda;
import controladores.ScreenManager;
import fachada.CinemaFachada;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	public void scriptsDePovoamento() {
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
			CinemaFachada.getInstance().cadastrarSala(new Sala(20, 20, TipoSala.Convencional, false));
			CinemaFachada.getInstance().cadastrarSala(new Sala(20, 20, TipoSala.IMAX, true));
			CinemaFachada.getInstance().cadastrarSala(new Sala(20, 20, TipoSala.XD, true));
			CinemaFachada.getInstance().cadastrarSala(new Sala(20, 20, TipoSala.Convencional, false));
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Contas
		try {
			CinemaFachada.getInstance().cadastrarConta(new Conta("0000", "0000"));
			CinemaFachada.getInstance().cadastrarConta(new Conta("0001", "0001"));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		// Sessoes
		try {
			CinemaFachada.getInstance().cadastrarSessao(new Sessao(CinemaFachada.getInstance().buscarFilme(1),
					CinemaFachada.getInstance().buscarSala(2), 50, LocalDateTime.of(2018, 1, 24, 14, 20)));
			CinemaFachada.getInstance().cadastrarSessao(new Sessao(CinemaFachada.getInstance().buscarFilme(1),
					CinemaFachada.getInstance().buscarSala(1), 50, LocalDateTime.of(2018, 1, 22, 14, 20)));
			CinemaFachada.getInstance().cadastrarSessao(new Sessao(CinemaFachada.getInstance().buscarFilme(4),
					CinemaFachada.getInstance().buscarSala(4), 50, LocalDateTime.of(2018, 1, 19, 14, 20)));
			CinemaFachada.getInstance().cadastrarSessao(new Sessao(CinemaFachada.getInstance().buscarFilme(2),
					CinemaFachada.getInstance().buscarSala(3), 50, LocalDateTime.of(2018, 1, 19, 14, 20)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Vendas
		try {
			Ingresso vendido = new Ingresso();
			vendido.setCadeiraVendida(new Cadeira(0, 1, false));
			vendido.setMeia(false);
			vendido.setSessao(CinemaFachada.getInstance().buscarSessao(0));
			vendido.setValorIngresso(CinemaFachada.getInstance().buscarSessao(0).getValorDoIngresso());
			CinemaFachada.getInstance().cadastrarVenda(new Venda(vendido, CinemaFachada.getInstance().buscarSessao(0)));
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
			ScreenManager.setScene(ScreenManager.getInstance().getTelaLogin());
			scriptsDePovoamento();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
