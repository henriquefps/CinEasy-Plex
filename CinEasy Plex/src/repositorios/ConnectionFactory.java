package repositorios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static ConnectionFactory instance;
	private Connection conexao;
	
	
    private static final String URL = "jdbc:mysql://mysql642.umbler.com:41890/cineasy_plex?autoReconnect=true&useSSL=false";
    private static final String USER = "vanessabandeira";
    private static final String PASSWORD = "ufrpe123456";
    private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    
	private ConnectionFactory() throws SQLException{
		setConnection();
	}
	
	public static ConnectionFactory getInstance() throws SQLException{
		if(instance == null){
			instance = new ConnectionFactory();
		}
		return instance;
		
	}
    private void setConnection()throws SQLException {
    	
		if (this.conexao == null) {
			try {
				Class.forName(DRIVER_CLASS).newInstance();
				conexao = DriverManager.getConnection(URL, USER, PASSWORD);
				conexao.setAutoCommit(false);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
			
    }
    
	public Connection getConnection() throws SQLException{
		

		this.setConnection();
		this.conexao.setAutoCommit(false);
		return conexao;
	}
	
	public void closeConnetion() throws Exception{
		this.conexao.close();		
	}


}
