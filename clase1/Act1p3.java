package Clase01;

public class Act1p3 {
	//Actividad 1.3
	
	// Sumar los primeros n números enteros, implementando en java un algoritmo que use recursión
	static int sumaRecur(int x) {
		if (x==1) {
			return 1;				
		}
		else {
			return x + sumaRecur(x-1);
		}
	}
	
	/*
	1. Identificar el costo en cada llamada
		El tiempo que toma cada llamada de la función es constante, es decir, O(1), porque solo realiza una suma y una llamada recursiva. Por lo tanto, el costo en cada nivel de la recursión es constante.
	
	2. Definir la ecuación de recurrencia
		Caso base: x == 1	 T(1) = O(1)T(1) = O(1)T(1) = O(1).
		Caso recursivo: x > 1	T(x) = T(x−1)+O(1)T(x) = T(x - 1) + O(1)T(x) = T(x−1)+O(1)

	3. Resolver la ecuación de recurrencia
		T(x)=T(x−1)+O(1)T(x) = T(x - 1) + O(1)T(x)=T(x−1)+O(1)
		T(x)=T(x−1)+O(1)T(x) = T(x - 1) + O(1)T(x)=T(x−1)+O(1) T(x−1)=T(x−2)+O(1)T(x - 1) = T(x - 2) + O(1)T(x−1)=T(x−2)+O(1) T(x−2)=T(x−3)+O(1)T(x - 2) = T(x - 3) + O(1)T(x−2)=T(x−3)+O(1) ⋮\vdots⋮ T(2)=T(1)+O(1)T(2) = T(1) + O(1)T(2)=T(1)+O(1)
		
		Caso base:
		T(1)=O(1)T(1) = O(1)T(1)=O(1)
		
		Sumando todas las operaciones:
		T(x)=O(1)+O(1)+O(1)+⋯+O(1)T(x) = O(1) + O(1) + O(1) + \dots + O(1)T(x)=O(1)+O(1)+O(1)+⋯+O(1)
		
		Tiempo total es:
		T(x)=O(x)T(x) = O(x)T(x)=O(x)
		
	4. Conclusión
		La función recursiva sumaRecur(int x) tiene una complejidad temporal lineal, es decir, T(x) = O(x)T(x) = O(x)T(x) = O(x). Esto significa que el tiempo de ejecución crece proporcionalmente al valor de x.
	*/
	
	public static void main(String[] args) {
		System.out.println(sumaRecur(5));		
	}
}
