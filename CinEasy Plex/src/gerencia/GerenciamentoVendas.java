package gerencia;

import beans.Ingresso;
import beans.Sessao;
import beans.Venda;
import interfaces.IRepositorioVendas;
import repositorios.RepositorioVendas;

public class GerenciamentoVendas {
private IRepositorioVendas instance = RepositorioVendas.getInstance();
	
	public void criarVenda(Ingresso	ingressoVendido, Sessao sessaoVendida){
		// TODO criar um objeto e salvar no repositorio pela interface
	}
	
	public void removerVenda(Venda e){
		// TODO
	}
	
	
	public void listarVendas(){
		// TODO retornar o repositorio
	}
}
