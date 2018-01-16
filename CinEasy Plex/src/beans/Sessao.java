package beans;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Sessao {
	private Filme filmeExibido;
	private Sala salaDeExibicao;
	private float valorDoIngresso;
	private LocalDateTime inicioDaSessao;
	private LocalDateTime fimDaSessao;

	private ArrayList<Cadeira> listaDeCadeiras = new ArrayList<Cadeira>();
	
	public Sessao(Filme filmeExibido, Sala salaDeExibicao, float valorDoIngresso, LocalDateTime inicioDaSessao){
		this.setFilmeExibido(filmeExibido);
		this.setSalaDeExibicao(salaDeExibicao);
		this.setValorDoIngresso(valorDoIngresso);
		this.setInicioDaSessao(inicioDaSessao);
		this.setFimDaSessao(inicioDaSessao);
		this.setFimDaSessao(fimDaSessao.plusMinutes(60 * filmeExibido.getDuracao().getHour() +
				filmeExibido.getDuracao().getMinute()));
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
	
	public ArrayList<Cadeira> getListaDeCadeiras() {
		return listaDeCadeiras;
	}
	
}
