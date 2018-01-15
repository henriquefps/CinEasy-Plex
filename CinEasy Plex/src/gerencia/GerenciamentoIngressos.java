package gerencia;

import beans.Cadeira;
import beans.Ingresso;
import interfaces.IRepositorioIngressos;
import repositorios.RepositorioIngressos;

public class GerenciamentoIngressos {
private IRepositorioIngressos instance = RepositorioIngressos.getInstance();
	
	public void criarIngresso(boolean isMeia, Cadeira cadeiraVendida){
		// TODO criar um objeto e salvar no repositorio pela interface
	}
	
	public void removerIngresso(Ingresso e){
		// TODO
	}
	
	public void listarIngressos(){
		// TODO retornar o repositorio
	}
}
