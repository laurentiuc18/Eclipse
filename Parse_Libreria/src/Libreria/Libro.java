
package Libreria;

public class Libro {
	
	String Titulo;
	String Autor;
	int NumPag;
	int Anyo;
	String Editor;
	public Libro() {

	}
	
	public Libro( String Titulo, String Autor,int NumPag, int Anyo, String Editor ){
		this.Titulo = Titulo;
		this.Autor = Autor;
		this.NumPag = NumPag;
		this.Anyo = Anyo;
		this.Editor=Editor;

	}
	
	@Override
	public String toString() {
		String libro = "";
		libro = libro+"Titulo: "+Titulo+"\n";
		libro = libro+"Autor: "+Autor+"\n";
		libro = libro+"Numero de Paginas: "+NumPag+"\n";
		libro = libro+"Anyo de Publicacion: "+Anyo+"\n";
		libro =libro+"Editor: "+Editor+"\n\n";

		return libro;
	}
}
