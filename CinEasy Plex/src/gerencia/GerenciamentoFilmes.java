package gerencia;

import java.util.ArrayList;

import beans.Filme;
import exceptions.ObjetoJaExisteException;
import exceptions.ObjetoNaoExisteException;
import interfaces.IRepositorioFilmes;
import repositorios.RepositorioFilmes;

public class GerenciamentoFilmes {
	private IRepositorioFilmes instance = RepositorioFilmes.getInstance();
	
	public void cadastrar(Filme obj) throws Exception {
		if(obj != null) {
			if(existe(obj))
				throw new ObjetoJaExisteException("Este Filme já existe");
			else
				instance.cadastrar(obj);
		}
		else
			throw new IllegalArgumentException("Filme Inválido");
		
	}
	
	public void alterar(Filme newObj) throws Exception {
		if(newObj != null) {
			if(!existe(newObj))
				throw new ObjetoNaoExisteException("Este Filme não existe");
			else
				instance.atualizar(newObj);
		}
		else
			throw new IllegalArgumentException("Filme Inválido");
	}
	
	public void remover(Filme obj) throws Exception {
		if(obj != null) {
			if(!existe(obj))
				throw new ObjetoNaoExisteException("Este Filme não existe");
			else
				instance.remover(obj);
		}
		else
			throw new IllegalArgumentException("Filme Inválido");
	}
	
	public Filme buscar(int id) throws Exception {
		Filme res = null;
		if(id < 0)
			throw new IllegalArgumentException("ID Inválido");
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
			throw new IllegalArgumentException("Título Inválido");
	}
}
