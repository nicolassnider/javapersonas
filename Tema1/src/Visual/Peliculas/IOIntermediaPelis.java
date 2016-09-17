package Visual.Peliculas;

import Negocio.Peliculas;
import Persistencia.VideoClubPelisImplementacion;

import java.util.ArrayList;
import java.util.List;

public class IOIntermediaPelis {

	private List<Peliculas> listaPeliculas = new ArrayList<Peliculas>();

	public IOIntermediaPelis() {
		VideoClubPelisImplementacion objVideoClubPelis = new VideoClubPelisImplementacion();
		if (this.listaPeliculas == null || this.listaPeliculas.isEmpty()) {
			this.listaPeliculas = objVideoClubPelis.leerVideoClubPeliculas();
		}
	}

	public void desplegarMenu() {
		IOVideoClubPelis ioVideoClubPelis = new IOVideoClubPelis();
		int opcion = 0;
		boolean salir = false;
		while (!salir) {
			opcion = ioVideoClubPelis.mostrarMenu();
			switch (opcion) {
			case 1:
				this.listaPeliculas = ioVideoClubPelis.agregarPeliculas(this.listaPeliculas);
				break;
			case 2:
				ioVideoClubPelis.buscarPeliculas(this.listaPeliculas);
				break;
			case 3:
				this.listaPeliculas = ioVideoClubPelis.modificarPeliculas(this.listaPeliculas);
				break;
			case 4:
				this.listaPeliculas = ioVideoClubPelis.eliminarPeliculas(this.listaPeliculas);
				break;
			case 5:
				ioVideoClubPelis.listaPeliculas(this.listaPeliculas);
				break;
			case 6:
				ioVideoClubPelis.volverMenuPrincipal();
				salir = true;
				break;
			case 7:
				ioVideoClubPelis.salir(this.listaPeliculas);
				salir = true;
				break;
			}
		}
	}

}
