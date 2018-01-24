package repositorios;

import java.sql.SQLException;
import java.util.ArrayList;

public interface InterfaceCRUD<T,K>{

	public boolean existe(K chave) throws SQLException; 
	public T buscar(K chave)throws SQLException;
	public boolean cadastrar(T objeto)throws SQLException;
	public boolean remover(T objeto)throws SQLException ;
	public boolean atualizar(T objeto)throws SQLException;
	public ArrayList<T> listar()throws SQLException;
}
