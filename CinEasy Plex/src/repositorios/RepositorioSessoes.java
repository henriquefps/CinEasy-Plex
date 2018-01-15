package repositorios;

import beans.Sessao;
import beans.Venda;
import interfaces.IRepositorioSessoes;
import interfaces.IRepositorioVendas;

public class RepositorioSessoes implements IRepositorioSessoes{

	private static RepositorioSessoes instance;
	
	private RepositorioSessoes() {

	}
	

	public static RepositorioSessoes getInstance(){
		if(instance == null){
			instance = new RepositorioSessoes();
		}
		return instance;
	}
	@Override
	public void cadastrar(Sessao a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Sessao a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listar() {
		// TODO Auto-generated method stub
		
	}
	
}
