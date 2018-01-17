package interfaces;
//
import java.util.ArrayList;

import beans.Sala;

public interface IRepositorioSala {

	public abstract void cadastrar(Sala a);
	public abstract boolean remover(byte id);
	public abstract ArrayList<Sala> listar();
	public abstract void alterar(Sala a, byte id, int quantidadeDeCadeiras, String tipo);
	public abstract Sala buscar(byte id);
	
}

