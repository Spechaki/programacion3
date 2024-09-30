package Clase03;

import java.util.Arrays;

public class Act04 {

    // Método para encontrar los "n" elementos más grandes utilizando Divide y Vencerás
    public static int[] encontrarNElementosMasGrandes(int[] numeros, int n, int inicio, int fin) {
        // Caso base: Si el número de elementos es igual o menor que "n", devolvemos esos elementos
        if (fin - inicio + 1 <= n) {
            int[] resultado = Arrays.copyOfRange(numeros, inicio, fin + 1);
            Arrays.sort(resultado); // Ordenamos para devolver los n más grandes
            return resultado;
        }

        // Dividir el array en dos mitades
        int mitad = (inicio + fin) / 2;

        // Llamadas recursivas para las dos mitades
        int[] maxIzquierda = encontrarNElementosMasGrandes(numeros, n, inicio, mitad);
        int[] maxDerecha = encontrarNElementosMasGrandes(numeros, n, mitad + 1, fin);

        // Combinar los resultados: juntar y ordenar los "2n" elementos más grandes
        int[] combinados = new int[maxIzquierda.length + maxDerecha.length];
        System.arraycopy(maxIzquierda, 0, combinados, 0, maxIzquierda.length);
        System.arraycopy(maxDerecha, 0, combinados, maxIzquierda.length, maxDerecha.length);

        // Ordenamos los combinados y tomamos los "n" elementos más grandes
        Arrays.sort(combinados);
        return Arrays.copyOfRange(combinados, combinados.length - n, combinados.length);
    }

    public static void main(String[] args) {
        // Array de números
        int[] numeros = {15,42,8,23,91,67,30,54,77,3,89};
        int n = 5;
        
        // Encontrar los "n" elementos más grandes
        int[] nMasGrandes = encontrarNElementosMasGrandes(numeros, n, 0, numeros.length - 1);

        // Imprimir los "n" elementos más grandes
        System.out.println("Los " + n + " elementos más grandes son: " + Arrays.toString(nMasGrandes));
    }
}

/*

Paso 1: Caso base
Si el tamaño del array es pequeño (igual a "n"), simplemente devolvemos los elementos presentes en el subarray. En este caso, no necesitamos dividir más el problema, y las operaciones son constantes, es decir, O(1).
Paso 2: Descomposición del problema
Cuando el tamaño de la lista es mayor a "n", dividimos el array en dos partes:

Realizamos una llamada recursiva para encontrar los "n" elementos más grandes en la mitad izquierda.
Realizamos una llamada recursiva para encontrar los "n" elementos más grandes en la mitad derecha.
Esta técnica sigue el mismo patrón que otros problemas de Divide y Vencerás. Cada llamada reduce el problema dividiendo el array en mitades, lo que da lugar a un árbol de recursión de profundidad log n.

Paso 3: Combinación de los resultados
Una vez que obtenemos los "n" elementos más grandes en la mitad izquierda y los "n" elementos más grandes en la mitad derecha, debemos combinarlos.

Se toman los 2n elementos (los "n" mayores de cada mitad).
Se ordenan los 2n elementos para seleccionar los "n" más grandes.
Ordenar 2n elementos toma tiempo proporcional a O(n log n), ya que la operación de ordenar es más costosa en esta etapa.

Paso 4: Evaluación del tiempo total
En cada nivel de recursión, dividimos el array a la mitad y resolvemos dos subproblemas. En el paso de combinación, ordenamos los 2n elementos más grandes, lo que toma O(n log n). Este proceso ocurre en cada nivel del árbol de recursión, que tiene una profundidad de log N (donde N es el tamaño original del array).

Paso 5: Complejidad total
La complejidad total del algoritmo es O(n log n * log N), ya que:

En cada nivel de recursión, ordenamos 2n elementos, lo que toma tiempo O(n log n).
La profundidad del árbol de recursión es log N, ya que cada nivel divide el array en dos.
Conclusión
El análisis de recurrencia muestra que la complejidad del algoritmo para encontrar los "n" elementos más grandes en un array utilizando Divide y Vencerás es O(n log n * log N).

*/