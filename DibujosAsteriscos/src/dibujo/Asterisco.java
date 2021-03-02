package dibujo;

import java.util.Scanner;

public class Asterisco {

	public static void main(String[] args) {
		int num;
		
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Ingresa Tamaño del triangulo");
		num=sc.nextInt();
		
		
		trianguloIzquierdaArriba(num);
		trianguloIzquierdaAbajo(num);
		trianguloDerechaArriba(num);
		trianguloDerechaAbajo(num);
	}

	
	
	public static void trianguloIzquierdaArriba(int numero) {
		
		
		int incremento=0;
		for (int i = 0; i < numero; i++) {
			incremento++;			
			
			for (int j = 0; j <incremento ; j++) {
				System.out.print("*");
				
			}
			System.out.println();
		}
		
	}
	
	
	
public static void trianguloIzquierdaAbajo(int numero) {
		
		

	
	for (int i = 0; i < numero; i++) {
			
		
		for (int j = 0; j <numero-i ; j++) {
			System.out.print("*");
			
		}
		System.out.println();
	}


		
	}




public static void trianguloDerechaAbajo(int numero) {
		
		

	
	for (int i = 0; i < numero; i++) {
			
		
		for (int j = 0; j <numero ; j++) {
		
			
			
			if (i <= j){
		        System.out.print("*");
		    }else{
		        System.out.print(" ");
			
		    }
			
		}
		System.out.println();
	}


		
	}



public static void trianguloDerechaArriba(int numero) {
		
		

	
	for (int i = 0; i < numero; i++) {
	
	
		for (int j = numero-1; j >=0 ; j--) {
		
			
			
			if (i >= j){
		        System.out.print("*");
		    }else{
		        System.out.print(" ");
			
		    }
			
		}
		System.out.println();
	}


		
	}
}
