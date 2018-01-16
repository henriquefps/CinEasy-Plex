package gerencia;

import java.time.LocalTime;
import java.util.ArrayList;

import beans.Filme;
import interfaces.IRepositorioFilmes;
import repositorios.RepositorioFilmes;

public class GerenciamentoFilmes {
private IRepositorioFilmes instance = RepositorioFilmes.getInstance();
	
	public void criarFilme(String titulo, String genero, LocalTime duracao, String classificacao){
		instance.cadastrar(new Filme(titulo, genero, duracao, classificacao));
	}
	
	public void removerFilme(Filme e){
		instance.remover(e);
	}
	
	public Filme buscarFilme(String titulo){
		ArrayList<Filme> busca = instance.listar();
		Filme procurado = null;
		for(int i = 0; i < busca.size(); i++){
			if(busca.get(i).getTitulo().equals(titulo)){
				procurado = busca.get(i);
			}
		}
		return procurado;
	}
	
	public ArrayList<Filme> listarFilmes(){
		return instance.listar();
	}
}
