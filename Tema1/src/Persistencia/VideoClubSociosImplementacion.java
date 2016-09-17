package Persistencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import Negocio.Peliculas;
import Negocio.Socios;

public class VideoClubSociosImplementacion implements VideoClubSociosInterface {

	private String strFile = "VideoClub.txt";

	@Override
	public boolean grabarVideoClub(List<Socios> listaSocios) {
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
					listaSocios.addAll((ArrayList<Socios>) objIn.readObject());
				}

			}
			fout = new FileOutputStream(archivo);
			objOut = new ObjectOutputStream(fout);
			objOut.writeObject(listaSocios);
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
	public List<Socios> modificarVideoClub(ArrayList<Socios> listaSocios, Socios objSocios) {
		int index = 0;
		for (Socios obj : listaSocios) {
			if (obj.getDni().equals(objSocios.getDni().trim())) {
				listaSocios.set(index, objSocios);
				return listaSocios;
			}
			index = index + 1;
		}
		return null;
	}

	@Override
	public List<Socios> leerVideoClub() {

		ArrayList<Socios> listaRetorno = null;
		File archivo = new File(strFile);
		FileInputStream fIn = null;
		ObjectInputStream objIn = null;
		try {
			if (!archivo.exists()) {
				return null;
			}
			fIn = new FileInputStream(archivo);
			objIn = new ObjectInputStream(fIn);

			listaRetorno = (ArrayList<Socios>) objIn.readObject();
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
	public List<Socios> eliminarItemVideoClub(ArrayList<Socios> listaSocios, Socios objSocios) {
		int indice = 0;
		for (Socios obj : listaSocios) {
			if (obj.getDni().equals(objSocios.getDni().trim())) {
				listaSocios.remove(indice);
				break;
			}
			indice = indice + 1;
		}
		return listaSocios;
	}

	@Override
	public void leerVideoClub(ArrayList<Socios> listaSocios) {
		int i = 1;
		for (Socios s : listaSocios) {
			System.out.println("----------- Socio n° " + i + " ----------- \n");
			System.out.println("Nombre: " + s.getNombre().trim() + "\t");
			System.out.println("Apellido: " + s.getApellido().trim() + "\t");
			System.out.println("DNI: " + s.getDni().trim() + "\t");
			System.out.println("Telefono: " + s.getTelefono().trim() + "\n");
			if (s.getPeli() != null)
				System.out.println("Pelicula Alquilada: " + s.getPeli().trim() + "\n");
			i = i + 1;
		}
	}

	@Override
	public void buscarSocios(ArrayList<Socios> listaSocios, String buscar) {

		for (Socios s : listaSocios) {
			if (s.getNombre().trim().equalsIgnoreCase(buscar)) {
				System.out.println("----------- Socio ----------- \n");
				System.out.println("Nombre: " + s.getNombre().trim() + "\t");
				System.out.println("Apellido: " + s.getApellido().trim() + "\t");
				System.out.println("DNI: " + s.getDni().trim() + "\t");
				System.out.println("Telefono: " + s.getTelefono().trim() + "\n");
			}
		}
	}

}
