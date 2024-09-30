package Clase01;

public class Act1p1 {
	//Actividad 1.1
	//a)
	//Calcula el maximo de un array
	static int maxArray(int[] array) {
		int mayor = array[0];					//	2
		for(int i=0; i<array.length; i++) {		//	1 + 2(n+1) + 2n = 3 + 4n
			if(array[i]>mayor) {				//	n * (2 + 2) = 4n
				mayor=array[i];					//	
			}									//
		}										//
		return mayor;							//	1
	}											//	Total = 2 + 3 + 4n + 4n + 1 = 8n + 6
	
												//Notacion big O:
												//					8n + 6 <= c*n
												//					8 + 6/n <= c
												//					8 <= c (con n aproximandose a infinito)
												//					Tomamos c = 9
												//
												//					8 + 6/n <= 9
												//					6/n <= 1
												//					n >= 6
												//
												//					f(n)= 8n + 6 es O(n) con c=9 y n0=6
	
	public static void main(String[] args) {
		int[] array2 = {9,1,2,3,12};
		System.out.println(maxArray(array2));	
	}
}
