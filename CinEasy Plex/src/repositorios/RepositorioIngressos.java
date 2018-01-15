package repositorios;

import beans.Ingresso;
import interfaces.IRepositorioIngressos;

public class RepositorioIngressos implements IRepositorioIngressos{

	private static RepositorioIngressos instance;
	
	private RepositorioIngressos() {

	}
	

	public static RepositorioIngressos getInstance(){
		if(instance == null){
			instance = new RepositorioIngressos();
		}
		return instance;
	}
	@Override
	public void cadastrar(Ingresso a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Ingresso a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listar() {
		// TODO Auto-generated method stub
		
	}

}
