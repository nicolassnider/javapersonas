package Visual.Socios;

import Negocio.Socios;
import Persistencia.VideoClubSociosImplementacion;

import java.util.ArrayList;
import java.util.List;

public class IOIntermediaSocios {

	private List<Socios> listaSocios = new ArrayList<Socios>();

	public IOIntermediaSocios() {
		VideoClubSociosImplementacion objVideoClub = new VideoClubSociosImplementacion();
		if (this.listaSocios == null || this.listaSocios.isEmpty()) {
			this.listaSocios = objVideoClub.leerVideoClub();
		}
	}

	public void desplegarMenu() {
		IOVideoClubSocios ioVideoClub = new IOVideoClubSocios();
		int opcion = 0;
		boolean salir = false;
		while (!salir) {
			opcion = ioVideoClub.mostrarMenu();
			switch (opcion) {
			case 1:
				this.listaSocios = ioVideoClub.agregarSocios(this.listaSocios);
				break;
			case 2:
				ioVideoClub.buscarSocios(this.listaSocios);
				break;
			case 3:
				this.listaSocios = ioVideoClub.modificarSocios(this.listaSocios);
				break;
			case 4:
				this.listaSocios = ioVideoClub.eliminarSocios(this.listaSocios);
				break;
			case 5:
				ioVideoClub.listaSocios(this.listaSocios);
				break;
			case 6:
				ioVideoClub.alquilaPeli(this.listaSocios);
				break;
			case 7:
				ioVideoClub.devuelvePeli(this.listaSocios);
				break;
			case 8:
				ioVideoClub.volverMenuPrincipal();
				break;
			case 9:
				ioVideoClub.salir(this.listaSocios);
				salir = true;
				break;
			}
		}
	}

}
