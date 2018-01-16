package beans;

import java.time.LocalTime;

public class Filme {
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
	
	
}
