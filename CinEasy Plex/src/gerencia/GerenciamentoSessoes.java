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
	
	public void removerSessao(Sessao e){
		// TODO
		try {
			instance.remover(e);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public ArrayList<Sessao> listarSessoes() {
		// TODO retornar o repositorio
		return instance.listarTodos();
	}
	
	public void atualizarSessao(int idSessao,Filme filmeExibido, Sala salaDeExibicao, float valorDoIngresso, LocalDateTime inicioDaSessao){
		try {
			instance.atualizar(new Sessao(idSessao, filmeExibido,salaDeExibicao,valorDoIngresso,inicioDaSessao));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Sessao> listarSessoesPorFilme(String titulo){
		//TODO lista todas as sessões pelo titulo do filme
		return instance.buscarPorFilme(titulo);
	}
	
	public ArrayList<Cadeira> listarCadeirasDaSessao(Sessao a){
		// TODO faltando fazer cadeiras
		return null;
	}
}
