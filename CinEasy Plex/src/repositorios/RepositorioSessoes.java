package repositorios;

import java.util.ArrayList;
import beans.Sessao;
import interfaces.IRepositorioSessoes;

public class RepositorioSessoes implements IRepositorioSessoes{

	private ArrayList<Sessao> repositorio;
	private static RepositorioSessoes instance;
	private static int id;
	
	private RepositorioSessoes(){
		repositorio = new ArrayList<Sessao>();
		id = 0;
	}
	
	public static RepositorioSessoes getInstance(){
		if(instance == null){
			instance = new RepositorioSessoes();
		}
		return instance;
	}

	@Override
	public Sessao buscar(int id) {
		return repositorio.get(id-1);
	}

	@Override
	public void cadastrar(Sessao obj) {
		id += 1;
		obj.setIdSessao(id);
		repositorio.add(obj);
	}
	
	@Override
	public void atualizar(Sessao newObj) {
		repositorio.set(newObj.getIdSessao()-1, newObj);
	}
	
	@Override
	public void remover(Sessao obj) {
		repositorio.remove(obj);
	}
	
	@Override
	public ArrayList<Sessao> listarTodos() {
		return repositorio;
	}
	
	@Override
	public ArrayList<Sessao> buscarPorFilme(String titulo) {
		ArrayList<Sessao> r = new ArrayList<Sessao>();
		if(titulo == null)
			return null;
		else{
			for(int i = 0; i < repositorio.size(); i++){
				if(repositorio.get(i).getFilmeExibido().getTitulo().equals(titulo)){
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
