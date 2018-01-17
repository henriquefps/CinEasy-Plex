package gerencia;

import java.util.ArrayList;

import beans.Ingresso;
import exceptions.ObjetoJaExisteException;
import exceptions.ObjetoNaoExisteException;
import interfaces.IRepositorio;
import repositorios.RepositorioIngressosArray;

public class GerenciamentoIngressos {
	
	private IRepositorio<Ingresso> instance = RepositorioIngressosArray.getInstance();
	
	public void cadastrar(Ingresso obj) throws Exception {
		if(obj != null) {
			if(existe(obj))
				throw new ObjetoJaExisteException("Este ingresso já existe");
			else
				instance.cadastrar(obj);
		}
		else
			throw new IllegalArgumentException("Ingresso Inválido");
		
	}
	
	public void alterar(Ingresso newObj) throws Exception {
		if(newObj != null) {
			if(!existe(newObj))
				throw new ObjetoNaoExisteException("Este ingresso não existe");
			else
				instance.atualizar(newObj);
		}
		else
			throw new IllegalArgumentException("Ingresso Inválido");
	}
	
	public void remover(Ingresso obj) throws Exception {
		if(obj != null) {
			if(!existe(obj))
				throw new ObjetoNaoExisteException("Este ingresso não existe");
			else
				instance.remover(obj);
		}
		else
			throw new IllegalArgumentException("Ingresso Inválido");
	}
	
	public Ingresso buscar(int id) throws Exception {
		Ingresso res = null;
		if(id < 0)
			throw new IllegalArgumentException("ID Inválido");
		else {
			res = instance.buscar(id);
		}
		
		return res;
	}
	
	public ArrayList<Ingresso> listarTodos() {
		return instance.listarTodos();
		
	}
	
	public boolean existe(Ingresso obj) {
		boolean res = false;
		if(obj != null) {
			ArrayList<Ingresso> ingressos = listarTodos();
			if(ingressos.contains(obj))
				res = true;
		}
		
		return res;
	
	}
}
