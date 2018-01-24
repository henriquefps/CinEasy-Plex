package interfaces;

import java.util.ArrayList;


import beans.Sessao;

public interface IRepositorioSessoes extends IRepositorio<Sessao>{
	ArrayList<Sessao> buscarPorFilme(String titulo);
	ArrayList<Sessao> buscarPorSala(byte id);
	
}
