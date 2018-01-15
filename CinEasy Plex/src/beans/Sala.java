package beans;

public class Sala {
	private byte idSala;
	private int quantidadeDeCadeiras;
	private String tipo; //Tipo da sala, 3D, 4K...
	
	public Sala(){
		
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
	
}
