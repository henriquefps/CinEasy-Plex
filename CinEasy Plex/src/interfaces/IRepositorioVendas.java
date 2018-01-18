package interfaces;

import java.util.ArrayList;

import beans.Venda;

public interface IRepositorioVendas {

	public abstract void cadastrar(Venda a);
	public abstract void remover(Venda a);
	public abstract ArrayList<Venda> listar();	
}
