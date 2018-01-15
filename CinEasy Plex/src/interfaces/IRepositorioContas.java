package interfaces;

import beans.Conta;

public interface IRepositorioContas {
	
	public abstract void cadastrar(Conta a);
	public abstract void remover(Conta a);
	public abstract void listar();	
}
