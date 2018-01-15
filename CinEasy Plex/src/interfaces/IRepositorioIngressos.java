package interfaces;

import beans.Ingresso;

public interface IRepositorioIngressos {

	public abstract void cadastrar(Ingresso a);
	public abstract void remover(Ingresso a);
	public abstract void listar();	
}
