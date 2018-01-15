package repositorios;

import beans.Conta;
import interfaces.IRepositorioContas;

public class RepositorioContas implements IRepositorioContas {

	private static RepositorioContas instance;
	
	private RepositorioContas() {

	}
	

	public static RepositorioContas getInstance(){
		if(instance == null){
			instance = new RepositorioContas();
		}
		return instance;
	}
	
	@Override
	public void cadastrar(Conta a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Conta a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listar() {
		// TODO Auto-generated method stub
		
	}
	

}
