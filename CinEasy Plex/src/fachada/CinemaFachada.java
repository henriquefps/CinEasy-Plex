package fachada;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
	
	public static CinemaFachada getInstancia() {
		if (instance == null) {
			instance = lerArquivo();
		}
		return instance;
	}
	
	private static CinemaFachada lerArquivo() {
		CinemaFachada instance = null;
		File in = new File("CinemaFachada.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;

		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);

			Object o = ois.readObject();
			instance = (CinemaFachada) o;

		} catch (Exception e) {
			instance = new CinemaFachada();
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}
		return instance;
	}

	public void salvarArquivo() {
		File out = new File("CinemaFachada.dat");
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream(out);
			oos = new ObjectOutputStream(fos);

			oos.writeObject(instance);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {

				}
			}
		}
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
