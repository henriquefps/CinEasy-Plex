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
	void cadastrar(T obj) throws Exception;
	
	/**
	 * Atualiza um objeto do tipo T no repositorio
	 * @param newObj
	 * 		referencia do objeto do tipo T a ser atualizado
	 * 		utilizar o atributo de chave primaria para fazer a atualizacao
	 */
	void atualizar(T newObj) throws Exception;
	
	/**
	 * Remove um objeto do tipo T do repositorio
	 * @param obj
	 * 		referencia do objeto a ser removido
	 * 		utilizar o atributo de chave primaria para fazer a remocao
	 */
	void remover(T obj) throws Exception;
	
	/** 
	 * Faz uma busca especifica por um objeto do tipo T
	 * @param id
	 * 		Atributo chave primaria do objeto
	 * @return
	 * 		objeto especifico para aquele id
	 */
	T buscar(int id);
	
	/**
	 * Listar todos objetos do tipo T
	 * @return
	 * 		uma lista com todos os objetos do repositorio
	 */
	ArrayList<T> listarTodos();
	

}
