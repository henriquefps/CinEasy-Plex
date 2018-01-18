package repositorios;

import java.util.ArrayList;

import beans.Filme;
import interfaces.IRepositorioFilmes;

public class RepositorioFilmes implements IRepositorioFilmes{

	private static RepositorioFilmes instance;
	private ArrayList<Filme> listaDeFilmes;
	private static int id;
	
	private RepositorioFilmes() {
		listaDeFilmes = new ArrayList<Filme>();
		id = 0;
	}
	

	public static RepositorioFilmes getInstance(){
		if(instance == null){
			instance = new RepositorioFilmes();
		}
		return instance;
	}
	@Override
	public void cadastrar(Filme a) {
		id += 1;
		a.setIdFilme(id);
		listaDeFilmes.add(a);
	}

	@Override
	public void remover(Filme a) {
		listaDeFilmes.remove(a);
		
	}

	@Override
	public ArrayList<Filme> listarTodos() {
		return listaDeFilmes;
	}


	@Override
	public void atualizar(Filme newObj) {
		listaDeFilmes.set(newObj.getIdFilme()-1, newObj);	
	}


	@Override
	public Filme buscar(int id) {
		return listaDeFilmes.get(id-1);
	}

	@Override
	public ArrayList<Filme> buscarPorFilme(String titulo) {
		ArrayList<Filme> filmes = new ArrayList<>();
		for (Filme filme : listaDeFilmes) {
			if(filme.getTitulo().contains(titulo))
				filmes.add(filme);
		}
		
		return filmes;
	}

}
