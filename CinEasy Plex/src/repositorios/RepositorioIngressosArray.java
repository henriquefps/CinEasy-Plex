package repositorios;

import java.util.ArrayList;

import beans.Ingresso;
import interfaces.IRepositorio;

public class RepositorioIngressosArray implements IRepositorio<Ingresso>{

	private static IRepositorio<Ingresso> instance;
	private ArrayList<Ingresso> repositorio;
	private static int id;
	
	private RepositorioIngressosArray() {
		repositorio = new ArrayList<>();
		id = 0;
	}
	
	public static IRepositorio<Ingresso> getInstance(){
		if(instance == null){
			instance = new RepositorioIngressosArray();
		}
		return instance;
	}

	@Override
	public void cadastrar(Ingresso obj) {
		id += 1;
		obj.setIdIngresso(id);
		repositorio.add(obj);
	}

	@Override
	public void atualizar(Ingresso newObj) {
		repositorio.set(newObj.getIdIngresso()-1, newObj);
		
	}

	@Override
	public void remover(Ingresso obj) {
		repositorio.remove(obj.getIdIngresso());		
	}

	@Override
	public Ingresso buscar(int id) {
		return repositorio.get(id-1);
		
	}
	

	@Override
	public ArrayList<Ingresso> listarTodos() {
		return repositorio;
	}
	
}
