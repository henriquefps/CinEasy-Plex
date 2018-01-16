package repositorios;

import java.util.ArrayList;

import beans.Sessao;
import interfaces.IRepositorio;

public class RepositorioSessoes implements IRepositorio<Sessao>{

	private ArrayList<Sessao> repositorio;
	private static RepositorioSessoes instance;
	
	private RepositorioSessoes(){
		repositorio = new ArrayList<Sessao>();
	}
	
	@SuppressWarnings("unused")
	public static RepositorioSessoes getInstance(){
		if(instance == null){
			instance = new RepositorioSessoes();
		}
		return instance;
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
	public void cadastrar(Sessao obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Sessao newObj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Sessao obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Sessao buscar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(Sessao obj) {
		// TODO Auto-generated method stub
		return false;
	}

		
}
