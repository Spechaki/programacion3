package Clase03;

public class Act01 {

	
	// Clase Cliente
	static class Cliente {
	    int id;
	    String nombre;
	    int scoring;

	    // Constructor
	    public Cliente(int id, String nombre, int scoring) {
	        this.id = id;
	        this.nombre = nombre;
	        this.scoring = scoring;
	    }
	}
	    
	// Función que encuentra el cliente con el máximo scoring
    public static Cliente encontrarClienteConMaximoScoring(Cliente[] clientes, int inicio, int fin) {
        
    	// Caso base: si solo hay un cliente en el intervalo
        if (inicio == fin) {
            return clientes[inicio];
        }

        // Dividir el intervalo en dos partes
        int mitad = (inicio + fin) / 2;

        // Llamadas recursivas
        Cliente maxIzquierda = encontrarClienteConMaximoScoring(clientes, inicio, mitad);
        Cliente maxDerecha = encontrarClienteConMaximoScoring(clientes, mitad + 1, fin);

        // Combinar los resultados
        if (maxIzquierda.scoring >= maxDerecha.scoring) {
            return maxIzquierda;
        } else {
            return maxDerecha;
        }
    }

    public static void main(String[] args) {
        // Crear lista de clientes
    	Cliente[]clientes = {
        		new Cliente(1, "Juan", 85),
                new Cliente(2, "Ana", 95),
                new Cliente(3, "Luis", 90),
                new Cliente(4, "Maria", 100),
                new Cliente(5, "Pedro", 80),
        };
    	
        // Encontrar el cliente con el scoring máximo
        Cliente clienteMaximo = encontrarClienteConMaximoScoring(clientes, 0, clientes.length - 1);

        // Imprimir el cliente con el scoring máximo
        System.out.println("El cliente con el scoring máximo es " + clienteMaximo.nombre + " con un scoring de " + clienteMaximo.scoring);
    }
	
}


/*
Análisis de recurrencia por método inductivo:

1. Entendiendo la Recurrencia:
La lista de clientes se divide en dos mitades repetidamente, buscando el cliente con el scoring máximo en cada una de esas mitades y luego comparando los resultados de ambas para determinar cuál es el cliente con el scoring máximo.
Si la lista original tiene n elementos, sus mitades tendran n/2 elementos, sus mitades n/4, y asi sucesivamente hasta que solo haya un elemento.


2. Caso base:
Si el arreglo tiene un solo elemento (n=1), el tiempo de ejecución es una constante, T(1) = c.


3. Paso inductivo:

Si el arreglo tiene n=2 elementos. El algoritmo divide este problema en dos subproblemas de tamaño 1 y devuelve el mayor. 
Esto implica hacer dos veces el trabajo del caso base, más un trabajo constante para combinar los resultados. Así que el tiempo total para n=2 será:

T(2) = 2 T(1) + c

Como T(1) = c  tenemos que T(2) = 2c + c = 3c


4. Generalizando el Razonamiento:

El número de niveles de recursión está determinado por cuántas veces podemos dividir la lista por la mitad, lo que resulta en una estructura de árbol de recursión.
El número de niveles de este árbol es aproximadamente log n (ya que estamos dividiendo por 2 en cada nivel)


5. Conclusion:
Dado que el número de niveles de recursión es log n y en cada nivel realizamos un número constante de comparaciones proporcionales a n, la complejidad total del algoritmo es:

O(n log n)
 */
