package beans;

public class Ingresso {
	private int idIngresso;
	private boolean isMeia;
	private Cadeira cadeiraVendida;
	
	public Ingresso(int idIngresso, boolean isMeia, Cadeira cadeiraVendida){
		this.setIdIngresso(idIngresso);
		this.setMeia(isMeia);
		this.setCadeiraVendida(cadeiraVendida);
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
	
	
}
