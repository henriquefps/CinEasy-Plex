package repositorios;

import java.util.ArrayList;

import beans.Ingresso;
import beans.Venda;
import interfaces.IRepositorioVendas;

public class RepositorioVendas implements IRepositorioVendas{
	private ArrayList<Venda> todasAsVendas;
	
	private static RepositorioVendas instance;
	
	
	public static RepositorioVendas getInstance(){
		if(instance == null){
			instance = new RepositorioVendas();
		}
		return instance;
	
	}
	private RepositorioVendas() {
		this.todasAsVendas = new ArrayList<Venda>();

	}
	
	public void cadastrar(Venda a) {
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
		return todasAsVendas.get(idVenda);
		
	}

}
