package beans;

public class Cadeira {
	private String idCadeira; //E a combinacao letra-numero que da nome a cadeira
	private boolean isDisponivel;
	
	public Cadeira(String idCadeira, boolean isDisponivel){
		this.setIdCadeira(idCadeira);
		this.setDisponivel(isDisponivel);
	}

	public String getIdCadeira() {
		return idCadeira;
	}

	public void setIdCadeira(String idCadeira) {
		this.idCadeira = idCadeira;
	}

	public boolean isDisponivel() {
		return isDisponivel;
	}

	public void setDisponivel(boolean isDisponivel) {
		this.isDisponivel = isDisponivel;
	}
	
	
}
