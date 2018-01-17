package repositorios;

import java.util.ArrayList;

import beans.Conta;
import interfaces.IRepositorio;

public class RepositorioContas implements IRepositorio<Conta> {

	private static RepositorioContas instance;
	private ArrayList<Conta> repositorio;
	
	private RepositorioContas() {
		repositorio = new ArrayList<>();
	}
	

	public static RepositorioContas getInstance(){
		if(instance == null){
			instance = new RepositorioContas();
		}
		return instance;
	}


	@Override
	public void cadastrar(Conta obj) {
		repositorio.add(obj);
	}


	@Override
	public void atualizar(Conta newObj) {
		repositorio.set(newObj.getIdConta(), newObj);
		
	}


	@Override
	public void remover(Conta obj) {
		repositorio.remove(obj.getIdConta());
		
	}


	@Override
	public Conta buscar(int id) {
		return repositorio.get(id);
	}


	@Override
	public ArrayList<Conta> listarTodos() {
		return repositorio;
	}
	
	

}
