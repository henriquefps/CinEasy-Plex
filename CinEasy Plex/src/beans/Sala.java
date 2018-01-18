package beans;

import java.util.ArrayList;

public class Sala {
	private byte idSala;
	private int quantLinhas;
	private int quantColunas;
	private ArrayList<Cadeira> listaDeCadeiras = new ArrayList<Cadeira>();
	private TipoSala tipo;
	private TipoVisual visual;
	
	public Sala(int quantLinhas, int quantColunas, TipoSala tipo, TipoVisual visual) {
		this.quantLinhas = quantLinhas;
		this.quantColunas = quantColunas;
		populaListaCadeiras(quantLinhas, quantColunas);
		this.tipo = tipo;
		this.visual = visual;
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

	public TipoVisual getVisual() {
		return visual;
	}

	public void setVisual(TipoVisual visual) {
		this.visual = visual;
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
		if (visual != other.visual)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sala [idSala=" + idSala + ", quantLinhas=" + quantLinhas + ", quantColunas=" + quantColunas
				+ ", listaDeCadeiras=" + listaDeCadeiras + ", tipo=" + tipo + ", visual=" + visual + "]";
	}
	
	
	
	
	
}
