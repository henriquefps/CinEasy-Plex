package repositorios;

import java.util.ArrayList;
import beans.Sessao;
import interfaces.IRepositorioSessoes;

public class RepositorioSessoes implements IRepositorioSessoes{

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
	public void cadastrar(Sessao obj) {
		// TODO Auto-generated method stub
		repositorio.add(obj.getIdSessao(), obj);
	}
	
	@Override
	public void atualizar(Sessao newObj) {
		// TODO Auto-generated method stub
		repositorio.set(newObj.getIdSessao(), newObj);
	}
	
	@Override
	public void remover(Sessao obj) {
		// TODO Auto-generated method stub
		repositorio.remove(obj);
	}
	
	@Override
	public ArrayList<Sessao> listarTodos() {
		// TODO Auto-generated method stub
		return repositorio;
	}
	
	@Override
	public ArrayList<Sessao> buscarPorFilme(String titulo) {
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
