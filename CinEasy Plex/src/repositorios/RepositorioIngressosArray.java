package repositorios;

import java.util.ArrayList;

import beans.Ingresso;
import exceptions.ObjetoJaExisteException;
import exceptions.ObjetoNaoExisteException;
import interfaces.IRepositorio;

public class RepositorioIngressosArray implements IRepositorio<Ingresso>{

	private static IRepositorio<Ingresso> instance;
	private ArrayList<Ingresso> repositorio;
	
	private RepositorioIngressosArray() {
		repositorio = new ArrayList<>();
	}
	
	public static IRepositorio<Ingresso> getInstance(){
		if(instance == null){
			instance = new RepositorioIngressosArray();
		}
		return instance;
	}

	@Override
	public void cadastrar(Ingresso obj) {
		repositorio.add(obj.getIdIngresso(), obj);
	}

	@Override
	public void atualizar(Ingresso newObj) {
		repositorio.set(newObj.getIdIngresso(), newObj);
		
	}

	@Override
	public void remover(Ingresso obj) {
		repositorio.remove(obj.getIdIngresso());		
	}

	@Override
	public Ingresso buscar(int id) {
		return repositorio.get(id);
		
	}
	

	@Override
	public ArrayList<Ingresso> listarTodos() {
		return repositorio;
	}
	
}
