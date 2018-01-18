package repositorios;

import java.util.ArrayList;

import beans.Sala;
import interfaces.IRepositorio;

public class RepositorioSalasArray implements IRepositorio<Sala>{

	private static RepositorioSalasArray instance;
	private ArrayList<Sala> salas;
	private static int id;
	
	private RepositorioSalasArray() {
		salas = new ArrayList<Sala>();
		id = 0;
	}
	

	public static RepositorioSalasArray getInstance(){
		if(instance == null){
			instance = new RepositorioSalasArray();
		}
		return instance;
	}


	@Override
	public void cadastrar(Sala obj) {
		id += 1;
		obj.setIdSala((byte) id);
		salas.add(obj);
		
	}


	@Override
	public void atualizar(Sala newObj) {
		salas.set((byte)newObj.getIdSala()-1, newObj);
		
	}


	@Override
	public void remover(Sala obj) {
		salas.remove(obj);
		
	}


	@Override
	public Sala buscar(int id) {
		return salas.get((byte)id-1);
	}


	@Override
	public ArrayList<Sala> listarTodos() {
		return salas;
	}
	
}

