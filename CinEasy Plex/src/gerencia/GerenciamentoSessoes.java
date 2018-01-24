package gerencia;
import java.time.LocalDateTime;
import java.util.ArrayList;

import beans.Cadeira;
import beans.Filme;
import beans.Sala;
import beans.Sessao;
import exceptions.ObjetoJaExisteException;
import exceptions.ObjetoNaoExisteException;
import interfaces.IRepositorioSessoes;

public class GerenciamentoSessoes {
	private IRepositorioSessoes instance;

	public GerenciamentoSessoes(IRepositorioSessoes instance) {
		this.instance = instance;
	}
	
	public void criarSessao(Sessao obj) throws Exception{
		if(obj != null){
			if(!existe(obj)){
				for(int i = 0 ; i < instance.listarTodos().size(); i++){
					if(instance.listarTodos().get(i).getSalaDeExibicao().equals(obj.getSalaDeExibicao())){
						if(instance.listarTodos().get(i).getInicioDaSessao().isEqual(obj.getInicioDaSessao())
								|| instance.listarTodos().get(i).getFimDaSessao().isAfter(obj.getInicioDaSessao())){
								throw new IllegalArgumentException("Sessão já cadastrada nesse horário");
						}
					}
				}
				instance.cadastrar(obj);
			}
				
			else
				throw new ObjetoJaExisteException("Sessão Já Existente");
		}else
			throw new IllegalArgumentException("Argumento inv�lido");	
	}
	
	public void removerSessao(Sessao obj) throws Exception{
		if(obj != null){
			if(existe(obj))
				instance.remover(obj);
			else
				throw new ObjetoNaoExisteException("Sess�o N�o Existente");
		}else
			throw new IllegalArgumentException("Argumento inv�lido");
		
	}
	
	public ArrayList<Sessao> listarSessoes() {
		return instance.listarTodos();
	}
	
	public void atualizarSessao(Sessao obj) throws Exception{
		if(obj != null){
			if(existe(obj))
				instance.atualizar(obj);
			else
				throw new ObjetoNaoExisteException("Sess�o N�o Existente");
		}else
			throw new IllegalArgumentException("Argumento inv�lido");
		
	}
	
	public ArrayList<Sessao> listarSessoesPorFilme(String titulo){
		return instance.buscarPorFilme(titulo);
	}
	public ArrayList<Sessao> listarSessoesPorFilme(Filme a){
		ArrayList<Sessao> aux = new ArrayList<Sessao>();
		for (int i = 0; i < listarSessoes().size(); i++) {
			if (listarSessoes().get(i).getFilmeExibido().equals(a)) {
				aux.add(listarSessoes().get(i));
			}
		}
		return aux;
	}
	
	public ArrayList<Sessao> listarSessoesPorSala(byte id){
		return instance.buscarPorSala(id);
	}
	
	
	public boolean existe(Sessao obj) throws Exception{
		ArrayList<Sessao> r = this.listarSessoes();
		if(obj == null)
			throw new IllegalArgumentException("Par�metro inv�lido");
		else{
			for(int i = 0; i < r.size(); i++){
				if(r.get(i).equals(obj)){
					return true;
				}
			}
		}
		return false;
	}

	
	public ArrayList<Sessao> sessoesPorSala(Sala a){
		ArrayList<Sessao> sessoes = new ArrayList<Sessao>();
		for (int i = 0; i < listarSessoes().size(); i++) {
			if (listarSessoes().get(i).getSalaDeExibicao().equals(a)) {
				sessoes.add(listarSessoes().get(i));
			}
		}
		return sessoes;
	}
	
	public ArrayList<Sessao> filtrarSessoesFuturas(ArrayList<Sessao> lista){
		ArrayList<Sessao> futuras = new ArrayList<Sessao>();
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getInicioDaSessao().isAfter(LocalDateTime.now())) {
				futuras.add(lista.get(i));
			}
		}
		return futuras;
	}
	
	public ArrayList<Cadeira> listarCadeirasDisponiveis(Sessao e){
		ArrayList<Cadeira> aux = new ArrayList<Cadeira>();
		for (Cadeira cadeira : e.getCadeirasDaSessao()) {
			if(cadeira.isDisponivel())
				aux.add(cadeira);
		}
		return aux;
	}
}
