package gerencia;
//
import java.util.ArrayList;

import beans.Cadeira;
import beans.Sala;

import interfaces.IRepositorioSala;

import repositorios.RepositorioSalas;

public class GerenciamentoSalas {
private IRepositorioSala instance = RepositorioSalas.getInstance();
	
	public void criarSala(byte idSala, int quantidadeDeCadeiras, String tipoDeSala){
		// TODO criar um objeto e salvar no repositorio pela interface
		Sala nova = new Sala(idSala, quantidadeDeCadeiras, tipoDeSala);
		instance.cadastrar(nova);
	
	}
	
	public void removerSala(byte id){
		// TODO
		instance.remover(id);
	}
	
	public Sala buscarSala(byte idSala){
		// TODO procurar no arraylist do repositorio e retornar
		return instance.buscar(idSala);
	}
	public void alterarSala(Sala a, byte novoID, int novaQuantidade, String novoTipo) //se não for mudar deixa o mesmo
	{
		instance.alterar(a, novoID, novaQuantidade,  novoTipo);
		
	}
	public ArrayList<Sala> listarSalas(){
		// TODO retornar o repositorio
		return instance.listar();
	}
	
	public ArrayList<Cadeira> listarCadeirasDaSala(Sala a){
		//TODO
		return a.getListaDeCadeiras();
	}
}
