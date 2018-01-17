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
		// TODO criar um objeto e salvar no repositorio pela interface
		// TODO Criar exceção de que sessão não pode ser adicionada devido a sala utilizada em determinado horário
		if(obj != null){
			if(!existe(obj))
				instance.cadastrar(obj);
			else
				throw new ObjetoJaExisteException("Sessão Já Existente");
		}else
			throw new IllegalArgumentException("Argumento inválido");	
	}
	
	public void removerSessao(Sessao obj) throws Exception{
		// TODO Remove uma sessão
		if(obj != null){
			if(existe(obj))
				instance.remover(obj);
			else
				throw new ObjetoNaoExisteException("Sessão Não Existente");
		}else
			throw new IllegalArgumentException("Argumento inválido");
		
	}
	
	public ArrayList<Sessao> listarSessoes() {
		// TODO retornar o repositorio
		return instance.listarTodos();
	}
	
	public void atualizarSessao(Sessao obj) throws Exception{
		if(obj != null){
			if(existe(obj))
				instance.atualizar(obj);
			else
				throw new ObjetoNaoExisteException("Sessão Não Existente");
		}else
			throw new IllegalArgumentException("Argumento inválido");
		
	}
	
	public ArrayList<Sessao> listarSessoesPorFilme(String titulo){
		//TODO lista todas as sessões pelo titulo do filme
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
		// TODO @return true caso a sessão exista
		ArrayList<Sessao> r = this.listarSessoes();
		if(obj == null)
			throw new IllegalArgumentException("Parâmetro inválido");
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
