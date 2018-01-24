package beans;

import java.io.Serializable;
import java.time.LocalTime;

public class Filme implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4725933753524242545L;
	private int idFilme;
	private String titulo;
	private String genero;
	private LocalTime duracao;
	private String classificacao;
	
	public Filme(String titulo, String genero, LocalTime duracao, String classificacao){
		this.setTitulo(titulo);
		this.setGenero(genero);
		this.setDuracao(duracao);
		this.setClassificacao(classificacao);
	}
	
	public Filme() {
		
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public LocalTime getDuracao() {
		return duracao;
	}

	public void setDuracao(LocalTime duracao) {
		this.duracao = duracao;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	public int getIdFilme() {
		return idFilme;
	}

	public void setIdFilme(int idFilme) {
		this.idFilme = idFilme;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filme other = (Filme) obj;
		if (classificacao == null) {
			if (other.classificacao != null)
				return false;
		} else if (!classificacao.equals(other.classificacao))
			return false;
		if (duracao == null) {
			if (other.duracao != null)
				return false;
		} else if (!duracao.equals(other.duracao))
			return false;
		if (genero == null) {
			if (other.genero != null)
				return false;
		} else if (!genero.equals(other.genero))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Filme [idFilme=" + idFilme + ", titulo=" + titulo + ", genero=" + genero + ", duracao=" + duracao
				+ ", classificacao=" + classificacao + "]";
	}
	
	
	
	
	
}
