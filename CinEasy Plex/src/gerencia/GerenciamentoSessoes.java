package gerencia;

import java.time.LocalDateTime;
import java.util.ArrayList;

import beans.Filme;
import beans.Sala;
import beans.Sessao;
import interfaces.IRepositorioSessoes;
import repositorios.RepositorioSessoes;

public class GerenciamentoSessoes {
private IRepositorioSessoes instance = RepositorioSessoes.getInstance();
	
	public void criarSessao(Filme filmeExibido, Sala salaDeExibicao, float valorDoIngresso, LocalDateTime inicioDaSessao){
		// TODO criar um objeto e salvar no repositorio pela interface
	}
	
	public void removerSessao(Sessao e){
		// TODO
	}
	
	public void listarSessoes(){
		// TODO retornar o repositorio
	}
	
	public ArrayList<Sessao> listarSessoesPorFilme(Filme a){
		//TODO
	}
	
	public ArrayList<Cadeira> listarCadeirasDaSessao(Sessao a){
		// TODO
	}
}
