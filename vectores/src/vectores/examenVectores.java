package vectores;

import java.util.Random;

public class examenVectores {

	public static void main(String[] args) {
		
	
		
		
		
		//Crear 3 vectores de tamanyo aleatorio con valores primos aleatorios
		int[] v1 = generarVectorPrimosRandom();
		int[] v2 = generarVectorPrimosRandom();
		int[] v3 = generarVectorPrimosRandom();
		
		
		
		//Imprimir vectores
		imprimirVector(v1);
		imprimirVector(v2);
		imprimirVector(v3);
		//Sumar los 3 vectores
		int[] r = sumar(v1, v2, v3);
		//Imprimir resultado
		imprimirVector(r);


	}

	public static void imprimirVector(int[] array) {
		System.out.printf("%n%8s","Indice");
		for (int i = 0; i < array.length; i++) {
			System.out.printf("%5d", i);
		}
	
		System.out.printf("%n%8s","Valor");
		for (int i = 0; i < array.length; i++) {
			System.out.printf("%5d", array[i]);
		}
		System.out.println("");
		
	}

	public static int[] generaVectorMultiplosTresCinco() {
		Random rand = new Random();
		
		
		int[] array=new int[rand.nextInt()];
		
		for(int i=0;i<array.length;i++) {
			int random=(int)(Math.random()*15);
			int numeroAleatorio=random;
			
			if(numeroAleatorio % 3==0||numeroAleatorio % 5==0) {}
			
			array[i]=numeroAleatorio;
		}
		return null;
		
		
	} 
	
	private static int[] sumar(int[] v1, int[] v2, int[] v3) {
		
		int[] array;
		if (v1.length > v2.length && v1.length > v3.length) {
			array = new int[v1.length];
		} else if (v2.length > v1.length && v2.length > v3.length) {
			array = new int[v2.length];
		} else {
			array = new int[v3.length];
		}
		
		for (int i = 0; i < array.length; i++) {
			if (i < v1.length) {
				array[i] = array[i] + v1[i];
			} if (i < v2.length) {
				array[i] = array[i] + v2[i];
			} if (i < v3.length) {
				array[i] = array[i] + v3[i];
			}
		}
		
		
		return array;
	}



	private static int[] generarVectorPrimosRandom() {
		
		 Random numRandom = new Random();
		 int tamanyoArray = numRandom.nextInt(16);
		 int [] array;
		 array= new int[tamanyoArray];
		 boolean primo =false;
		
		 
		 for (int i=0; i<array.length;i++) {
			 
			 array[i]=numRandom.nextInt(101);
			   primo =numeroPrimo(array[i]);
			   
			   
			   while (primo == false) {
					array[i] = numRandom.nextInt(102);
					
					primo = numeroPrimo(array[i]);}
			
		 }
		
		
		return array;
	}
	

	public static boolean numeroPrimo(int num) {
	    boolean primo = false; 
	    for(int i = 2; i <= num/2; ++i)
        {
   
            if(num % i == 0)
            {
            	primo = true;
                break;
            }
	      
	    }
		return primo;
	  
	    }
	
	

}
