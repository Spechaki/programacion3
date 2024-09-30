package Clase01;

public class Ejercicio01 {
	//Ejercicio 1
	//Recibe una matriz cuadrada, calcula el promedio de sus elementos
	static float promMatriz(int[][] array) {
		float suma = 0;
		for(int i=0; i<array.length; i++) {
			for(int j=0; j<array.length; j++) {
				suma += array[i][j];
			}
		}
		float promedio = suma/(array.length*array.length);
		return promedio;
	}
	
	public static void main(String[] args) {
		int[][] array1 = {{1,2,3},{1,2,3},{1,2,3}};
		System.out.println(promMatriz(array1));		
	}
}
