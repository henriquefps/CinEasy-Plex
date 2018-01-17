package gerencia;

import java.util.ArrayList;

import beans.Conta;
import exceptions.ObjetoJaExisteException;
import exceptions.ObjetoNaoExisteException;
import interfaces.IRepositorioContas;
import repositorios.RepositorioContasArray;

public class GerenciamentoConta {
	private IRepositorioContas instance = RepositorioContasArray.getInstance();
	
	public void cadastrar(Conta obj) throws Exception {
		if(obj != null) {
			if(existe(obj))
				throw new ObjetoJaExisteException("Este Conta já existe");
			else
				instance.cadastrar(obj);
		}
		else
			throw new IllegalArgumentException("Conta Inválido");
		
	}
	
	public void alterar(Conta newObj) throws Exception {
		if(newObj != null) {
			if(!existe(newObj))
				throw new ObjetoNaoExisteException("Este Conta não existe");
			else
				instance.atualizar(newObj);
		}
		else
			throw new IllegalArgumentException("Conta Inválido");
	}
	
	public void remover(Conta obj) throws Exception {
		if(obj != null) {
			if(!existe(obj))
				throw new ObjetoNaoExisteException("Este Conta não existe");
			else
				instance.remover(obj);
		}
		else
			throw new IllegalArgumentException("Conta Inválido");
	}
	
	public Conta buscar(int id) throws Exception {
		Conta res = null;
		if(id < 0)
			throw new IllegalArgumentException("ID Inválido");
		else {
			res = instance.buscar(id);
		}
		
		return res;
	}
	
	public ArrayList<Conta> listarTodos() {
		return instance.listarTodos();
		
	}
	
	public boolean existe(Conta obj) {
		boolean res = false;
		if(obj != null) {
			ArrayList<Conta> Contas = listarTodos();
			if(Contas.contains(obj))
				res = true;
		}
		
		return res;
	
	}
	
	public Conta pesquisarPorNome(String s) {
		if(s != null) {
			Conta c = instance.pesquisarPorNome(s);
			return c;
		}
		else
			throw new IllegalArgumentException("Nome Inválido");
	}
}
