package interfaces;

import beans.Sessao;

public interface IRepositorioSessoes {

	public abstract void cadastrar(Sessao a);
	public abstract void remover(Sessao a);
	public abstract void listar();	
}
