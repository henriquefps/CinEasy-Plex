package repositorios;

import beans.Sala;
import interfaces.IRepositorioSala;

public class RepositorioSalas implements IRepositorioSala{

	private static RepositorioSalas instance;
	
	private RepositorioSalas() {

	}
	

	public static RepositorioSalas getInstance(){
		if(instance == null){
			instance = new RepositorioSalas();
		}
		return instance;
	}
	@Override
	public void cadastrar(Sala a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Sala a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listar() {
		// TODO Auto-generated method stub
		
	}
	
}
