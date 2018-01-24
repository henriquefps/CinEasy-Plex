package repositorios;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IRelacionamento<T,K>{

	public boolean inserir(T objeto)throws SQLException;
	public boolean remover(T objeto)throws SQLException;
	public ArrayList<T> listar()throws SQLException;
	public ArrayList<T> listar(K codigo) throws SQLException;
}
