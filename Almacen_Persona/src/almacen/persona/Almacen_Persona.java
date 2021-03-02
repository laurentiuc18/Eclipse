package almacen.persona;

public class Almacen_Persona {

	public static void main(String[] args) {
		
		Persona p1=new Persona("Manolo",20);
		Persona p2=new Persona("Pedro",29);	
		Persona p3=new Persona();
		
		p1.print();
		p2.print();
		
		Almacen almacen=new Almacen();
		
		almacen.guardar(p1, "almacen.dat");
		almacen.guardar(p2, "almacen.dat");
		
		p3=almacen.recuperar("almacen.dat");
		
		p3.print();
		

	}

}
