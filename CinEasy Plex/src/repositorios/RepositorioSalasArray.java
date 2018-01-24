package repositorios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import beans.Sala;
import interfaces.IRepositorio;

public class RepositorioSalasArray implements IRepositorio<Sala>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static RepositorioSalasArray instance;
	private ArrayList<Sala> salas;
	private int id;

	private RepositorioSalasArray() {
		salas = new ArrayList<Sala>();
	}

	public static RepositorioSalasArray getInstance() {
		if (instance == null) {
			instance = lerArquivo();
		}
		return instance;
	}

	public static RepositorioSalasArray lerArquivo() {
		RepositorioSalasArray instancia = null;
		File in = new File("SalasArray.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;

		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);

			Object o = ois.readObject();
			instancia = (RepositorioSalasArray) o;

		} catch (Exception e) {
			instancia = new RepositorioSalasArray();
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}
		return instancia;

	}

	public void salvarArquivo() {
		File out = new File("SalasArray.dat");
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream(out);
			oos = new ObjectOutputStream(fos);

			oos.writeObject(instance);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {

				}
			}
		}
	}

	@Override
	public void cadastrar(Sala obj) {
		id = salas.size();
		id += 1;
		obj.setIdSala((byte) id);
		
		if (!existeSala(obj.getIdSala())) {
			salas.add(obj);
			this.salvarArquivo();
		}

	}

	@Override
	public void atualizar(Sala newObj) {
		salas.set((byte) newObj.getIdSala() - 1, newObj);
		this.salvarArquivo();

	}

	@Override
	public void remover(Sala obj) {
		salas.remove(obj);
		id -= 1;
		this.salvarArquivo();

	}

	@Override
	public Sala buscar(int id) {
		return salas.get((byte) id - 1);
	}

	@Override
	public ArrayList<Sala> listarTodos() {
		return salas;
	}

	public boolean existeSala(byte id) {
		boolean a = false;
		for (int i = 0; i < listarTodos().size(); i++) {
			if (listarTodos().get(i).getIdSala() == id) {
				a = true;
			}
		}
		return a;
	}

}
