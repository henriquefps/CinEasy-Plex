package interfaces;

import java.util.ArrayList;

public interface IRepositorio<T> {
	//Todas as classes basicas que serao armazenadas em repositorio necessitam ter
	//um atributo que os identifica unicamente (chave primaria) e esse atributo nao pode ser 
	//modificado, assim como no banco.
	
	/**
	 * Cadastra um objeto do tipo T no repositorio
	 * @param obj
	 * 		referencia do objeto a ser cadastrado
	 */
	public void cadastrar(T obj);
	
	/**
	 * Atualiza um objeto do tipo T no repositorio
	 * @param newObj
	 * 		referencia do objeto do tipo T a ser atualizado
	 * 		utilizar o atributo de chave primaria para fazer a atualizacao
	 */
	public void atualizar(T newObj);
	
	/**
	 * Remove um objeto do tipo T do repositorio
	 * @param obj
	 * 		referencia do objeto a ser removido
	 * 		utilizar o atributo de chave primaria para fazer a remocao
	 */
	public void remover(T obj);
	
	/** 
	 * Faz uma busca especifica por um objeto do tipo T
	 * @param id
	 * 		Atributo chave primaria do objeto
	 * @return
	 * 		objeto especifico para aquele id
	 */
	public T buscar(int id);
	
	/**
	 * Listar todos objetos do tipo T
	 * @return
	 * 		uma lista com todos os objetos do repositorio
	 */
	public ArrayList<T> listarTodos();
	

}
