package gerencia;

import java.util.ArrayList;

import beans.Venda;
import interfaces.IRepositorioVendas;
import repositorios.RepositorioVendas;

public class GerenciamentoVendas {
private IRepositorioVendas instance = RepositorioVendas.getInstance();
	
	public void cadastrarVenda(Venda a){
		if (a != null) instance.cadastrar(a);
	}
	
	public void removerVenda(Venda e){
		if(e != null) instance.remover(e);
	}
	
	
	public ArrayList<Venda> listarVendas(){
		return instance.listar();
	}
}
