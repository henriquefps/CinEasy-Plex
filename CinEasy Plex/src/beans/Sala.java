package beans;

import java.util.ArrayList;

public class Sala {
	private byte idSala;
	private int quantidadeDeCadeiras;
	private ArrayList<Cadeira> listaDeCadeiras = new ArrayList<Cadeira>();
	private String tipo; //Tipo da sala, 3D, 4K...
	
	public Sala(byte idSala, int quantidadeDeCadeiras, String tipoDeSala){
		this.idSala = idSala;
		this.quantidadeDeCadeiras = quantidadeDeCadeiras;
		//TODO algoritmo de criacao dos objetos cadeiras
		this.tipo = tipoDeSala;			
	}

	public int getQuantidadeDeCadeiras() {
		return quantidadeDeCadeiras;
	}

	public void setQuantidadeDeCadeiras(int quantidadeDeCadeiras) {
		this.quantidadeDeCadeiras = quantidadeDeCadeiras;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public byte getIdSala() {
		return idSala;
	}

	public void setIdSala(byte idSala) {
		this.idSala = idSala;
	}

	public ArrayList<Cadeira> getListaDeCadeiras() {
		return listaDeCadeiras;
	}
	
}
