package vectores;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class crearFicheros {

	public static void main(String[] args) {
		File fichero = new File("");

		File directorio = new File("directorio1");

		File sePuedeEscribir = new File("C:\\Windows");

		File ruta = new File("C:\\xampp");

		// String info = System.getProperty("C:/Windows");
		// File carpeta = new File(info);

		// El archivo se crea en la carpeta donde esta creado este .java

		try {

			if (fichero.createNewFile()) {
				System.out.println("el el fichero se ha creado");
			} else {

				System.out.println("el fichero  ya esta creado en " + fichero.getAbsolutePath());
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (directorio.mkdirs()) {

			System.out.println("el directorio se ha creado");
		} else {

			System.out.println("el directorio ya esta creado en " + directorio.getAbsolutePath());
		}

		if (sePuedeEscribir.canWrite()) {
			System.out.println("El directorio C:\\ Windows se puede escribir");
		} else {
			System.out.println("El directorio C:\\ Windows no se puede escribir");
		}

		String[] archivos;

		archivos = ruta.list();
		System.out.println("Los archivos en C:\\\\xampp son: ");
		for (int i = 0; i < archivos.length; i++) {

			System.out.println(archivos[i]);
		}

	}

}
