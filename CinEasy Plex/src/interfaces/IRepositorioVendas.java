package interfaces;

import beans.Venda;

public interface IRepositorioVendas {

	public abstract void cadastrar(Venda nova_venda);
	public abstract boolean remover(int idVenda);
	public abstract Venda listar(int idVenda);	
}
