package Visual.Peliculas;

import java.util.ArrayList;
import java.util.List;
import Negocio.Peliculas;
import Persistencia.VideoClubPelisImplementacion;
import Visual.IOGeneral;
import Visual.MenuGral.menuGral;

public class IOVideoClubPelis {

	public int mostrarMenu() {
		int opc = 0;
		boolean selecOK = false;
		while (!selecOK) {
			opc = IOGeneral.leerInt("1 - Agregar Pelicula \n" + "2 - Buscar Pelicula \n" + "3 - Modificar Pelicula \n"
					+ "4 - Eliminar Pelicula \n" + "5 - Listar Pelicula \n" + "6 - Volver \n" + "7 - Salir \n"
					+ "Seleccione un opcion: ", "Debe de ingresar un numero valido");
			if (opc >= 1 && opc <= 7) {
				selecOK = true;
			} else {
				System.out.println("Debe de seleccionar una opcion correcta");
			}
		}
		return opc;
	}

	public List<Peliculas> agregarPeliculas(List<Peliculas> listaPeliculas) {
		VideoClubPelisImplementacion objVideoClubPelis = new VideoClubPelisImplementacion();

		List<Peliculas> listaTransitoria = new ArrayList<Peliculas>();
		Peliculas objPeliculas = new Peliculas();

		objPeliculas.setFormato(IOGeneral.leerLinea("Ingrese Formato de Peli(DVD O BD): "));
		objPeliculas.setTitulo(IOGeneral.leerLinea("Ingrese Nombre: "));
		objPeliculas
				.setCantidad(String.valueOf(IOGeneral.leerInt("Ingrese cantidad: ", "Debe de ingresar solo numeros")));
		objPeliculas.setGenero(IOGeneral.leerLinea("Ingrese Genero (suspenso, terror, acción,etc): "));
		listaTransitoria.add(objPeliculas);
		boolean flag = objVideoClubPelis.grabarVideoClubPeliculas(listaTransitoria);
		if (flag)
			System.out.println("Peli guardada:)");

		return listaTransitoria;
	}

	public List<Peliculas> modificarPeliculas(List<Peliculas> listaPeliculas) {
		VideoClubPelisImplementacion objVideoClubPelis = new VideoClubPelisImplementacion();
		Peliculas objPeliculas = new Peliculas();
		List<Peliculas> listaTemp = listaPeliculas;
		String titulo = (IOGeneral.leerLinea("Ingrese Nombre: "));
		boolean existePeliculas = false;
		for (Peliculas p : listaPeliculas) {
			if (p.getTitulo().trim().equals(titulo.trim())) {
				existePeliculas = true;
				break;
			}
		}
		if (existePeliculas) {

			objPeliculas.setFormato(IOGeneral.leerLinea("Ingrese formato a modifcar: "));
			objPeliculas.setTitulo(titulo);
			objPeliculas.setGenero(IOGeneral.leerLinea("Ingrese Genero modificar: "));
			objPeliculas.setCantidad(String
					.valueOf(IOGeneral.leerInt("Ingrese cantidad a modificar: ", "Debe de ingresar solo numeros")));
			listaPeliculas = objVideoClubPelis.modificarVideoClubPeliculas((ArrayList<Peliculas>) listaPeliculas,
					objPeliculas);
			if (listaPeliculas == null) {
				System.out.println("No se puedo realizar la modificación de la pelicula");
				listaPeliculas = listaTemp;
				listaTemp.clear();
			}
		} else {
			System.out.println("No existe Pelicula con nombre " + titulo);
		}
		return listaPeliculas;
	}

	public List<Peliculas> eliminarPeliculas(List<Peliculas> listaPeliculas) {
		VideoClubPelisImplementacion objVideoClubPelis = new VideoClubPelisImplementacion();
		Peliculas objPeliculas = new Peliculas();
		String Titulo = (IOGeneral.leerLinea("Ingrese Nombre: "));
		boolean existePeliculas = false;
		for (Peliculas p : listaPeliculas) {
			if (p.getTitulo().trim().equals(Titulo.trim())) {
				existePeliculas = true;
				break;
			}
		}
		if (existePeliculas) {
			objPeliculas.setTitulo(Titulo);
			listaPeliculas = objVideoClubPelis.eliminarItemVideoClubPeliculas((ArrayList<Peliculas>) listaPeliculas,
					objPeliculas);
		} else {
			System.out.println("No existe pelicula con titulo " + Titulo);
		}
		return listaPeliculas;
	}

	public void salir(List<Peliculas> listaPeliculas) {
		VideoClubPelisImplementacion objPeliculas = new VideoClubPelisImplementacion();
		objPeliculas.grabarVideoClubPeliculas((ArrayList<Peliculas>) listaPeliculas);
		System.out.println("Saliendo de la aplicación");
	}

	public void listaPeliculas(List<Peliculas> listaPeliculas) {
		VideoClubPelisImplementacion objPeliculas = new VideoClubPelisImplementacion();
		objPeliculas.leerVideoClubPeliculas((ArrayList<Peliculas>) listaPeliculas);
	}

	public List<Peliculas> TraerPeliculas() {
		List<Peliculas> listaPeliculas = null;
		VideoClubPelisImplementacion objVideoClubPelis = new VideoClubPelisImplementacion();
		if (listaPeliculas == null || listaPeliculas.isEmpty()) {
			listaPeliculas = objVideoClubPelis.leerVideoClubPeliculas();
		}
		return listaPeliculas;
	}

	public void buscarPeliculas(List<Peliculas> listaPeliculas) {
		VideoClubPelisImplementacion objPeliculas = new VideoClubPelisImplementacion();
		String buscar = IOGeneral.leerLinea("Ingrese nombre a buscar: ");
		objPeliculas.buscarPeliculas((ArrayList<Peliculas>) listaPeliculas, buscar);

		return;
	}

	public void volverMenuPrincipal() {
		System.out.flush();
		menuGral menuOBJ = new menuGral();
		menuOBJ.desplegarMenu();
	}

}
