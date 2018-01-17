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
	public void cadastrar(Ingresso obj) throws ObjetoJaExisteException {
		if(obj != null) {
			if(existe(obj))
				throw new ObjetoJaExisteException("Este ingresso já existe");
			else
				repositorio.add(obj.getIdIngresso(), obj);
		}
		else
			throw new IllegalArgumentException("Ingresso Inválido");
	}

	@Override
	public void atualizar(Ingresso newObj) throws ObjetoNaoExisteException {
		if(newObj != null) {
			if(!existe(newObj))
				throw new ObjetoNaoExisteException("Este ingresso não existe");
			else
				repositorio.set(newObj.getIdIngresso(), newObj);
		}
		else
			throw new IllegalArgumentException("Ingresso Inválido");
		
	}

	@Override
	public void remover(Ingresso obj) throws ObjetoNaoExisteException {
		if(obj != null) {
			if(!existe(obj))
				throw new ObjetoNaoExisteException("Este ingresso não existe");
			else
				repositorio.remove(obj.getIdIngresso());
		}
		else
			throw new IllegalArgumentException("Ingresso Inválido");
		
	}

	@Override
	public Ingresso buscar(int id) {
		Ingresso res = null;
		if(id < 0)
			throw new IllegalArgumentException("ID Inválido");
		else {
			res = repositorio.get(id);
		}
		
		return res;
	}
	
	@Override
	public ArrayList<Ingresso> buscar(String s) {
		if(s != null) {
		}
		return null;
	}

	@Override
	public ArrayList<Ingresso> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(Ingresso obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Ingresso> buscarPorFilme(String titulo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Ingresso> buscarPorSala(byte id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
