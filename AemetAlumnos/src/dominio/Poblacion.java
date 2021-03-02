package dominio;

import java.util.*;

public class Poblacion {

	private String nombre;
	private String codigo;
	private ArrayList<Prediccion> predicciones;

	public Poblacion(String codigo) {
		this(codigo, "");
	}
	
	public Poblacion(String codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
		predicciones = new ArrayList<Prediccion>();
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public ArrayList<Prediccion> getPredicciones() {
		return predicciones;
	}

	public void setPredicciones(ArrayList<Prediccion> predicciones) {
		this.predicciones = predicciones;
	}
	
}