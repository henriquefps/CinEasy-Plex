package repositorios;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;
import com.sun.xml.internal.ws.client.sei.ValueSetter;

import java.util.ArrayList;

import beans.Conta;

import interfaces.IRepositorioContas;

public class RepositorioContasArray implements InterfaceCRUD<Conta, String> {

	private static RepositorioContasArray instance;
	private PreparedStatement statement;
	private ResultSet rSet;
	private ArrayList<Conta> repositorio;
	private static int id;
	
	private RepositorioContasArray() {
		repositorio = new ArrayList<>();
		id = 0;
	}
	

	public static RepositorioContasArray getInstance(){
		if(instance == null){
			instance = new RepositorioContasArray();
		}
		return instance;
	}


	@Override
	public boolean existe(String login) throws SQLException{
		boolean resultado = false;
		String sql = "SELECT * FROM conta WHERE  login=" + login;
		
		this.statement = (PreparedStatement) ConnectionFactory.getInstance().getConnection().prepareStatement(sql);
		this.rSet = (ResultSet) statement.executeQuery();
		
		if(rSet.next()) {
			resultado = true;
		}
		
		return resultado;
		
	}
	
	@Override
	public boolean cadastrar(Conta obj) throws SQLException {
		id += 1;
		obj.setIdConta(id);
		String sql = "INSERT INTO conta(idConta, SENHA)" + "values(?,?)";
		
		statement = (PreparedStatement) ConnectionFactory.getInstance().getConnection().prepareStatement(sql);
		statement.setLong(1, obj.getIdConta());
		statement.setString(2, obj.getLogin());
		statement.setString(3, obj.getSenha());
		statement.execute();
		
		return true;
	}


	@Override
	public boolean atualizar(Conta obj) throws SQLException {
		String sql = "UPDATE cinEasy_Plex.Conta SET login = ?, senha = ?, idConta = ?"
				+ "WHERE idConta =" + obj.getIdConta();
		
		statement = (PreparedStatement) ConnectionFactory.getInstance().getConnection().prepareStatement(sql);
		statement.setString(1, obj.getLogin());
		statement.setString(2, obj.getSenha());
		statement.execute();
		
		return true;	
				
//		repositorio.set(newObj.getIdConta()-1, newObj);
		
	}


	@Override
	public boolean remover(Conta obj) throws SQLException{
		String sql = "DELETE FROM cinEasy_Plex.Conta" + "WHERE login = ?";
		
		statement = (PreparedStatement) ConnectionFactory.getInstance().getConnection().prepareStatement(sql);
		statement.setString(1, obj.getLogin());
		statement.execute();
		
		return true;
	}


	@Override
	public Conta buscar(String login) throws SQLException{
		Conta conta = null;
		String sql = "SELECT * FROM conta WHERE login =" + login;
		
		this.statement = (PreparedStatement) ConnectionFactory.getInstance().getConnection().prepareStatement(sql);
		this.rSet = (ResultSet) statement.executeQuery();
		return repositorio.get(id-1);
	}


	@Override
	public ArrayList<Conta> listarTodos() {
		return repositorio;
	}


	@Override
	public Conta pesquisarPorNome(String s) {
		Conta res = null;
		for (Conta conta : repositorio) {
			if(conta.getLogin().equals(s)) {
				res = conta;
				break;
			}
		}
		
		return res;
	}
	
	

}
