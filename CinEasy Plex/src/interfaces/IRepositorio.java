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
	 * busca generica de um item, bem utilizada para preenchimento de um tableview
	 * de consulta
	 * @param s
	 * 		algum atributo do tipo String que identifica o objeto
	 * @return
	 * 		uma lista com todos os objetos que tem o atributo tipo String parecido
	 */
	ArrayList<T> buscar(String s);
	
	/**
	 * Listar todos objetos do tipo T
	 * @return
	 * 		uma lista com todos os objetos do repositorio
	 */
	ArrayList<T> listarTodos();
	
	/**
	 * Verifica a existencia do objeto do tipo T no repositorio
	 * 
	 * @param obj
	 * 		referencia do objeto a ter a existencia verificada
	 * 
	 * @return
	 * 		true se o objeto existe
	 * 		false se o n�o existe
	 */
	boolean existe(T obj);

}