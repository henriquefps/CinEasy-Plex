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
import interfaces.IFachada;
import interfaces.IRepositorioContas;
import repositorios.RepositorioContasArray;

public class CinemaFachada implements IFachada {
	private static CinemaFachada instance;
	
	private GerenciamentoConta contas;
	private GerenciamentoFilmes filmes;
	private GerenciamentoIngressos ingressos;
	private GerenciamentoSalas salas;
	private GerenciamentoSessoes sessoes;
	private GerenciamentoVendas vendas;
	
	private CinemaFachada(){
		contas = new GerenciamentoConta();
		filmes = new GerenciamentoFilmes();
		ingressos = new GerenciamentoIngressos();
		salas = new GerenciamentoSalas();
		sessoes = new GerenciamentoSessoes();
		vendas = new GerenciamentoVendas();
	}
	
	public static CinemaFachada getInstance(){
		if(instance == null){
			instance = new CinemaFachada();
		}
		return instance;
	}

	@Override
	public void cadastrarConta(Conta c) throws Exception {
		contas.cadastrar(c);
		
	}

	@Override
	public void alterarConta(Conta c) throws Exception {
		contas.alterar(c);
		
	}

	@Override
	public void removerConta(Conta c) throws Exception {
		contas.remover(c);
		
	}

	@Override
	public Conta buscarConta(int id) throws Exception {
		return contas.buscar(id);
	}

	@Override
	public ArrayList<Conta> listarTodasConta() {
		return contas.listarTodos();
	}

	@Override
	public boolean existe(Conta c) {
		return contas.existe(c);
	}
	
	@Override
	public Conta buscarContaPorNome(String s) {
		return contas.pesquisarPorNome(s);
	}

	@Override
	public void cadastrarFilme(Filme c) throws Exception {
		filmes.cadastrar(c);
		
	}

	@Override
	public void alterarFilme(Filme c) throws Exception {
		filmes.alterar(c);
		
	}

	@Override
	public void removerFilme(Filme c) throws Exception {
		filmes.remover(c);
		
	}

	@Override
	public Filme buscarFilme(int id) throws Exception {
		return filmes.buscar(id);
	}

	@Override
	public ArrayList<Filme> listarTodasFilme() {
		return filmes.listarTodos();
	}

	@Override
	public boolean existe(Filme c) {
		return filmes.existe(c);
	}

	@Override
	public void cadastrarIngresso(Ingresso c) throws Exception {
		ingressos.cadastrar(c);
		
	}

	@Override
	public void alterarIngresso(Ingresso c) throws Exception {
		ingressos.alterar(c);
		
	}

	@Override
	public void removerIngresso(Ingresso c) throws Exception {
		ingressos.remover(c);
		
	}

	@Override
	public Ingresso buscarIngresso(int id) throws Exception {
		return ingressos.buscar(id);
		
	}

	@Override
	public ArrayList<Ingresso> listarTodasIngresso() {
		return ingressos.listarTodos();
				
	}

	@Override
	public boolean existe(Ingresso c) {
		return ingressos.existe(c);
		
	}

	@Override
	public void cadastrarSala(Sala c) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterarSala(Sala c) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removerSala(Sala c) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Sala buscarSala(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Sala> listarTodasSala() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(Sala c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void cadastrarSessao(Sessao c) throws Exception {
		// TODO Auto-generated method stub
		sessoes.criarSessao(c);
	}

	@Override
	public void alterarSessao(Sessao c) throws Exception {
		// TODO Auto-generated method stub
		sessoes.atualizarSessao(c);
	}

	@Override
	public void removerSessao(Sessao c) throws Exception {
		// TODO Auto-generated method stub
		sessoes.removerSessao(c);
	}

	@Override
	public Sessao buscarSessao(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ArrayList<Sessao> buscarSessaoPorTitulo(String titulo){
		return sessoes.listarSessoesPorFilme(titulo);
	}
	
	@Override
	public ArrayList<Sessao> buscarSessaoPorSala(byte id) {
		// TODO Auto-generated method stub
		return sessoes.listarSessoesPorSala(id);
	}
	

	@Override
	public ArrayList<Sessao> listarTodasSessao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(Sessao c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void cadastrarVenda(Venda c) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterarVenda(Venda c) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removerVenda(Venda c) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Venda buscarVenda(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Venda> listarTodasVenda() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(Venda c) {
		// TODO Auto-generated method stub
		return false;
	}
	
}