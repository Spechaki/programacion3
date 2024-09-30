package Clase01;

import java.math.BigInteger;

public class Ejercicio00 {
	//Se fija si todos los numeros dentro de un array son pares
	static boolean todosPares(int[] array) {
		for(int i=0; i<array.length; i++) {
			if(array[i]%2!=0) {
				System.out.println("El elemento '"+array[i]+"' en la posicion '"+(i+1)+"' no es par.");
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[] array = {2, 4, 1, 6};
		System.out.println(todosPares(array));		
	}
}
