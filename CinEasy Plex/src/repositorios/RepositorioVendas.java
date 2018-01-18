package repositorios;

import java.util.ArrayList;

import beans.Ingresso;
import beans.Venda;
import interfaces.IRepositorioVendas;

public class RepositorioVendas implements IRepositorioVendas{
	private ArrayList<Venda> todasAsVendas;
	private static RepositorioVendas instance;
	private static int id;
	
	
	public static RepositorioVendas getInstance(){
		if(instance == null){
			instance = new RepositorioVendas();
		}
		return instance;
	
	}
	private RepositorioVendas() {
		this.todasAsVendas = new ArrayList<Venda>();
		id = 0;

	}
	
	public void cadastrar(Venda a) {
		id += 1;
		a.setIdVenda(id);
		todasAsVendas.add(a);
		
	}

	
	public void remover(Venda a) {
		todasAsVendas.remove(a);
		
	}
	@Override
	public ArrayList<Venda> listar() {
		return this.todasAsVendas;
		
	}
	
	public Venda buscar(int idVenda) {
		return todasAsVendas.get(idVenda-1);
		
	}

}
