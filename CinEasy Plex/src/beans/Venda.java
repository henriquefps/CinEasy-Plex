package beans;

public class Venda {
	private int idVenda;
	private Ingresso ingressoVendido;
	private Sessao sessaoVendida;
	
	public Venda(Ingresso ingressoVendido, Sessao sessaoVendida, int idVenda){
		this.setIngressoVendido(ingressoVendido);
		this.setSessaoVendida(sessaoVendida);
		this.setIdVenda(idVenda);
	}

	public int getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}

	public Ingresso getIngressoVendido() {
		return ingressoVendido;
	}

	public void setIngressoVendido(Ingresso ingressoVendido) {
		this.ingressoVendido = ingressoVendido;
	}

	public Sessao getSessaoVendida() {
		return sessaoVendida;
	}

	public void setSessaoVendida(Sessao sessaoVendida) {
		this.sessaoVendida = sessaoVendida;
	}
	
	
}
