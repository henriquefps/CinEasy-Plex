package fachada;

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
import repositorios.RepositorioContasArray;
import repositorios.RepositorioFilmes;
import repositorios.RepositorioIngressosArray;
import repositorios.RepositorioSalasArray;
import repositorios.RepositorioSessoes;
import repositorios.RepositorioVendas;

public class CinemaFachada implements IFachada {
	private static CinemaFachada instance;
	
	private GerenciamentoConta contas;
	private GerenciamentoFilmes filmes;
	private GerenciamentoIngressos ingressos;
	private GerenciamentoSalas salas;
	private GerenciamentoSessoes sessoes;
	private GerenciamentoVendas vendas;
	
	private CinemaFachada(){
		contas = new GerenciamentoConta(RepositorioContasArray.getInstance());
		filmes = new GerenciamentoFilmes(RepositorioFilmes.getInstance());
		ingressos = new GerenciamentoIngressos(RepositorioIngressosArray.getInstance());
		salas = new GerenciamentoSalas(RepositorioSalasArray.getInstance());
		sessoes = new GerenciamentoSessoes(RepositorioSessoes.getInstance());
		vendas = new GerenciamentoVendas(RepositorioVendas.getInstance());
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
	
	public Conta buscarContaLogin(String cpf){
		return contas.buscar(cpf);
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
		salas.cadastrar(c);
	}

	@Override
	public void alterarSala(Sala c) throws Exception {
		salas.alterar(c);
	}

	@Override
	public void removerSala(Sala c) throws Exception {
		salas.remover(c);
	}

	@Override
	public Sala buscarSala(int id) throws Exception {
		return salas.buscar(id);
	}

	@Override
	public ArrayList<Sala> listarTodasSala() {
		return salas.listarTodos();
	}

	@Override
	public boolean existe(Sala c) {
		return salas.existe(c);
	}

	@Override
	public void cadastrarSessao(Sessao c) throws Exception {
		sessoes.criarSessao(c);
	}

	@Override
	public void alterarSessao(Sessao c) throws Exception {
		sessoes.atualizarSessao(c);
	}

	@Override
	public void removerSessao(Sessao c) throws Exception {
		sessoes.removerSessao(c);
	}

	@Override
	public Sessao buscarSessao(int id) throws Exception {
		
		return sessoes.listarSessoes().get(id);
	}
	
	@Override
	public ArrayList<Sessao> buscarSessaoPorTitulo(String titulo){
		return sessoes.listarSessoesPorFilme(titulo);
	}
	
	public ArrayList<Sessao> listarSessoesPorFilme(Filme a){
		return sessoes.listarSessoesPorFilme(a);
	}
	
	@Override
	public ArrayList<Sessao> buscarSessaoPorSala(byte id) {
		return sessoes.listarSessoesPorSala(id);
	}
	
	public ArrayList<Sessao> sessoesPorSala(Sala a){
		return sessoes.sessoesPorSala(a);
	}

	@Override
	public ArrayList<Sessao> listarTodasSessao() {
		return sessoes.listarSessoes();
	}

	@Override
	public boolean existe(Sessao c) {
		return sessoes.listarSessoes().contains(c);
	}

	@Override
	public void cadastrarVenda(Venda c) throws Exception {
		vendas.cadastrarVenda(c);
	}

	@Override
	public void alterarVenda(Venda c) throws Exception {
		// Unused
	}

	@Override
	public void removerVenda(Venda c) throws Exception {
		vendas.removerVenda(c);
	}

	@Override
	public Venda buscarVenda(int id) throws Exception {
		return vendas.buscarVenda(id);
	}

	@Override
	public ArrayList<Venda> listarTodasVenda() {
		return vendas.listarVendas();
	}

	@Override
	public boolean existe(Venda c) {
		return vendas.existe(c);
	}
	
	public ArrayList<Sessao> filtrarSessoesFuturas(ArrayList<Sessao> lista){
		return sessoes.filtrarSessoesFuturas(lista);
	}
	
	public ArrayList<Cadeira> listarCadeirasDisponiveis(Sessao e){
		return sessoes.listarCadeirasDisponiveis(e);
	}
	
}
