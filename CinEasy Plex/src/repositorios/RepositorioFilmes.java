package repositorios;

import java.util.ArrayList;

import beans.Filme;
import interfaces.IRepositorioFilmes;

public class RepositorioFilmes implements IRepositorioFilmes{

	private static RepositorioFilmes instance;
	private ArrayList<Filme> listaDeFilmes;
	
	private RepositorioFilmes() {
		listaDeFilmes = new ArrayList<Filme>();
	}
	

	public static RepositorioFilmes getInstance(){
		if(instance == null){
			instance = new RepositorioFilmes();
		}
		return instance;
	}
	@Override
	public void cadastrar(Filme a) {
		listaDeFilmes.add(a);
	}

	@Override
	public void remover(Filme a) {
		listaDeFilmes.remove(a);
		
	}

	@Override
	public ArrayList<Filme> listar() {
		return listaDeFilmes;
	}

}
