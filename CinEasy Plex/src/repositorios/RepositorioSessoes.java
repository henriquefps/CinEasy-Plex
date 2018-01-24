package repositorios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import beans.Sessao;
import interfaces.IRepositorioSessoes;

public class RepositorioSessoes implements IRepositorioSessoes, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Sessao> repositorio;
	private static RepositorioSessoes instance;
	private int id;
	
	private RepositorioSessoes(){
		repositorio = new ArrayList<Sessao>();
	}
	
	public static RepositorioSessoes getInstance(){
		if(instance == null){
			instance = lerArquivo();
		}
		return instance;
	}


	public static RepositorioSessoes lerArquivo()
	{
		RepositorioSessoes instancia = null;
		File in = new File("Sessoes.dat");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        
        try {
            fis = new FileInputStream(in);
            ois = new ObjectInputStream(fis);
            
            Object o = ois.readObject();
            instancia = (RepositorioSessoes) o;
            
        } catch (Exception e) {
            instancia = new RepositorioSessoes();
        } finally {
            if (ois != null) {
            	try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
                
            }
        }
        return instancia;
        
	}
	
	public void salvarArquivo(){
		File out = new File("Sessoes.dat");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        
        try {
            fos = new FileOutputStream(out);
            oos = new ObjectOutputStream(fos);
            
			oos.writeObject(instance);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try { 
                	oos.close(); 
                } catch (IOException e) {
                	
                }
            }
        }
	}

	@Override
	public Sessao buscar(int id) {
		return repositorio.get(id-1);
	}

	@Override
	public void cadastrar(Sessao obj) {
		id = repositorio.size();
		id += 1;
		obj.setIdSessao(id);
		repositorio.add(obj);
		this.salvarArquivo();
	}
	
	@Override
	public void atualizar(Sessao newObj) {
		repositorio.set(newObj.getIdSessao()-1, newObj);
		this.salvarArquivo();
	}
	
	@Override
	public void remover(Sessao obj) {
		repositorio.remove(obj);
		id -= 1;
		this.salvarArquivo();
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
