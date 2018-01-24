package beans;

import java.io.Serializable;

public class Cadeira implements Serializable{
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
	
	public static int tranformaEmInt(char a){
		if(a == 'A'){
			return 0;
		}else if(a == 'B'){
			return 1;
		}else if(a == 'C'){
			return 2;
		}else if(a == 'D'){
			return 3;
		}else if(a == 'E'){
			return 4;
		}else if(a == 'F'){
			return 5;
		}else if(a == 'G'){
			return 6;
		}else if(a == 'H'){
			return 7;
		}else if(a == 'I'){
			return 8;
		}else if(a == 'J'){
			return 9;
		}else if(a == 'K'){
			return 10;
		}else if(a == 'L'){
			return 11;
		}else if(a == 'M'){
			return 12;
		}else if(a == 'N'){
			return 13;
		}else if(a == 'O'){
			return 14;
		}else if(a == 'P'){
			return 15;
		}else if(a == 'Q'){
			return 16;
		}else if(a == 'R'){
			return 17;
		}else if(a == 'S'){
			return 18;
		}else if(a == 'T'){
			return 19;
		}else if(a == 'U'){
			return 20;
		}else if(a == 'V'){
			return 21;
		}else if(a == 'W'){
			return 22;
		}else if(a == 'X'){
			return 23;
		}else if(a == 'Y'){
			return 24;
		}else {
			return 25;
		}
	}

	public void setDisponivel(boolean isDisponivel) {
		this.isDisponivel = isDisponivel;
	}
	
	
	
	
}
