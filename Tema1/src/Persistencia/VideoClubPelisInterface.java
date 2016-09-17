package Persistencia;

import java.util.ArrayList;
import java.util.List;

import Negocio.Peliculas;

public interface VideoClubPelisInterface {

	public boolean grabarVideoClubPeliculas(List<Peliculas> listaPeliculas);

	public List<Peliculas> modificarVideoClubPeliculas(ArrayList<Peliculas> listaPeliculas, Peliculas objPeliculas);

	public List<Peliculas> leerVideoClubPeliculas();

	public List<Peliculas> eliminarItemVideoClubPeliculas(ArrayList<Peliculas> listaPeliculas, Peliculas objPeliculas);

	public void leerVideoClubPeliculas(ArrayList<Peliculas> listaPeliculas);

	public void buscarPeliculas(ArrayList<Peliculas> listaPeliculas, String buscar);

}
