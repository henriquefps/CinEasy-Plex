package interfaces;

import java.util.ArrayList;

import beans.Filme;

public interface IRepositorioFilmes extends IRepositorio<Filme> {
	
	ArrayList<Filme> buscarPorFilme(String titulo);
}
