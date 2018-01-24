package beans;

import java.io.Serializable;

public class Venda implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6263244557291863396L;
	private int idVenda;
	private Ingresso ingressoVendido;
	private Sessao sessaoVendida;
	
	public Venda() {
		
	}
	
	public Venda(Ingresso ingressoVendido, Sessao sessaoVendida) {
		this.setIngressoVendido(ingressoVendido);
		this.setSessaoVendida(sessaoVendida);
	}

	public int getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}

	public Ingresso getIngressoVendido() {
		return ingressoVendido;
	}

	public void setIngressoVendido(Ingresso ingressoVendido) {
		this.ingressoVendido = ingressoVendido;
	}

	public Sessao getSessaoVendida() {
		return sessaoVendida;
	}

	public void setSessaoVendida(Sessao sessaoVendida) {
		this.sessaoVendida = sessaoVendida;
	}
	
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venda other = (Venda) obj;
		if (ingressoVendido == null) {
			if (other.ingressoVendido != null)
				return false;
		} else if (!ingressoVendido.equals(other.ingressoVendido))
			return false;
		if (sessaoVendida == null) {
			if (other.sessaoVendida != null)
				return false;
		} else if (!sessaoVendida.equals(other.sessaoVendida))
			return false;
		return true;	
	}
	
	@Override
	public String toString() {
		return "Codigo: " + idVenda + "\nIngresso: " + ingressoVendido +  "\nSess�o: " +sessaoVendida;
	}
	
	
	
}
