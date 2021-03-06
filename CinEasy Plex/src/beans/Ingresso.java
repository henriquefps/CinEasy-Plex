package beans;

import java.io.Serializable;

public class Ingresso implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8363807691128897565L;
	private int idIngresso;
	private boolean isMeia;
	private Cadeira cadeiraVendida;
	private float valorIngresso;
	
	private Sessao sessao;
	
	public Ingresso() {
		
	}
	
	public Ingresso(boolean isMeia, Cadeira cadeiraVendida, Sessao sessao){
		this.isMeia = isMeia;
		this.cadeiraVendida = cadeiraVendida;
		this.sessao = sessao;
	}

	public int getIdIngresso() {
		return idIngresso;
	}

	public void setIdIngresso(int idIngresso) {
		this.idIngresso = idIngresso;
	}

	public boolean isMeia() {
		return isMeia;
	}

	public void setMeia(boolean isMeia) {
		this.isMeia = isMeia;
	}

	public Cadeira getCadeiraVendida() {
		return cadeiraVendida;
	}

	public void setCadeiraVendida(Cadeira cadeiraVendida) {
		this.cadeiraVendida = cadeiraVendida;
	}

	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}

	public float getValorIngresso() {
		return valorIngresso;
	}

	public void setValorIngresso(float valorIngresso) {
		this.valorIngresso = valorIngresso;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingresso other = (Ingresso) obj;
		if (cadeiraVendida == null) {
			if (other.cadeiraVendida != null)
				return false;
		} else if (!cadeiraVendida.equals(other.cadeiraVendida))
			return false;
		if (sessao == null) {
			if (other.sessao != null)
				return false;
		} else if (!sessao.equals(other.sessao))
			return false;
		if (isMeia != other.isMeia)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ingresso [idIngresso=" + idIngresso + ", isMeia=" + isMeia + ", cadeiraVendida=" + cadeiraVendida + 
				", sessao=" + sessao + "]";
	}
	
	
	
	
}
