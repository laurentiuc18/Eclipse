package ciudades;

import java.text.Normalizer;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Ciudad {

	public static void main(String[] args) {
		 int num;
		 String ciudad;
		 Scanner sc=new Scanner(System.in);
		LinkedHashSet<String> set = new LinkedHashSet<String>();

		System.out.println("Quiere iniciar el progrma?\n 0=No 1=Si");
		
		num=sc.nextInt();
		
		while (num!=0) {
			
		System.out.println("Añade una ciudad");
		
		ciudad=sc.nextLine();
		ciudad=sc.nextLine();
		
		ciudad=ciudad.toLowerCase().trim();
		ciudad= Normalizer.normalize(ciudad, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");;
		
		
		set.add(ciudad);	
		System.out.println("Quiere seguir usando el programa\\n 0=No 1=Si");
		num=sc.nextInt();
		
		}
		
		
		Iterator<String> j = set.iterator();
		while (j.hasNext()) {
			System.out.println(j.next());
		}

	}

}
