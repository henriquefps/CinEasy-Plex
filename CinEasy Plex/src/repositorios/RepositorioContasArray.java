package repositorios;

import java.util.ArrayList;

import beans.Conta;
import interfaces.IRepositorioContas;

public class RepositorioContasArray implements IRepositorioContas {

	private static RepositorioContasArray instance;
	private ArrayList<Conta> repositorio;
	
	private RepositorioContasArray() {
		repositorio = new ArrayList<>();
	}
	

	public static RepositorioContasArray getInstance(){
		if(instance == null){
			instance = new RepositorioContasArray();
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


	@Override
	public Conta pesquisarPorNome(String s) {
		Conta res = null;
		for (Conta conta : repositorio) {
			if(conta.getLogin().equals(s)) {
				res = conta;
				break;
			}
		}
		
		return res;
	}
	
	

}
