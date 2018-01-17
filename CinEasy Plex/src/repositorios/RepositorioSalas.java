package repositorios;

import java.util.ArrayList;

import beans.Sala;
import beans.Venda;
import interfaces.IRepositorioSala;

public class RepositorioSalas implements IRepositorioSala{

	private static RepositorioSalas instance;
	
	private ArrayList<Sala> salas;
	
	private RepositorioSalas() {

		salas = new ArrayList<Sala>();
	}
	

	public static RepositorioSalas getInstance(){
		if(instance == null){
			instance = new RepositorioSalas();
		}
		return instance;
	}
	@Override
	public void cadastrar(Sala a) {
		// TODO Auto-generated method stub
		salas.add(a);
		
	}

	@Override
	public boolean remover(byte id) {
		// TODO Auto-generated method stub
	Sala nova_sala = this.buscar(id);
		if(nova_sala != null){
			this.salas.remove(nova_sala);
			return true;
		}
	return false;
		
	}

	@Override
	public ArrayList<Sala> listar() {
		// TODO Auto-generated method stub
		
		return this.salas;
		
	}
	
	@Override
	
	public void alterar(Sala a, byte id, int quantidadeDeCadeiras, String tipo)
	{
		a.setIdSala(id);
		a.setTipo(tipo);
		a.setQuantidadeDeCadeiras(quantidadeDeCadeiras);
	
	}
	
	public Sala buscar(byte id)
	{
		for(int sala_encontrada = 0; sala_encontrada < this.salas.size(); sala_encontrada++){
			if(id == this.salas.get(sala_encontrada).getIdSala()){
				return this.salas.get(sala_encontrada);
			}
		}
		return null;
		
	}
	
}

