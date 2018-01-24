package gerencia;

import java.util.ArrayList;

import beans.Conta;
import exceptions.ObjetoJaExisteException;
import exceptions.ObjetoNaoExisteException;
import interfaces.IRepositorioContas;

public class GerenciamentoConta {
	private IRepositorioContas instance;
	
	public GerenciamentoConta(IRepositorioContas instance) {
		this.instance = instance;
	}

	public void cadastrar(Conta obj) throws Exception {
		if (obj != null) {
			if (buscar(obj.getLogin()) != null){
				throw new ObjetoJaExisteException("Este Conta j� existe");
			}
			else
				instance.cadastrar(obj);
		} else
			throw new IllegalArgumentException("Conta Inv�lido");
	}



	public void alterar(Conta newObj) throws Exception {
		if (newObj != null) {
			if (!existe(newObj))
				throw new ObjetoNaoExisteException("Este Conta n�o existe");
			else
				instance.atualizar(newObj);
		} else
			throw new IllegalArgumentException("Conta Inv�lido");
	}

	public void remover(Conta obj) throws Exception {
		if (obj != null) {
			if (!existe(obj))
				throw new ObjetoNaoExisteException("Este Conta n�o existe");
			else
				instance.remover(obj);
		} else
			throw new IllegalArgumentException("Conta Inv�lido");
	}

	public Conta buscar(int id) throws Exception {
		Conta res = null;
		if (id < 0)
			throw new IllegalArgumentException("ID Inv�lido");
		else {
			res = instance.buscar(id);
		}

		return res;
	}

	public Conta buscar(String cpf) {
		Conta res = null;
		for (int i = 0; i < listarTodos().size(); i++) {
			if (listarTodos().get(i).getLogin().equals(cpf)) {
				res = listarTodos().get(i);
			}
		}
		return res;
	}

	public ArrayList<Conta> listarTodos() {
		return instance.listarTodos();

	}

	public boolean existe(Conta obj) {
		boolean res = false;
		if (obj != null) {
			ArrayList<Conta> Contas = listarTodos();
			if (Contas.contains(obj))
				res = true;
		}

		return res;

	}

	public Conta pesquisarPorNome(String s) {
		if (s != null) {
			Conta c = instance.pesquisarPorNome(s);
			return c;
		} else
			throw new IllegalArgumentException("Nome Inv�lido");
	}
}
