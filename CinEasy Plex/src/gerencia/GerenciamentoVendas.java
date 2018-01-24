package gerencia;

import java.util.ArrayList;

import beans.Venda;
import interfaces.IRepositorioVendas;

public class GerenciamentoVendas {
	private IRepositorioVendas instance;
	
	public GerenciamentoVendas(IRepositorioVendas instance) {
		this.instance = instance;
	}
	
	public void cadastrarVenda(Venda a){
		if (a != null) instance.cadastrar(a);
	}
	
	public void removerVenda(Venda e){
		if(e != null) instance.remover(e);
	}
	
	
	public ArrayList<Venda> listarVendas(){
		return instance.listar();
	}
	
	public Venda buscarVenda(int id) throws Exception {
		Venda procurada = null;
		for (int i = 0; i < listarVendas().size(); i++) {
			if (listarVendas().get(i).getIdVenda() == id) {
				procurada = listarVendas().get(i);
			}
		}
		return procurada;
	}
	public boolean existe(Venda c) {
		try {
			if (buscarVenda(c.getIdVenda()) != null) {
				return true;
			}
			return false;
		} catch (Exception e) {e.printStackTrace();return false;}
	}
}
