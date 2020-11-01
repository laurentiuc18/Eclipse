package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GestionDatos {

	public GestionDatos() {

	}

	public static BufferedReader abrirFicheros (String fichero1) throws FileNotFoundException {
		FileReader file= new FileReader(fichero1);
		BufferedReader buffer = new BufferedReader(file);
		return buffer;
	}
	
	public static void cerrarFicheros (BufferedReader buffer1) throws IOException {
		buffer1.close();
	}
	
	public static boolean compararContenido (String fichero1, String fichero2) throws IOException{
		
		BufferedReader[] buffer = new BufferedReader[2];
		buffer[0] = abrirFicheros(fichero1);
		buffer[1] = abrirFicheros(fichero2);
		
		String LeerFichero1 = buffer[0].readLine();
		String LeerFichero2 = buffer[1].readLine();
		
		while(LeerFichero1 != null && LeerFichero2 != null) {
			if(!LeerFichero1.equals(LeerFichero2)) {
				return false;
			} else {
				LeerFichero1 = buffer[0].readLine();
				LeerFichero2 = buffer[1].readLine();
			}
		}
		cerrarFicheros(buffer[0]);
		cerrarFicheros(buffer[1]);
		return true;
	}
	
	public static int buscarPalabra (String fichero1, String palabra, boolean primera_aparicion) throws IOException{
		BufferedReader[] buffer = new BufferedReader[1];
		buffer[0] = abrirFicheros(fichero1);
		String texto = buffer[0].readLine();
		int cont=0;
		int line = 1, finalLine = -1;
		
		List<String> palabra1 = new ArrayList<String>();
		
		if(primera_aparicion == true) {
			while(texto != null) {
				palabra1 = Arrays.asList(texto.split(" "));
				if(palabra1.contains(palabra)) {
					return line;
				}
				texto = buffer[0].readLine();
				line++;
			}
		} else {
			while(texto != null) {
				palabra1 = Arrays.asList(texto.split(" "));
				texto = buffer[0].readLine();
				line++;
				if(palabra1.contains(palabra)) {
					return line;
				}
				texto = buffer[0].readLine();
				
			}
			return finalLine;
		}
		cerrarFicheros(buffer[0]);
		return -1;
	}	

}
