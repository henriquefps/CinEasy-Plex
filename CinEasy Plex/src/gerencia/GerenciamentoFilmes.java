package gerencia;

import java.time.LocalTime;
import java.util.ArrayList;

import beans.Filme;
import interfaces.IRepositorioFilmes;
import repositorios.RepositorioFilmes;

public class GerenciamentoFilmes {
private IRepositorioFilmes instance = RepositorioFilmes.getInstance();
	
	public void criarFilme(String titulo, String genero, LocalTime duracao, String classificacao){
		// TODO criar um objeto e salvar no repositorio pela interface
	}
	
	public void removerFilme(Filme e){
		// TODO
	}
	
	public Filme buscarFilme(String titulo){
		// TODO procurar no arraylist do repositorio e retornar
	}
	
	public ArrayList<Filme> listarFilmes(){
		// TODO retornar o repositorio
	}
}
