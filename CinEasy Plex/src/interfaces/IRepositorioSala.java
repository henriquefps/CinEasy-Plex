package interfaces;

import beans.Sala;

public interface IRepositorioSala {

	public abstract void cadastrar(Sala a);
	public abstract void remover(Sala a);
	public abstract void listar();	
}
