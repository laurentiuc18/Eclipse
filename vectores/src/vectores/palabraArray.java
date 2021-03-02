package vectores;

import java.util.Scanner;

public class palabraArray {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		int numeroArray;
		
		System.out.println("Numero de frases que vas a ingresar");
		numeroArray=sc.nextInt();
		
		String array[];
		array = new String[numeroArray];
		
		sc.nextLine();
		
		for(int i=0;i<array.length;i++) {
			
			System.out.println("Ingresa frase");
			
			array[i]=sc.nextLine();
			
			
		}
for(int x=0;x<array.length;x++) {
			
	String [] palabra= array[x].split(" ");
	
	
	System.out.println(palabra[1]);
	
			
		}

	}

}
