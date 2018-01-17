package gerencia;

import java.util.ArrayList;

import beans.Cadeira;
import beans.Ingresso;
import interfaces.IRepositorio;
import repositorios.RepositorioIngressosArray;

public class GerenciamentoIngressos {
	
private IRepositorio<Ingresso> instance = RepositorioIngressosArray.getInstance();
	
	public void criarIngresso(boolean isMeia, Cadeira cadeiraVendida){
		// TODO criar um objeto e salvar no repositorio pela interface
	}
	
	public void removerIngresso(Ingresso e){
		// TODO
	}
	
	public ArrayList<Ingresso> listarIngressos(){
		// TODO retornar o repositorio
		
		return null;
	}
}
