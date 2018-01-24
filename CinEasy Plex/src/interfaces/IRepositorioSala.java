package interfaces;

import java.util.ArrayList;

import beans.Sala;

public interface IRepositorioSala{
	
	public abstract void cadastrar(Sala obj);
	public abstract void atualizar(Sala newObj);
	public abstract void remover(Sala obj);
	public abstract Sala buscar(int id);
	public abstract ArrayList<Sala> listarTodos();
}

