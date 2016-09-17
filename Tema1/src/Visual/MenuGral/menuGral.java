package Visual.MenuGral;

import Visual.IOGeneral;
import Visual.Peliculas.IOIntermediaPelis;
import Visual.Socios.IOIntermediaSocios;
import Visual.Socios.IOVideoClubSocios;

public class menuGral {

	private int mostrarMenu() {
		int opc = 0;
		boolean selecOK = false;
		while (!selecOK) {
			opc = IOGeneral.leerInt("1 - Socios\n" + "2 - Pelis\n" + "3 - Salir \n" + "Seleccione un opcion: ",
					"Debe de ingresar un numero valido");
			if (opc >= 1 && opc <= 3) {
				selecOK = true;
			} else {
				System.out.println("Debe de seleccionar una opcion correcta");
			}
		}
		return opc;
	}

	public void desplegarMenu() {
		IOVideoClubSocios ioVideoClub = new IOVideoClubSocios();
		int opcion = 0;
		boolean salir = false;
		while (!salir) {
			opcion = mostrarMenu();
			switch (opcion) {
			case 1:
				IOIntermediaSocios objSocio = new IOIntermediaSocios();
				objSocio.desplegarMenu();
				break;
			case 2:
				IOIntermediaPelis objPelis = new IOIntermediaPelis();
				objPelis.desplegarMenu();
				break;
			case 3:
				salir();

				break;
			}
		}
	}

	public void salir() {

		System.out.println("Saliendo de la aplicación");
	}

}
