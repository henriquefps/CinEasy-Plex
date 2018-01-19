package beans;

public class Cadeira {
	private char letra;
	private int num;
	private boolean isDisponivel;
	
	
	public Cadeira(int letra, int num, boolean isDisponivel) {
		this.setLetra(transformaEmLetra(letra));
		this.setNum(num);
		this.setIsDisponivel(isDisponivel);
	}
	
	public char getLetra() {
		return letra;
	}
	public void setLetra(char letra) {
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
	public void setIsDisponivel(boolean isDisponivel) {
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
		return "" + letra + num;
	}
	
	private char transformaEmLetra(int letra) {
		char letras[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 
				'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		
		return letras[letra];
	}
	
	
	
	
}
