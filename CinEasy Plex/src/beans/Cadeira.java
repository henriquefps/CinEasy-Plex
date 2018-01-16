package beans;

public class Cadeira {
	private String letra;
	private int num;
	private boolean isDisponivel;
	
	
	public Cadeira(String letra, int num, boolean isDisponivel) {
		this.letra = letra.toUpperCase();
		this.num = num;
		this.isDisponivel = isDisponivel;
	}
	
	public String getLetra() {
		return letra;
	}
	public void setLetra(String letra) {
		this.letra = letra;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public boolean isDisponivel() {
		return isDisponivel;
	}
	public void setDisponivel(boolean isDisponivel) {
		this.isDisponivel = isDisponivel;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cadeira other = (Cadeira) obj;
		if (isDisponivel != other.isDisponivel)
			return false;
		if (letra != other.letra)
			return false;
		if (num != other.num)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return letra + num;
	}
	
	
	
	
}
