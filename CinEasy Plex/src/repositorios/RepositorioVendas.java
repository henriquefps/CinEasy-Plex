package repositorios;

import beans.Venda;
import interfaces.IRepositorioVendas;

public class RepositorioVendas implements IRepositorioVendas{

	private static RepositorioVendas instance;
	
	private RepositorioVendas() {

	}
	

	public static RepositorioVendas getInstance(){
		if(instance == null){
			instance = new RepositorioVendas();
		}
		return instance;
	}
	@Override
	public void cadastrar(Venda a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Venda a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listar() {
		// TODO Auto-generated method stub
		
	}

}
