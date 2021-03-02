package dominio;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class Prediccion { 

	private String fecha;
	private String prec1;
	private String prec2;

	

	public Prediccion(String fecha) {
		this.fecha = fecha;
	}
	
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

}