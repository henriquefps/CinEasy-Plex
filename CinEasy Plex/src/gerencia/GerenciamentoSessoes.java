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
		// TODO Criar exce��o de que sess�o n�o pode ser adicionada devido a sala utilizada em determinado hor�rio
		if(obj != null){
			if(!existe(obj))
				instance.cadastrar(obj);
			else
				throw new ObjetoJaExisteException("Sess�o J� Existente");
		}else
			throw new IllegalArgumentException("Argumento inv�lido");	
	}
	
	public void removerSessao(Sessao obj) throws Exception{
		// TODO Remove uma sess�o
		if(obj != null){
			if(existe(obj))
				instance.remover(obj);
			else
				throw new ObjetoNaoExisteException("Sess�o N�o Existente");
		}else
			throw new IllegalArgumentException("Argumento inv�lido");
		
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
				throw new ObjetoNaoExisteException("Sess�o N�o Existente");
		}else
			throw new IllegalArgumentException("Argumento inv�lido");
		
	}
	
	public ArrayList<Sessao> listarSessoesPorFilme(String titulo){
		//TODO lista todas as sess�es pelo titulo do filme
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
		// TODO @return true caso a sess�o exista
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
