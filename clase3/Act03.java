package Clase03;

public class Act03 {
	
	
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


    // Función para encontrar los dos clientes con los máximos scorings
    public static Cliente[] encontrarDosClientesConMaximoScoring(Cliente[] clientes, int inicio, int fin) {
        
    	// Caso base: Si solo hay un cliente
        if (inicio == fin) {
            return new Cliente[]{clientes[inicio], null};
        }
        
        // Caso base: Si hay dos clientes, los comparamos
        if (fin == inicio + 1) {
            if (clientes[inicio].scoring >= clientes[fin].scoring) {
                return new Cliente[]{clientes[inicio], clientes[fin]};
            } else {
                return new Cliente[]{clientes[fin], clientes[inicio]};
            }
        }

        // Dividir el intervalo en dos partes
        int mitad = (inicio + fin) / 2;

        // Llamadas recursivas
        Cliente[] maxIzquierda = encontrarDosClientesConMaximoScoring(clientes, inicio, mitad);
        Cliente[] maxDerecha = encontrarDosClientesConMaximoScoring(clientes, mitad + 1, fin);

        // Combinar los resultados: comparar los dos mejores de la izquierda y los dos mejores de la derecha
        Cliente[] maximos = new Cliente[4];
        maximos[0] = maxIzquierda[0];
        maximos[1] = maxIzquierda[1];
        maximos[2] = maxDerecha[0];
        maximos[3] = maxDerecha[1];
        
        // Ordenar los cuatro clientes por scoring
        java.util.Arrays.sort(maximos, (a, b) -> {
            if (a == null) return 1;  // Los nulos van al final
            if (b == null) return -1;
            return b.scoring - a.scoring;  // Orden descendente por scoring
        });

        // Devolver los dos primeros clientes (los dos máximos)
        return new Cliente[]{maximos[0], maximos[1]};
    }

    public static void main(String[] args) {
        // Crear lista de clientes
        Cliente[] clientes = {
                new Cliente(1, "Juan", 85),
                new Cliente(2, "Ana", 95),
                new Cliente(3, "Luis", 90),
                new Cliente(4, "Maria", 100),
                new Cliente(5, "Pedro", 80)
        };

        // Encontrar los dos clientes con el scoring máximo
        Cliente[] dosMaximos = encontrarDosClientesConMaximoScoring(clientes, 0, clientes.length - 1);

        // Imprimir los dos clientes con el scoring máximo
        System.out.println("El cliente con el scoring máximo es: " + dosMaximos[0].nombre);
        System.out.println("El segundo cliente con el scoring máximo es: " + (dosMaximos[1] != null ? dosMaximos[1].nombre : "Ninguno"));
    }
}

/*
Análisis de recurrencia por método inductivo:

1. Entendiendo la Recurrencia:
La lista de clientes se divide en dos mitades repetidamente, buscando el cliente con el scoring máximo en cada una de esas mitades y luego comparando los resultados de ambas para determinar cuál es el cliente con el scoring máximo.
Si la lista original tiene n elementos, sus mitades tendran n/2 elementos, sus mitades n/4, y asi sucesivamente hasta que solo haya un elemento.


2. Caso base:
Si el arreglo tiene un solo elemento (n=1), este cliente es automáticamente uno de los dos máximos, y necesitamos devolver un segundo valor "nulo" o algún marcador para indicar que no hay un segundo cliente.
Si la lista tiene dos clientes, simplemente se comparan ambos y se devuelven esos dos como los máximos.
En ambos casos, estas operaciones son constantes, por lo que el costo es O(1).


3. Paso inductivo:
Cuando tenemos más de dos clientes, dividimos la lista en dos partes, una llamada recursiva se hace para encontrar los dos máximos en la mitad izquierda y otra para la derecha.
Cada una de estas llamadas a su vez dividirá su respectiva sublista en mitades, y así sucesivamente, hasta que lleguemos a sublistas de tamaño 1 o 2.
Una vez que obtenemos los dos clientes con el mayor scoring de la mitad izquierda y los dos clientes con el mayor scoring de la mitad derecha, debemos combinar esos resultados.
Esta operación de combinación requiere comparar y ordenar cuatro clientes, lo que toma tiempo constante, es decir, O(1).


4. Generalizando el Razonamiento:
El problema se divide repetidamente en dos mitades, lo que crea un árbol de recursión con aproximadamente log n niveles.
En cada nivel de recursión, se resuelven dos subproblemas (mitad izquierda y mitad derecha) y luego se combinan los resultados. El número total de comparaciones que se realiza en cada nivel es proporcional a n,
ya que cada cliente participa en un número constante de comparaciones por nivel.


5. Conclusion:
Dado que el número de niveles de recursión es log n y en cada nivel realizamos un número constante de comparaciones proporcionales a n, la complejidad total del algoritmo es:

O(n log n)
*/