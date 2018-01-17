package interfaces;

import java.util.ArrayList;

import beans.Conta;
import beans.Filme;
import beans.Ingresso;
import beans.Sala;
import beans.Sessao;
import beans.Venda;

public interface IFachada {
	
	//Conta
	public void cadastrarConta(Conta c) throws Exception;
	public void alterarConta(Conta c) throws Exception;
	public void removerConta(Conta c) throws Exception;
	public Conta buscarConta(int i) throws Exception;
	public ArrayList<Conta> listarTodasConta();
	public boolean existe(Conta c);
	public Conta buscarContaPorNome(String s);
	//Filme
	public void cadastrarFilme(Filme c) throws Exception;
	public void alterarFilme(Filme c) throws Exception;
	public void removerFilme(Filme c) throws Exception;
	public Filme buscarFilme(int id) throws Exception;
	public ArrayList<Filme> listarTodasFilme();
	public boolean existe(Filme c);
	//Ingresso
	public void cadastrarIngresso(Ingresso c) throws Exception;
	public void alterarIngresso(Ingresso c) throws Exception;
	public void removerIngresso(Ingresso c) throws Exception;
	public Ingresso buscarIngresso(int id) throws Exception;
	public ArrayList<Ingresso> listarTodasIngresso();
	public boolean existe(Ingresso c);
	//Sala
	public void cadastrarSala(Sala c) throws Exception;
	public void alterarSala(Sala c) throws Exception;
	public void removerSala(Sala c) throws Exception;
	public Sala buscarSala(int id) throws Exception;
	public ArrayList<Sala> listarTodasSala();
	public boolean existe(Sala c);
	//Sessao
	public void cadastrarSessao(Sessao c) throws Exception;
	public void alterarSessao(Sessao c) throws Exception;
	public void removerSessao(Sessao c) throws Exception;
	public Sessao buscarSessao(int id) throws Exception;
	public ArrayList<Sessao> listarTodasSessao();
	public boolean existe(Sessao c);
	ArrayList<Sessao> buscarSessaoPorTitulo(String titulo);
	ArrayList<Sessao> buscarSessaoPorSala(byte id);
	//Venda
	public void cadastrarVenda(Venda c) throws Exception;
	public void alterarVenda(Venda c) throws Exception;
	public void removerVenda(Venda c) throws Exception;
	public Venda buscarVenda(int id) throws Exception;
	public ArrayList<Venda> listarTodasVenda();
	public boolean existe(Venda c);
	

}
