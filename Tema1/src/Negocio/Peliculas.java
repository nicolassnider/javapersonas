package Negocio;
import java.io.Serializable;
import java.util.List;


public class Peliculas implements Serializable {

	private static final long serialVersionUID = -1616153778892821177L;
	
	private String formato;
	private String titulo;
	private String genero;
	private String cantidad;
	
 
public Peliculas(){
	
	}


public String getTitulo() {
	return titulo;
}


public void setTitulo(String titulo) {
	this.titulo = titulo;
}


public String getGenero() {
	return genero;
}


public void setGenero(String genero) {
	this.genero = genero;
}


public String getCantidad() {
	return cantidad;
}


public void setCantidad(String cantidad) {
	this.cantidad = cantidad;
}

public String getFormato() {
	return formato;
}


public void setFormato(String formato) {
	this.formato = formato;
}


public void grabarVideoClubPeliculas(List<Peliculas> listaTransitoria) {
	// TODO Auto-generated method stub
	
}

}