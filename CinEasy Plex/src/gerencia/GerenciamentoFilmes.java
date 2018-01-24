package gerencia;

import java.util.ArrayList;

import beans.Filme;
import exceptions.ObjetoJaExisteException;
import exceptions.ObjetoNaoExisteException;
import interfaces.IRepositorioFilmes;

public class GerenciamentoFilmes {
	private IRepositorioFilmes instance;
	
	public GerenciamentoFilmes(IRepositorioFilmes instance) {
		this.instance = instance;
	}
	
	public void cadastrar(Filme obj) throws Exception {
		if(obj != null) {
			if(existe(obj))
				throw new ObjetoJaExisteException("Este Filme j� existe");
			else
				instance.cadastrar(obj);
		}
		else
			throw new IllegalArgumentException("Filme Inv�lido");
		
	}
	
	public void alterar(Filme newObj) throws Exception {
		if(newObj != null) {
			if(!existe(newObj))
				throw new ObjetoNaoExisteException("Este Filme n�o existe");
			else
				instance.atualizar(newObj);
		}
		else
			throw new IllegalArgumentException("Filme Inv�lido");
	}
	
	public void remover(Filme obj) throws Exception {
		if(obj != null) {
			if(!existe(obj))
				throw new ObjetoNaoExisteException("Este Filme n�o existe");
			else
				instance.remover(obj);
		}
		else
			throw new IllegalArgumentException("Filme Inv�lido");
	}
	
	public Filme buscar(int id) throws Exception {
		Filme res = null;
		if(id < 0)
			throw new IllegalArgumentException("ID Inv�lido");
		else {
			res = instance.buscar(id);
		}
		
		return res;
	}
	
	public ArrayList<Filme> listarTodos() {
		return instance.listarTodos();
		
	}
	
	public boolean existe(Filme obj) {
		boolean res = false;
		if(obj != null) {
			ArrayList<Filme> Filmes = listarTodos();
			if(Filmes.contains(obj))
				res = true;
		}
		
		return res;
	
	}
	
	public ArrayList<Filme> pesquisarPorTitulo(String s) {
		if(s != null) {
			ArrayList<Filme> c = instance.buscarPorFilme(s);
			return c;
		}
		else
			throw new IllegalArgumentException("T�tulo Inv�lido");
	}
}
