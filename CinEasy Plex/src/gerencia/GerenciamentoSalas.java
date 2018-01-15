package gerencia;

import java.util.ArrayList;

import beans.Cadeira;
import beans.Sala;
import interfaces.IRepositorioIngressos;
import repositorios.RepositorioIngressos;

public class GerenciamentoSalas {
private IRepositorioIngressos instance = RepositorioIngressos.getInstance();
	
	public void criarSala(byte idSala, int quantidadeDeCadeiras, String tipoDeSala){
		// TODO criar um objeto e salvar no repositorio pela interface
	}
	
	public void removerSala(Sala e){
		// TODO
	}
	
	public Sala buscarSala(byte idSala){
		// TODO procurar no arraylist do repositorio e retornar
	}
	
	public void listarSalas(){
		// TODO retornar o repositorio
	}
	
	public ArrayList<Cadeira> listarCadeirasDaSala(Sala a){
		//TODO
	}
}
