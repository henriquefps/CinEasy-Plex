package gerencia;
import java.util.ArrayList;

import beans.Sala;
import exceptions.ObjetoJaExisteException;
import exceptions.ObjetoNaoExisteException;
import interfaces.IRepositorio;
import repositorios.RepositorioSalasArray;

public class GerenciamentoSalas {
	private IRepositorio<Sala> instance = RepositorioSalasArray.getInstance();
	
	public void cadastrar(Sala obj) throws Exception {
		if(obj != null) {
			if(existe(obj))
				throw new ObjetoJaExisteException("Este Sala já existe");
			else
				instance.cadastrar(obj);
		}
		else
			throw new IllegalArgumentException("Sala Inválido");
		
	}
	
	public void alterar(Sala newObj) throws Exception {
		if(newObj != null) {
			if(!existe(newObj))
				throw new ObjetoNaoExisteException("Este Sala não existe");
			else
				instance.atualizar(newObj);
		}
		else
			throw new IllegalArgumentException("Sala Inválido");
	}
	
	public void remover(Sala obj) throws Exception {
		if(obj != null) {
			if(!existe(obj))
				throw new ObjetoNaoExisteException("Este Sala não existe");
			else
				instance.remover(obj);
		}
		else
			throw new IllegalArgumentException("Sala Inválido");
	}
	
	public Sala buscar(int id) throws Exception {
		Sala res = null;
		if(id < 0)
			throw new IllegalArgumentException("ID Inválido");
		else {
			res = instance.buscar(id);
		}
		
		return res;
	}
	
	public ArrayList<Sala> listarTodos() {
		return instance.listarTodos();
		
	}
	
	public boolean existe(Sala obj) {
		boolean res = false;
		if(obj != null) {
			ArrayList<Sala> Salas = listarTodos();
			if(Salas.contains(obj))
				res = true;
		}
		
		return res;
	
	}

}
