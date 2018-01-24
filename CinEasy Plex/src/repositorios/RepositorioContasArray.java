package repositorios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import beans.Conta;
import interfaces.IRepositorioContas;

public class RepositorioContasArray implements IRepositorioContas, Serializable {

	private static RepositorioContasArray instance;
	private ArrayList<Conta> repositorio;
	private static int id;
	
	private RepositorioContasArray() {
		repositorio = new ArrayList<>();
		id = 0;
	}
	

	public static RepositorioContasArray getInstance(){
		if(instance == null){
			instance = lerArquivo();
		}
		return instance;
	}


	public static RepositorioContasArray lerArquivo()
	{
		RepositorioContasArray instancia = null;
		File in = new File("ContasArray.dat");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        
        try {
            fis = new FileInputStream(in);
            ois = new ObjectInputStream(fis);
            
            Object o = ois.readObject();
            instancia = (RepositorioContasArray) o;
            
        } catch (Exception e) {
            instancia = new RepositorioContasArray();
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
		File out = new File("ContasArray.dat");
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
	public void cadastrar(Conta obj) {
		id += 1;
		obj.setIdConta(id);
		repositorio.add(obj);
		this.salvarArquivo();
	}

	@Override
	public void atualizar(Conta newObj) {
		repositorio.set(newObj.getIdConta()-1, newObj);
		this.salvarArquivo();
		
	}


	@Override
	public void remover(Conta obj) {
		repositorio.remove(obj);
		this.salvarArquivo();
	}


	@Override
	public Conta buscar(int id) {
		return repositorio.get(id-1);
	}


	@Override
	public ArrayList<Conta> listarTodos() {
		return repositorio;
	}


	@Override
	public Conta pesquisarPorNome(String s) {
		Conta res = null;
		for (Conta conta : repositorio) {
			if(conta.getLogin().equals(s)) {
				res = conta;
				break;
			}
		}
		
		return res;
	}


}
