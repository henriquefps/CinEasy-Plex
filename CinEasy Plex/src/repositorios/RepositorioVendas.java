package repositorios;

import java.util.ArrayList;

import beans.Venda;
import interfaces.IRepositorioVendas;

public class RepositorioVendas implements IRepositorioVendas{
	
	private ArrayList<Venda> vendas;

	private static RepositorioVendas instance;
	
	
	public static RepositorioVendas getInstance(){
		if(instance == null){
			instance = new RepositorioVendas();
		}
		return instance;
	}
	
	private RepositorioVendas() {
		this.vendas = new ArrayList<Venda>();

	}
	public void cadastrar(Venda nova_venda) {
		this.vendas.add(nova_venda);	
		
	}

	
	public boolean remover(int idVenda) {
		Venda nova_venda = this.listar(idVenda);
			if(nova_venda != null){
				this.vendas.remove(nova_venda);
				return true;
			}
		return false;
	}

	
	public Venda listar(int idVenda) {
		
		for(int venda_encontrada = 0; venda_encontrada < this.vendas.size(); venda_encontrada++){
			if(idVenda == this.vendas.get(venda_encontrada).getIdVenda()){
				return this.vendas.get(venda_encontrada);
			}
		}
		return null;
		
	}

}
