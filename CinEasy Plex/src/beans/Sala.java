package beans;

import java.io.Serializable;
import java.util.ArrayList;

public class Sala implements Serializable {
	private byte idSala;
	private int quantLinhas;
	private int quantColunas;
	private ArrayList<Cadeira> listaDeCadeiras = new ArrayList<Cadeira>();
	private TipoSala tipo;
	private boolean d3;
	
	public Sala(int quantLinhas, int quantColunas, TipoSala tipo, boolean d3) {
		this.setQuantLinhas(quantLinhas);
		this.setQuantColunas(quantColunas);
		populaListaCadeiras(quantLinhas, quantColunas);
		this.setTipo(tipo);
		this.setVisual(d3);
	}

	public Sala() {
		
	}
	
	public int getQuantLinhas() {
		return quantLinhas;
	}

	public void setQuantLinhas(int quantLinhas) {
		this.quantLinhas = quantLinhas;
		
	}

	public int getQuantColunas() {
		return quantColunas;
	}

	public void setQuantColunas(int quantColunas) {
		this.quantColunas = quantColunas;
	}

	public TipoSala getTipo() {
		return tipo;
	}

	public void setTipo(TipoSala tipo) {
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

	public boolean getD3() {
		return d3;
	}

	public void setVisual(boolean d3) {
		this.d3 = d3;
	}
	
	private void populaListaCadeiras(int l, int c) {
		listaDeCadeiras.clear();
		for(int i = 0; i < l; i++) {
			for(int j = 0; j < c; j++) {
				listaDeCadeiras.add(new Cadeira(i, j, true));
			}
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sala other = (Sala) obj;
		if (idSala != other.idSala)
			return false;
		if (quantColunas != other.quantColunas)
			return false;
		if (quantLinhas != other.quantLinhas)
			return false;
		if (tipo != other.tipo)
			return false;
		if (d3 != other.d3)
			return false;
		return true;
	}

	@Override
	public String toString() {
		
		if(d3) {
		return "Sala [idSala=" + idSala + ", quantLinhas=" + quantLinhas + ", quantColunas=" + quantColunas
				+ ", listaDeCadeiras=" + listaDeCadeiras + ", tipo=" + tipo + ", tela=3D" + "]";
		}
		
			return "Sala [idSala=" + idSala + ", quantLinhas=" + quantLinhas + ", quantColunas=" + quantColunas
					+ ", listaDeCadeiras=" + listaDeCadeiras + ", tipo=" + tipo + ", tela=2D" + "]";
		
		
	}
	
	
	
	
	
}
