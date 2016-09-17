package Persistencia;

import java.util.ArrayList;
import java.util.List;

import Negocio.Socios;

public interface VideoClubSociosInterface {

	public boolean grabarVideoClub(List<Socios> listaSocios);

	public List<Socios> modificarVideoClub(ArrayList<Socios> listaSocios, Socios objSocios);

	public List<Socios> leerVideoClub();

	public List<Socios> eliminarItemVideoClub(ArrayList<Socios> listaSocios, Socios objSocios);

	public void leerVideoClub(ArrayList<Socios> listaSocios);

	public void buscarSocios(ArrayList<Socios> listaSocios, String buscar);

}
