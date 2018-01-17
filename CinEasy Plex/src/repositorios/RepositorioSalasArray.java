package repositorios;

import java.util.ArrayList;

import beans.Sala;
import interfaces.IRepositorio;

public class RepositorioSalasArray implements IRepositorio<Sala>{

	private static RepositorioSalasArray instance;
	
	private ArrayList<Sala> salas;
	
	private RepositorioSalasArray() {

		salas = new ArrayList<Sala>();
	}
	

	public static RepositorioSalasArray getInstance(){
		if(instance == null){
			instance = new RepositorioSalasArray();
		}
		return instance;
	}


	@Override
	public void cadastrar(Sala obj) {
		salas.add(obj);
		
	}


	@Override
	public void atualizar(Sala newObj) {
		salas.set(newObj.getIdSala(), newObj);
		
	}


	@Override
	public void remover(Sala obj) {
		salas.remove(obj);
		
	}


	@Override
	public Sala buscar(int id) {
		return salas.get(id);
	}


	@Override
	public ArrayList<Sala> listarTodos() {
		return salas;
	}
	
}

