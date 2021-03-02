package vectores;

import java.util.Random;
import java.util.Scanner;

public class gallinero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random rand = new Random();
		int[] array;
		array = new int[11];

		for (int i = 0; i < array.length; i++) {

			array[i] = rand.nextInt(5);

		}
		imprimirGallinero(array);
		ingresaGallinas(array);

	}

	public static int ingresaGallinas(int[] array) {

		int numGallinas = 0;
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < array.length; i++) {

			while (array[i] < 4) {

				System.out.println("¿Cuántas gallinas ha comprado?");
				numGallinas = sc.nextInt();
				if ((numGallinas > 0) && (numGallinas <= 4)) {

					comprobarGallinero(array, numGallinas);

				} else { 

					System.out.println("Lo siento, no admitimos grupos de " + numGallinas
							+ " gallinas, devuelvalas y compre ‘packs’ de 4 gallinas como máximo e intente de nuevo");
				}

			}

		}
		return numGallinas;
	}

	public static void comprobarGallinero(int[] array, int numGallinas) {
		int numeroArray;

		for (int i = 0; i < array.length; i++) {
			numeroArray = array[i];
			numeroArray = numeroArray + numGallinas;

			if (numeroArray <= 4) {
				array[i] = numeroArray;
				System.out.println("¿Por favor, introduzca las gallinas en el gallinero número : " + i);
				imprimirGallinero(array);
				ingresaGallinas(array);
			} else if (i == 10) {
				System.out.println("Lo siento, en estos momentos no queda sitio en ningún gallinero.");
		
		

			}
		}
		
	}
	
	public static void imprimirGallinero(int[] array) {
		System.out.printf("%n%8s","Gallinero");
		for (int i = 0; i < array.length; i++) {
			System.out.printf("%5d", i);
		}
	
		System.out.printf("%n%8s","Ocupacion");
		for (int i = 0; i < array.length; i++) {
			System.out.printf("%5d", array[i]);
		}
		System.out.println("");
		
	}
}
