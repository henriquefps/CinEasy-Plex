package repositorios;

import java.util.ArrayList;


import beans.Sessao;
import exceptions.ObjetoJaExisteException;
import exceptions.ObjetoNaoExisteException;
import interfaces.IRepositorio;

public class RepositorioSessoes implements IRepositorio<Sessao>{

	private ArrayList<Sessao> repositorio;
	private static RepositorioSessoes instance;
	
	private RepositorioSessoes(){
		repositorio = new ArrayList<Sessao>();
	}
	
	public static RepositorioSessoes getInstance(){
		if(instance == null){
			instance = new RepositorioSessoes();
		}
		return instance;
	}

	@Override
	public Sessao buscar(int id) {
		// TODO Auto-generated method stub
		Sessao achou = null;
		for(int i = 0; i < this.repositorio.size(); i++){
			if(repositorio.get(i).getIdSessao() == id){
				achou = repositorio.get(i);
				return achou;
			}
		}
		return achou;
	}

	@Override
	public void cadastrar(Sessao obj) throws ObjetoJaExisteException {
		// TODO Auto-generated method stub
		if(obj != null){
			if(existe(obj) == true)
				throw new ObjetoJaExisteException("Esta sessão já existe");
			else
				repositorio.add(obj.getIdSessao(), obj);
		}
	}
	
	@Override
	public void atualizar(Sessao newObj) throws ObjetoNaoExisteException {
		// TODO Auto-generated method stub
		if(newObj != null){
			if(existe(newObj) != true)
				throw new ObjetoNaoExisteException("Essa sessão não existe no sistema");
			else
				repositorio.set(newObj.getIdSessao(), newObj);
		}
	}
	
	@Override
	public void remover(Sessao obj) throws ObjetoNaoExisteException {
		// TODO Auto-generated method stub
		if(obj != null){
			if(existe(obj) != true)
				throw new ObjetoNaoExisteException("Essa sessão não existe no sistema");
			else
				repositorio.remove(obj);
		}
	}
	
	@Override
	public ArrayList<Sessao> buscar(String s) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ArrayList<Sessao> listarTodos() {
		// TODO Auto-generated method stub
		return repositorio;
	}
	
	@Override
	public boolean existe(Sessao obj) {
		// TODO Auto-generated method stub
		if(buscar(obj.getIdSessao()) != null){
			return true;
		}
		return false;
    }

	@Override
	public ArrayList<Sessao> buscarPorFilme(String titulo) {
		// TODO buscar sessao por filme
		ArrayList<Sessao> r = new ArrayList<Sessao>();
		if(titulo == null)
			return null;
		else{
			for(int i = 0; i < repositorio.size(); i++){
				if(repositorio.get(i).getFilmeExibido().equals(titulo)){
					r.add(repositorio.get(i));
				}
			}
		}
		return r;
	}

	@Override
	public ArrayList<Sessao> buscarPorSala(byte id) {
		// TODO buscar sessao por filme
		ArrayList<Sessao> r = new ArrayList<Sessao>();
		if(id < 0)
			return null;
		else{
			for(int i = 0; i < repositorio.size(); i++){
				if(repositorio.get(i).getSalaDeExibicao().getIdSala() == id){
					r.add(repositorio.get(i));
				}
			}
		}
		return r;
	}
}
