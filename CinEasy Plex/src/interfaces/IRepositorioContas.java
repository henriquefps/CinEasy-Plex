package interfaces;

import beans.Conta;

public interface IRepositorioContas extends IRepositorio<Conta>{
	
	public Conta pesquisarPorNome(String s);
}
