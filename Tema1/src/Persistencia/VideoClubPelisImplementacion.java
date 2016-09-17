package Persistencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import Negocio.Peliculas;
import Negocio.Socios;

public class VideoClubPelisImplementacion implements VideoClubPelisInterface {

	private String strFile = "VideoClubPelis.txt";

	@Override
	public boolean grabarVideoClubPeliculas(List<Peliculas> listaPeliculas) {
		File archivo = new File(strFile);
		FileOutputStream fout = null;
		ObjectOutputStream objOut = null;
		FileInputStream fIn = null;
		ObjectInputStream objIn = null;
		try {
			if (!archivo.exists()) {
				archivo.createNewFile();
			} else {

				BufferedReader br = new BufferedReader(new FileReader(strFile));
				if (br.readLine() == null) {
					System.out.println("");
				} else {
					fIn = new FileInputStream(archivo);
					objIn = new ObjectInputStream(fIn);
					listaPeliculas.addAll((ArrayList<Peliculas>) objIn.readObject());
				}
			}
			fout = new FileOutputStream(archivo);
			objOut = new ObjectOutputStream(fout);
			objOut.writeObject(listaPeliculas);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				objOut.close();
				fout.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	@Override
	public List<Peliculas> modificarVideoClubPeliculas(ArrayList<Peliculas> listaPeliculas, Peliculas objPeliculas) {
		int index = 0;
		for (Peliculas obj : listaPeliculas) {
			if (obj.getTitulo().equals(objPeliculas.getTitulo().trim())) {
				listaPeliculas.set(index, objPeliculas);
			}
			index = index + 1;
		}

		File archivo = new File(strFile);
		FileOutputStream fout = null;
		ObjectOutputStream objOut = null;

		try {
			fout = new FileOutputStream(archivo);
			objOut = new ObjectOutputStream(fout);
			objOut.writeObject(listaPeliculas);

		} catch (IOException e) {

			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Peliculas> leerVideoClubPeliculas() {
		ArrayList<Peliculas> listaRetorno = null;
		File archivo = new File(strFile);
		FileInputStream fIn = null;
		ObjectInputStream objIn = null;
		try {
			fIn = new FileInputStream(archivo);
			objIn = new ObjectInputStream(fIn);
			if (!archivo.exists()) {
				return null;
			}
			listaRetorno = (ArrayList<Peliculas>) objIn.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				objIn.close();
				fIn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listaRetorno;
	}

	@Override
	public List<Peliculas> eliminarItemVideoClubPeliculas(ArrayList<Peliculas> listaPeliculas, Peliculas objPeliculas) {
		int indice = 0;
		for (Peliculas obj : listaPeliculas) {
			if (obj.getTitulo().equals(objPeliculas.getTitulo().trim())) {
				listaPeliculas.remove(indice);
				break;
			}
			indice = indice + 1;
		}
		System.out.println("Pelicula Eliminada");

		return listaPeliculas;
	}

	@Override
	public void leerVideoClubPeliculas(ArrayList<Peliculas> listaPeliculas) {
		int i = 1;
		for (Peliculas p : listaPeliculas) {
			System.out.println("----------- Pelicula " + i + " ----------- \n");
			System.out.println("Formato: " + p.getFormato().trim() + "\t");
			System.out.println("Nombre: " + p.getTitulo().trim() + "\t");
			System.out.println("Cantidad: " + p.getCantidad().trim() + "\t");
			System.out.println("Genero: " + p.getGenero().trim() + "\n");
			i = i + 1;
		}
	}

	@Override
	public void buscarPeliculas(ArrayList<Peliculas> listaPeliculas, String buscar) {

		for (Peliculas p : listaPeliculas) {
			if (p.getTitulo().trim().equalsIgnoreCase(buscar)) {
				System.out.println("----------- Peliculas ----------- \n");
				System.out.println("Formato: " + p.getFormato().trim() + "\t");
				System.out.println("Nombre: " + p.getTitulo().trim() + "\t");
				System.out.println("Cantidad: " + p.getCantidad().trim() + "\t");
				System.out.println("Genero: " + p.getGenero().trim() + "\n");
			}
		}
	}

}
