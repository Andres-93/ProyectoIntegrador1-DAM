package modelo;

public class Alumno {

	private String nombre;
	private int expediente;
	
	public Alumno(String nombre, int expediente) {
		this.nombre = nombre;
		this.expediente = expediente;
	}

	public String getNombre() {
		return nombre;
	}

	public int getExpediente() {
		return expediente;
	}

	@Override
	public String toString() {
		return "- Nombre : " + nombre + ". Expediente : " + expediente;
	}
	
	
}
