package Negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Socios implements Serializable {

	private static final long serialVersionUID = -1616153778892821177L;

	private String dni;
	private String nombre;
	private String apellido;
	private String telefono;
	private String peli;

	public Socios() {
	}

	public Socios(String dni, String nombre, String apellido, String telefono, String peli) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.peli = peli;
	}

	public String getPeli() {
		return peli;
	}

	public void setPeli(String peli) {
		this.peli = peli;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void grabarVideoClub(List<Socios> listaTransitoria) {
		// TODO Auto-generated method stub

	}

}
