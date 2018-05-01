package modelo;

public class Ciclo {

	private String nombre;
	private String descripcion;
	
	public Ciclo(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	
	public String toString() {
		return "Nombre = " + nombre + " Descripcion =" + descripcion;
	}
		
}
