package aplicacion;

import java.io.File;
import java.util.Scanner;
import java.util.TreeMap;

import dominio.Poblacion;
import leerDOM.LeerXML;

public class Principal {

	static TreeMap<String, String> mapaPoblacionCodigo;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String continuar = "s";
		
		//1.- Cargar todas las poblaciones de Espanya
		cargarTodasLasPoblaciones();
		
		//	
		while (continuar.equals("s")) {
		
			//2.- Preguntar municipio al usuario
			System.out.println("Dime la población:");
			String poblacion = sc.nextLine();
					
			//3.- Obtener el código del municipio
			String codigo = mapaPoblacionCodigo.get(poblacion.toLowerCase());
			
			//4.- Leer información del XML
			Poblacion p = LeerXML.almacenarInformacion( codigo );
			
			//5.- Mostrar información al usuario
			System.out.println( p.getPredicciones() );
			
			//6.- Preguntar si desea otra consulta
			System.out.println("¿Desea consultar la predicción de otro municipio? s/n");
			continuar = sc.nextLine();
		}
		
		System.out.println("HASTA PRONTO !!!");
		
		sc.close();
	}

	public static void cargarTodasLasPoblaciones() {

		mapaPoblacionCodigo = new TreeMap<String, String>();
		
		String codigo;
		String poblacion;

		try {

			Scanner sc = new Scanner(new File("src/ficheros/poblaciones.in"));
			
			while (sc.hasNext()) {
				
				codigo    = sc.next();
				poblacion = sc.nextLine().toLowerCase().trim();

				mapaPoblacionCodigo.put(poblacion, codigo);
			}
			
			sc.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}