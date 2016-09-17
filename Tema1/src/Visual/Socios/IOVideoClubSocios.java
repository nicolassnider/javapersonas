package Visual.Socios;

import java.util.ArrayList;
import java.util.List;

import Negocio.Peliculas;
import Negocio.Socios;
import Persistencia.VideoClubPelisImplementacion;
import Persistencia.VideoClubSociosImplementacion;
import Visual.IOGeneral;
import Visual.MenuGral.menuGral;
import Visual.Peliculas.IOIntermediaPelis;
import Visual.Peliculas.IOVideoClubPelis;

public class IOVideoClubSocios {

	private List<Socios> listaSocios;

	public int mostrarMenu() {
		int opc = 0;
		boolean selecOK = false;
		while (!selecOK) {
			opc = IOGeneral.leerInt("1 - Agregar Socios \n" + "2 - Buscar Socios \n" + "3 - Modificar Socios \n"
					+ "4 - Eliminar Socios \n" + "5 - Listar Socios \n" + "6 - Alquila \n" + "7 - Devuelve \n"
					+ "8 - Volver \n" + "Seleccione un opcion: ", "Debe de ingresar un numero valido");
			if (opc >= 0 && opc <= 8) {
				selecOK = true;
			} else {
				System.out.println("Debe de seleccionar una opcion correcta");
			}
		}
		return opc;
	}

	public List<Socios> agregarSocios(List<Socios> listaSocios) {
		VideoClubSociosImplementacion objVideoClub = new VideoClubSociosImplementacion();
		List<Socios> listaTransitoria = new ArrayList<Socios>();
		Socios objSocios = new Socios();

		objSocios.setNombre(IOGeneral.leerLinea("Ingrese nombre: "));
		objSocios.setApellido(IOGeneral.leerLinea("Ingrese apellido: "));
		objSocios.setDni(String.valueOf(IOGeneral.leerInt("Ingrese dni: ", "Debe de ingresar solo numeros")));
		objSocios.setTelefono(String.valueOf(IOGeneral.leerInt("Ingrese telefono: ", "Debe de ingresar solo numeros")));
		listaTransitoria.add(objSocios);
		objVideoClub.grabarVideoClub(listaTransitoria);
		return listaTransitoria;
	}

	private boolean checkequearSocio(List<Socios> listaSocios, String dni) {
		boolean existeSocios = false;
		for (Socios s : listaSocios) {
			if (s.getDni().trim().equals(dni.trim())) {
				existeSocios = true;
				break;
			}
		}
		if (existeSocios) {
			return true;
		}

		return false;
	}

	public void alquilaPeli(List<Socios> listaSocios) {
		VideoClubSociosImplementacion objVideoClub = new VideoClubSociosImplementacion();
		VideoClubPelisImplementacion objVideoClubPelis = new VideoClubPelisImplementacion();
		String dni = String.valueOf(IOGeneral.leerInt("Ingrese dni de socio", "solo debe de ingresar nuneros"));
		String titulo = "";
		boolean existe = checkequearSocio(listaSocios, dni);
		boolean existePelicula = false;
		Peliculas peli = new Peliculas();

		if (existe) {

			IOVideoClubPelis videoMNG = new IOVideoClubPelis();
			List<Peliculas> peliculas = videoMNG.TraerPeliculas();

			String buscar = IOGeneral.leerLinea("Ingrese nombre de la pelicula: ");

			for (Peliculas p : peliculas) {
				if (p.getTitulo().trim().equalsIgnoreCase(buscar)) {
					peli = p;
					existePelicula = true;

				}
			}
			if (existePelicula) {
				peli.setCantidad(String.valueOf(Integer.valueOf(peli.getCantidad()) - 1));
				titulo = peli.getTitulo();
				objVideoClubPelis.modificarVideoClubPeliculas((ArrayList<Peliculas>) peliculas, peli);

				for (Socios s : listaSocios) {

					if (s.getDni().trim().equals(dni.trim())) {
						s.setPeli(titulo);
					}
					objVideoClub.modificarVideoClub((ArrayList<Socios>) listaSocios, s);
					// listaSocios =
					// objVideoClub.modificarVideoClub((ArrayList<Socios>)
					// listaSocios, s);
					// objVideoClub.grabarVideoClub(listaSocios);
				}
				System.out.println("Pelicula Alquilada \n");

			} else {
				System.out.println("Pelicula no existe \n");
			}

		} else {
			System.out.println("No es socio \n");
			volverMenuPrincipal();
		}

	}

	public void devuelvePeli(List<Socios> listaSocios) {
		VideoClubSociosImplementacion objVideoClub = new VideoClubSociosImplementacion();
		VideoClubPelisImplementacion objVideoClubPelis = new VideoClubPelisImplementacion();
		String dni = String.valueOf(IOGeneral.leerInt("Ingrese dni de socio", "solo debe de ingresar nuneros"));
		String titulo = "";
		boolean existe = checkequearSocio(listaSocios, dni);
		boolean existePelicula = false;
		Peliculas peli = new Peliculas();

		if (existe) {

			IOVideoClubPelis videoMNG = new IOVideoClubPelis();
			List<Peliculas> peliculas = videoMNG.TraerPeliculas();

			String buscar = IOGeneral.leerLinea("Ingrese nombre de la  pelicula: ");

			for (Peliculas p : peliculas) {
				if (p.getTitulo().trim().equalsIgnoreCase(buscar)) {
					peli = p;
					existePelicula = true;

				}
			}
			if (existePelicula) {
				peli.setCantidad(String.valueOf(Integer.valueOf(peli.getCantidad()) + 1));
				titulo = peli.getTitulo();
				objVideoClubPelis.modificarVideoClubPeliculas((ArrayList<Peliculas>) peliculas, peli);

				for (Socios s : listaSocios) {

					if (s.getDni().trim().equals(dni.trim())) {
						s.setPeli("");
					}
					objVideoClub.modificarVideoClub((ArrayList<Socios>) listaSocios, s);

				}
				System.out.println("Pelicula devuelta");

			} else {
				System.out.println("Pelicula no existe");
			}

		} else {
			System.out.println("No es socio");
			volverMenuPrincipal();
		}

	}

	public List<Socios> modificarSocios(List<Socios> listaSocios) {
		VideoClubSociosImplementacion objVideoClub = new VideoClubSociosImplementacion();
		Socios objSocios = new Socios();
		List<Socios> listaTemp = listaSocios;
		String dni = String
				.valueOf(IOGeneral.leerInt("Ingrese dni de persona a modificar", "solo debe de ingresar nuneros"));
		boolean existeSocios = false;
		for (Socios s : listaSocios) {
			if (s.getDni().trim().equals(dni.trim())) {
				existeSocios = true;
				break;
			}
		}
		if (existeSocios) {

			objSocios.setApellido(IOGeneral.leerLinea("Ingrese apellido a modifcar: "));
			objSocios.setDni(dni);
			objSocios.setNombre(IOGeneral.leerLinea("Ingrese nombre a modificar: "));
			objSocios.setTelefono(String
					.valueOf(IOGeneral.leerInt("Ingrese telefono a modificar: ", "Debe de ingresar solo numeros")));
			listaSocios = objVideoClub.modificarVideoClub((ArrayList<Socios>) listaSocios, objSocios);

			if (listaSocios == null) {
				System.out.println("No se puedo realizar la modificación de la persona");
				listaSocios = listaTemp;
				listaTemp.clear();
			}
		} else {
			System.out.println("No existe persona con DNI " + dni);
		}

		System.out.println("Persona Modificada!! \n");
		return listaSocios;
	}

	public List<Socios> eliminarSocios(List<Socios> listaSocios) {
		VideoClubSociosImplementacion objVideoClub = new VideoClubSociosImplementacion();
		Socios objSocios = new Socios();
		String dni = String
				.valueOf(IOGeneral.leerInt("Ingrese dni de persona a eliminar", "solo debe de ingresar nuneros"));
		boolean existeSocios = false;
		for (Socios s : listaSocios) {
			if (s.getDni().trim().equals(dni.trim())) {
				existeSocios = true;
				break;
			}
		}
		if (existeSocios) {
			objSocios.setDni(dni);
			listaSocios = objVideoClub.eliminarItemVideoClub((ArrayList<Socios>) listaSocios, objSocios);
		} else {
			System.out.println("No existe persona con DNI " + dni);
		}
		return listaSocios;
	}

	public void salir(List<Socios> listaSocios) {
		VideoClubSociosImplementacion objSocios = new VideoClubSociosImplementacion();
		objSocios.grabarVideoClub((ArrayList<Socios>) listaSocios);
		System.out.println("Saliendo de la aplicación");
	}

	public void listaSocios(List<Socios> listaSocios) {
		VideoClubSociosImplementacion objSocios = new VideoClubSociosImplementacion();
		objSocios.leerVideoClub((ArrayList<Socios>) listaSocios);
	}

	public void volverMenuPrincipal() {

		menuGral menuOBJ = new menuGral();
		menuOBJ.desplegarMenu();
	}

	public void buscarSocios(List<Socios> listaSocios) {
		VideoClubSociosImplementacion objSocios = new VideoClubSociosImplementacion();
		String buscar = IOGeneral.leerLinea("Ingrese nombre a buscar: ");
		objSocios.buscarSocios((ArrayList<Socios>) listaSocios, buscar);

		return;
	}

}
