package gerencia;

import java.util.ArrayList;

import beans.Cadeira;
import beans.Ingresso;
import beans.Sala;
import interfaces.IRepositorio;
import repositorios.RepositorioIngressosArray;

public class GerenciamentoSalas {
private IRepositorio<Ingresso> instance = RepositorioIngressosArray.getInstance();
	
	public void criarSala(byte idSala, int quantidadeDeCadeiras, String tipoDeSala){
		// TODO criar um objeto e salvar no repositorio pela interface
	}
	
	public void removerSala(Sala e){
		// TODO
	}
	
	public Sala buscarSala(byte idSala){
		return null;
		// TODO procurar no arraylist do repositorio e retornar
	}
	
	public ArrayList<Sala> listarSalas(){
		// TODO retornar o repositorio
		return null;
	}
	
	public ArrayList<Cadeira> listarCadeirasDaSala(Sala a){
		return null;
		//TODO
	}
}
