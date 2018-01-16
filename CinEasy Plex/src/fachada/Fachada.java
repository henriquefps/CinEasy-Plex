package fachada;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import beans.Cadeira;
import beans.Conta;
import beans.Filme;
import beans.Ingresso;
import beans.Sala;
import beans.Sessao;
import beans.Venda;
import gerencia.GerenciamentoConta;
import gerencia.GerenciamentoFilmes;
import gerencia.GerenciamentoIngressos;
import gerencia.GerenciamentoSalas;
import gerencia.GerenciamentoSessoes;
import gerencia.GerenciamentoVendas;
import interfaces.IRepositorioContas;
import repositorios.RepositorioContas;

public class Fachada {
	private static Fachada instance;
	
	private GerenciamentoConta contas;
	private GerenciamentoFilmes filmes;
	private GerenciamentoIngressos ingressos;
	private GerenciamentoSalas salas;
	private GerenciamentoSessoes sessoes;
	private GerenciamentoVendas vendas;
	
	private Fachada(){
		contas = new GerenciamentoConta();
		filmes = new GerenciamentoFilmes();
		ingressos = new GerenciamentoIngressos();
		salas = new GerenciamentoSalas();
		sessoes = new GerenciamentoSessoes();
		vendas = new GerenciamentoVendas();
	}
	
	public static Fachada getInstance(){
		if(instance == null){
			instance = new Fachada();
		}
		return instance;
	}
	
	// CONTA
	public void criarConta(String login, String senha){
		contas.criarConta(login, senha);
	}
	
	public void removerConta(Conta e){
		contas.removerConta(e);
	}
	
	public Conta buscarConta(String login){
		return contas.buscarConta(login);
	}
	
	public ArrayList<Conta> listarContas(){
		return contas.listarContas();
	}
	
	// FILME
	public void criarFilme(String titulo, String genero, LocalTime duracao, String classificacao){
		filmes.criarFilme(titulo, genero, duracao, classificacao);
	}
	
	public void removerFilme(Filme e){
		filmes.removerFilme(e);
	}
	
	public Filme buscarFilme(String titulo){
		return filmes.buscarFilme(titulo);
	}
	
	public ArrayList<Filme> listarFilmes(){
		return filmes.listarFilmes();		
	}
	
	public void criarIngresso(boolean isMeia, Cadeira cadeiraVendida){
		ingressos.criarIngresso(isMeia, cadeiraVendida);
	}
	
	public void removerIngresso(Ingresso e){
		ingressos.removerIngresso(e);
	}
	
	public ArrayList<Ingresso> listarIngressos(){
		return ingressos.listarIngressos();
	}
	
	public void criarSala(byte idSala, int quantidadeDeCadeiras, String tipoDeSala){
		salas.criarSala(idSala, quantidadeDeCadeiras, tipoDeSala);
	}
	
	public void removerSala(Sala e){
		salas.removerSala(e);
	}
	
	public Sala buscarSala(byte idSala){
		return salas.buscarSala(idSala);
	}
	
	public ArrayList<Sala> listarSalas(){
		return salas.listarSalas();	
	}
	
	public ArrayList<Cadeira> listarCadeirasDaSala(Sala a){
		return salas.listarCadeirasDaSala(a);
	}
	
	public void criarSessao(Filme filmeExibido, Sala salaDeExibicao, float valorDoIngresso, LocalDateTime inicioDaSessao){
		sessoes.criarSessao(filmeExibido, salaDeExibicao, valorDoIngresso, inicioDaSessao);
	}
	
	public void removerSessao(Sessao e){
		sessoes.removerSessao(e);
	}
	
	public ArrayList<Sessao> listarSessoes(){
		return sessoes.listarSessoes();	
	}
	
	public ArrayList<Sessao> listarSessoesPorFilme(Filme a){
		return sessoes.listarSessoesPorFilme(a);
	}
	
	public ArrayList<Cadeira> listarCadeirasDaSessao(Sessao a){
		return sessoes.listarCadeirasDaSessao(a);
	}
	
	public void criarVenda(Ingresso	ingressoVendido, Sessao sessaoVendida){
		vendas.criarVenda(ingressoVendido, sessaoVendida);
	}
	
	public void removerVenda(Venda e){
		vendas.removerVenda(e);	}
	
	
	public void listarVendas(){
		vendas.listarVendas();	}
}
