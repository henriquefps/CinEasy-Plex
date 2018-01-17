package gerencia;

import java.time.LocalDateTime;
import java.util.ArrayList;

import beans.Cadeira;
import beans.Filme;
import beans.Sala;
import beans.Sessao;
import interfaces.IRepositorio;
import interfaces.IRepositorioSessoes;
import repositorios.RepositorioSessoes;

public class GerenciamentoSessoes {
private IRepositorio<Sessao> instance = RepositorioSessoes.getInstance();
	
	public void criarSessao(int idSessao,Filme filmeExibido, Sala salaDeExibicao, float valorDoIngresso, LocalDateTime inicioDaSessao) throws Exception{
		// TODO criar um objeto e salvar no repositorio pela interface
			instance.cadastrar(new Sessao(idSessao, filmeExibido,salaDeExibicao,valorDoIngresso,inicioDaSessao));
	}
	
	public void removerSessao(Sessao e) throws Exception{
		// TODO
		instance.remover(e);
	}
	
	public void listarSessoes() {
		// TODO retornar o repositorio
		instance.listarTodos();
	}
	
	public void atualizarSessao(int idSessao,Filme filmeExibido, Sala salaDeExibicao, float valorDoIngresso, LocalDateTime inicioDaSessao){
		try {
			instance.atualizar(new Sessao(idSessao, filmeExibido,salaDeExibicao,valorDoIngresso,inicioDaSessao));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Sessao> listarSessoesPorFilme(Filme a){
		//TODO
		return null;
	}
	
	public ArrayList<Cadeira> listarCadeirasDaSessao(Sessao a){
		// TODO
		return null;
	}
}
