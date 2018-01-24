package repositorios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import beans.Ingresso;
import interfaces.IRepositorio;

public class RepositorioIngressosArray implements IRepositorio<Ingresso>, Serializable{

	private static IRepositorio<Ingresso> instance;
	private ArrayList<Ingresso> repositorio;
	private static int id;
	
	private RepositorioIngressosArray() {
		repositorio = new ArrayList<>();
		id = 0;
	}
	
	public static IRepositorio<Ingresso> getInstance(){
		if(instance == null){
			instance = lerArquivo();
		}
		return instance;
	}


	public static RepositorioIngressosArray lerArquivo()
	{
		RepositorioIngressosArray instancia = null;
		File in = new File("IngressosArray.dat");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        
        try {
            fis = new FileInputStream(in);
            ois = new ObjectInputStream(fis);
            
            Object o = ois.readObject();
            instancia = (RepositorioIngressosArray) o;
            
        } catch (Exception e) {
            instancia = new RepositorioIngressosArray();
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
		File out = new File("IngressosArray.dat");
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
	public void cadastrar(Ingresso obj) {
		id += 1;
		obj.setIdIngresso(id);
		repositorio.add(obj);
		this.salvarArquivo();
	}

	@Override
	public void atualizar(Ingresso newObj) {
		repositorio.set(newObj.getIdIngresso()-1, newObj);
		this.salvarArquivo();
		
	}

	@Override
	public void remover(Ingresso obj) {
		repositorio.remove(obj.getIdIngresso());
		this.salvarArquivo();
	}

	@Override
	public Ingresso buscar(int id) {
		return repositorio.get(id-1);
		
	}
	

	@Override
	public ArrayList<Ingresso> listarTodos() {
		return repositorio;
	}
	
}
