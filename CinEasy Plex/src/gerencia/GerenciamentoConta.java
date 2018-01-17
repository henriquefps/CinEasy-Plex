package gerencia;

import java.util.ArrayList;

import beans.Conta;
import interfaces.IRepositorioContas;
import repositorios.RepositorioContas;

public class GerenciamentoConta {
	private IRepositorioContas instance = RepositorioContas.getInstance();
	
	public void criarConta(String login, String senha){
		// TODO criar um objeto e salvar no repositorio pela interface
	}
	
	public void removerConta(Conta e){
		// TODO
	}
	
	public Conta buscarConta(String login){
		// TODO procurar no arraylist do repositorio e retornar
		return null;
	}
	
	public ArrayList<Conta> listarContas(){
		// TODO retornar o repositorio
		return null;
	}
}
