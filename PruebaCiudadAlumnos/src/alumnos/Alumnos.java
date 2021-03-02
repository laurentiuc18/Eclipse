package alumnos;

import java.text.Normalizer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Alumnos {

	public static void main(String[] args) {
	int num;
	int cont=0;
	String Alumno;
		HashMap <Integer, String> map = new HashMap <Integer, String>();
		 Scanner sc=new Scanner(System.in);
		System.out.println("Quiere iniciar el progrma?\n 0=No 1=Si");
		
		num=sc.nextInt();
		
		while (num!=0) {
			
		System.out.println("Añade alumn@");
		
		Alumno=sc.nextLine();
		Alumno=sc.nextLine();
		
		Alumno=Alumno.toLowerCase().trim();
		Alumno= Normalizer.normalize(Alumno, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
		
		
		map.put(cont,Alumno);
		cont++;
		System.out.println("Quiere seguir usando el programa\\n 0=No 1=Si");
		num=sc.nextInt();
		
		}
		Set set = map.entrySet();
		Iterator iterator = set.iterator();
		while(iterator.hasNext()) {
			Map.Entry mentry = (Map.Entry)iterator.next();
			System.out.println("Clave: "+ mentry.getKey() + " - Valor: " + mentry.getValue());
		}		
	}

}
