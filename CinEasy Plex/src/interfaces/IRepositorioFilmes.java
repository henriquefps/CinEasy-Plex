package interfaces;

import java.util.ArrayList;

import beans.Filme;

public interface IRepositorioFilmes {
	
	public abstract void cadastrar(Filme a);
	public abstract void remover(Filme a);
	public abstract ArrayList<Filme> listar();	
}
