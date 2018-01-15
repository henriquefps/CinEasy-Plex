package beans;

import java.time.LocalDateTime;

public class Sessao {
	private Filme filmeExibido;
	private Sala salaDeExibicao;
	private float valorDoIngresso;
	private LocalDateTime inicioDaSessao;
	private LocalDateTime fimDaSessao;
	
	public Sessao(){
		
	}

	public Filme getFilmeExibido() {
		return filmeExibido;
	}

	public void setFilmeExibido(Filme filmeExibido) {
		this.filmeExibido = filmeExibido;
	}

	public Sala getSalaDeExibicao() {
		return salaDeExibicao;
	}

	public void setSalaDeExibicao(Sala salaDeExibicao) {
		this.salaDeExibicao = salaDeExibicao;
	}

	public float getValorDoIngresso() {
		return valorDoIngresso;
	}

	public void setValorDoIngresso(float valorDoIngresso) {
		this.valorDoIngresso = valorDoIngresso;
	}

	public LocalDateTime getInicioDaSessao() {
		return inicioDaSessao;
	}

	public void setInicioDaSessao(LocalDateTime inicioDaSessao) {
		this.inicioDaSessao = inicioDaSessao;
	}

	public LocalDateTime getFimDaSessao() {
		return fimDaSessao;
	}

	public void setFimDaSessao(LocalDateTime fimDaSessao) {
		this.fimDaSessao = fimDaSessao;
	}
	
	
}
