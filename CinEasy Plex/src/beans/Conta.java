package beans;

import java.io.Serializable;

public class Conta implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 454471692801660671L;
	private int idConta;
	private String login;
	private String senha;
	
	public Conta(String login, String senha){
		this.setLogin(login);
		this.setSenha(senha);
	}

	public Conta() {
		
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getIdConta() {
		return idConta;
	}

	public void setIdConta(int idConta) {
		this.idConta = idConta;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ID - " + idConta + "\nLogin - " + login;
	}
	
	
	
	
}
