package repositorios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import beans.Filme;
import interfaces.IRepositorioFilmes;

public class RepositorioFilmes implements IRepositorioFilmes, Serializable{

	private static RepositorioFilmes instance;
	private ArrayList<Filme> listaDeFilmes;
	private static int id;
	
	private RepositorioFilmes() {
		listaDeFilmes = new ArrayList<Filme>();
		id = 0;
	}
	

	public static RepositorioFilmes getInstance(){
		if(instance == null){
			instance = lerArquivo();
		}
		return instance;
	}


	public static RepositorioFilmes lerArquivo()
	{
		RepositorioFilmes instancia = null;
		File in = new File("Filmes.dat");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        
        try {
            fis = new FileInputStream(in);
            ois = new ObjectInputStream(fis);
            
            Object o = ois.readObject();
            instancia = (RepositorioFilmes) o;
            
        } catch (Exception e) {
            instancia = new RepositorioFilmes();
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
		File out = new File("Filmes.dat");
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
	public void cadastrar(Filme a) {
		id += 1;
		a.setIdFilme(id);
		if (!existeFilme(a.getIdFilme())) {
			listaDeFilmes.add(a);
			this.salvarArquivo();
		}
	}

	@Override
	public void remover(Filme a) {
		listaDeFilmes.remove(a);
		this.salvarArquivo();
		
	}

	@Override
	public ArrayList<Filme> listarTodos() {
		return listaDeFilmes;
	}


	@Override
	public void atualizar(Filme newObj) {
		listaDeFilmes.set(newObj.getIdFilme()-1, newObj);
		this.salvarArquivo();
	}


	@Override
	public Filme buscar(int id) {
		return listaDeFilmes.get(id-1);
	}

	@Override
	public ArrayList<Filme> buscarPorFilme(String titulo) {
		ArrayList<Filme> filmes = new ArrayList<>();
		for (Filme filme : listaDeFilmes) {
			if(filme.getTitulo().contains(titulo))
				filmes.add(filme);
		}
		
		return filmes;
	}
	public boolean existeFilme(int id){
		boolean a = false;
		for (int i = 0; i < listarTodos().size(); i++) {
			if (listarTodos().get(i).getIdFilme() == id) {
				a = true;
			}
		}
		return a;
	}

}
