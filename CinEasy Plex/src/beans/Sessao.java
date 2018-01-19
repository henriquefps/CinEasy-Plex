package beans;

import java.time.LocalDateTime;

public class Sessao {
	private int idSessao;
	private Filme filmeExibido;
	private Sala salaDeExibicao;
	private float valorDoIngresso;
	private LocalDateTime inicioDaSessao;
	private LocalDateTime fimDaSessao;
	
	public Sessao(Filme filmeExibido, Sala salaDeExibicao, float valorDoIngresso, LocalDateTime inicioDaSessao){ 
		    this.setFilmeExibido(filmeExibido); 
		    this.setSalaDeExibicao(salaDeExibicao); 
		    this.setValorDoIngresso(valorDoIngresso); 
		    this.setInicioDaSessao(inicioDaSessao); 
		    this.setFimDaSessao(inicioDaSessao); 
		    this.setFimDaSessao(fimDaSessao.plusMinutes(60 * filmeExibido.getDuracao().getHour() + 
		        filmeExibido.getDuracao().getMinute())); 
	}

	public Sessao() {
		
	}

	public LocalDateTime getFimDaSessao(){
		return fimDaSessao;
	}
	public void setFimDaSessao(LocalDateTime f){
		fimDaSessao = f;
	}
	
	/**
	 * @return the idSessao
	 */
	public int getIdSessao() {
		return idSessao;
	}

	/**
	 * @param idSessao the idSessao to set
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
	 * @param filmeExibido the filmeExibido to set
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
	 * @param salaDeExibicao the salaDeExibicao to set
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
	 * @param valorDoIngresso the valorDoIngresso to set
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
	 * @param inicioDaSessao the inicioDaSessao to set
	 */
	public void setInicioDaSessao(LocalDateTime inicioDaSessao) {
		this.inicioDaSessao = inicioDaSessao;
	}
		
	public boolean equals(Object obj){
		boolean res = false;
		if(obj != null && obj.getClass() == this.getClass()){
			if(this.getFilmeExibido().equals(((Sessao) obj).getFilmeExibido()) 
					&& this.getSalaDeExibicao().equals(((Sessao)obj).getSalaDeExibicao())
					&& this.getInicioDaSessao().equals(((Sessao)obj).getInicioDaSessao())){
				res = true;
			}
		}
		return res;
	}

}
