package interfaces;

import java.util.ArrayList;

import beans.Conta;

public interface IFachada {
	
	//Conta
	public void cadastrarConta(Conta c) throws Exception;
	public void alterarConta(Conta c) throws Exception;
	public void removerConta(Conta c) throws Exception;
	public Conta buscarConta(Conta c) throws Exception;
	public ArrayList<Conta> listarTodasConta();
	//Filme
	//Ingresso
	//Sala
	//Sessao
	//Venda

}
