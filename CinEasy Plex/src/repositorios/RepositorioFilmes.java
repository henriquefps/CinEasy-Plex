package repositorios;

import beans.Filme;
import interfaces.IRepositorioFilmes;

public class RepositorioFilmes implements IRepositorioFilmes{

	private static RepositorioFilmes instance;
	
	private RepositorioFilmes() {

	}
	

	public static RepositorioFilmes getInstance(){
		if(instance == null){
			instance = new RepositorioFilmes();
		}
		return instance;
	}
	@Override
	public void cadastrar(Filme a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Filme a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listar() {
		// TODO Auto-generated method stub
		
	}

}
