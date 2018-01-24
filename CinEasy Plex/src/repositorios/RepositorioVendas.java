package repositorios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import beans.Venda;
import interfaces.IRepositorioVendas;

public class RepositorioVendas implements IRepositorioVendas, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Venda> todasAsVendas;
	private static RepositorioVendas instance;
	private int id;
	
	private RepositorioVendas() {
		this.todasAsVendas = new ArrayList<Venda>();
	}
	
	public static RepositorioVendas getInstance(){
		if(instance == null){
			instance = lerArquivo();
		}
		return instance;
	}


	public static RepositorioVendas lerArquivo()
	{
		RepositorioVendas instancia = null;
		File in = new File("Vendas.dat");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        
        try {
            fis = new FileInputStream(in);
            ois = new ObjectInputStream(fis);
            
            Object o = ois.readObject();
            instancia = (RepositorioVendas) o;
            
        } catch (Exception e) {
            instancia = new RepositorioVendas();
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
		File out = new File("Vendas.dat");
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
	
	public void cadastrar(Venda a) {
		id = todasAsVendas.size();
		id += 1;
		a.setIdVenda(id);
		todasAsVendas.add(a);
		this.salvarArquivo();
	}

	
	public void remover(Venda a) {
		todasAsVendas.remove(a);
		id -= 1;
		this.salvarArquivo();
	}
	@Override
	public ArrayList<Venda> listar() {
		return this.todasAsVendas;
	}
	
	public Venda buscar(int idVenda) {
		return todasAsVendas.get(idVenda-1);
		
	}

}
