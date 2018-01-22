package gerencia;
import java.util.ArrayList;
import beans.Cadeira;
import beans.Sessao;
import exceptions.ObjetoJaExisteException;
import exceptions.ObjetoNaoExisteException;
import interfaces.IRepositorioSessoes;
import repositorios.RepositorioSessoes;

public class GerenciamentoSessoes {
private IRepositorioSessoes instance = RepositorioSessoes.getInstance();
	
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
	
	public ArrayList<Sessao> listarSessoesPorSala(byte id){
		return instance.buscarPorSala(id);
	}
	
	public ArrayList<Cadeira> listarCadeirasDaSessao(Sessao a){
		// TODO faltando fazer cadeiras
		return null;
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
}
