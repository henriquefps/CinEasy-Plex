package beans;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Sessao implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6544381035038380278L;
	private int idSessao;
	private Filme filmeExibido;
	private Sala salaDeExibicao;
	private float valorDoIngresso;
	private LocalDateTime inicioDaSessao;
	private LocalDateTime fimDaSessao;
	private ArrayList<Cadeira> cadeirasDaSessao;

	public Sessao(Filme filmeExibido, Sala salaDeExibicao, float valorDoIngresso, LocalDateTime inicioDaSessao) {
		this.setFilmeExibido(filmeExibido);
		this.setSalaDeExibicao(salaDeExibicao);
		this.setValorDoIngresso(valorDoIngresso);
		this.setInicioDaSessao(inicioDaSessao);
		this.setFimDaSessao(inicioDaSessao);
		this.setFimDaSessao(fimDaSessao
				.plusMinutes(60 * filmeExibido.getDuracao().getHour() + filmeExibido.getDuracao().getMinute()));
		cadeirasDaSessao = new ArrayList<>();
		for (int i = 0; i < salaDeExibicao.getListaDeCadeiras().size(); i++) {
			cadeirasDaSessao
					.add(new Cadeira(Cadeira.tranformaEmInt(salaDeExibicao.getListaDeCadeiras().get(i).getLetra()),
							salaDeExibicao.getListaDeCadeiras().get(i).getNum(), true));
		}
	}

	public Sessao() {

	}

	public LocalDateTime getFimDaSessao() {
		return fimDaSessao;
	}

	public void setFimDaSessao(LocalDateTime f) {
		fimDaSessao = f;
	}

	/**
	 * @return the idSessao
	 */
	public int getIdSessao() {
		return idSessao;
	}

	/**
	 * @param idSessao
	 *            the idSessao to set
	 */
	public void setIdSessao(int idSessao) {
		this.idSessao = idSessao;
	}

	/**
	 * @return the filmeExibido
	 */
	public Filme getFilmeExibido() {
		return filmeExibido;
	}

	/**
	 * @param filmeExibido
	 *            the filmeExibido to set
	 */
	public void setFilmeExibido(Filme filmeExibido) {
		this.filmeExibido = filmeExibido;
	}

	/**
	 * @return the salaDeExibicao
	 */
	public Sala getSalaDeExibicao() {
		return salaDeExibicao;
	}

	/**
	 * @param salaDeExibicao
	 *            the salaDeExibicao to set
	 */
	public void setSalaDeExibicao(Sala salaDeExibicao) {
		this.salaDeExibicao = salaDeExibicao;
	}

	/**
	 * @return the valorDoIngresso
	 */
	public float getValorDoIngresso() {
		return valorDoIngresso;
	}

	/**
	 * @param valorDoIngresso
	 *            the valorDoIngresso to set
	 */
	public void setValorDoIngresso(float valorDoIngresso) {
		this.valorDoIngresso = valorDoIngresso;
	}

	/**
	 * @return the inicioDaSessao
	 */
	public LocalDateTime getInicioDaSessao() {
		return inicioDaSessao;
	}

	/**
	 * @param inicioDaSessao
	 *            the inicioDaSessao to set
	 */
	public void setInicioDaSessao(LocalDateTime inicioDaSessao) {
		this.inicioDaSessao = inicioDaSessao;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sessao other = (Sessao) obj;
		if (cadeirasDaSessao == null) {
			if (other.cadeirasDaSessao != null)
				return false;
		} else if (!cadeirasDaSessao.equals(other.cadeirasDaSessao))
			return false;
		if (filmeExibido == null) {
			if (other.filmeExibido != null)
				return false;
		} else if (!filmeExibido.equals(other.filmeExibido))
			return false;
		if (fimDaSessao == null) {
			if (other.fimDaSessao != null)
				return false;
		} else if (!fimDaSessao.equals(other.fimDaSessao))
			return false;
		if (inicioDaSessao == null) {
			if (other.inicioDaSessao != null)
				return false;
		} else if (!inicioDaSessao.equals(other.inicioDaSessao))
			return false;
		if (salaDeExibicao == null) {
			if (other.salaDeExibicao != null)
				return false;
		} else if (!salaDeExibicao.equals(other.salaDeExibicao))
			return false;
		if (Float.floatToIntBits(valorDoIngresso) != Float.floatToIntBits(other.valorDoIngresso))
			return false;
		return true;
	}

	public ArrayList<Cadeira> getCadeirasDaSessao() {
		return cadeirasDaSessao;
	}

	public void setCadeirasDaSessao(ArrayList<Cadeira> cadeirasDaSessao) {
		this.cadeirasDaSessao = cadeirasDaSessao;
	}
}
