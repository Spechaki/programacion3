package Clase06;

import java.util.Arrays;
import java.util.Comparator;

public class Act04greedy {
    // Clase que representa un objeto con peso, valor y la relación valor/peso
    static class Objeto {
        int peso;
        int valor;
        double relacion;

        public Objeto(int peso, int valor) {
            this.peso = peso;
            this.valor = valor;
            this.relacion = (double) valor / peso;
        }
    }

    // Método principal
    public static void main(String[] args) {
        // Definir los Objetos
    	Objeto[] objetos = {
            new Objeto(12, 150),  // Objeto 1
            new Objeto(20, 200),  // Objeto 2
            new Objeto(15, 100),  // Objeto 3
            new Objeto(25, 300)   // Objeto 4
        };
        
        int capmochila = 35;  // Capacidad de la mochila

        // Llamar a la función que selecciona Objetos usando el enfoque greedy
        int valorMaximo = seleccionGreedy(objetos, capmochila);

        // Mostrar el resultado
        System.out.println("valor máximo usando greedy: " + valorMaximo);
    }

    // Función para seleccionar Objetos usando técnica greedy
    static int seleccionGreedy(Objeto[] objetos, int capmochila) {
        // Ordenamos los Objetoes por la relación valor/peso de mayor a menor
        Arrays.sort(objetos, Comparator.comparingDouble(j -> -j.relacion));

        int valorTotal = 0;
        int pesoTotal = 0;

        // Seleccionar Objetoes mientras el presupuesto lo permita
        for (Objeto objeto : objetos) {
            if (pesoTotal + objeto.peso <= capmochila) {
                pesoTotal += objeto.peso;
                valorTotal += objeto.valor;
            }
        }

        // Retornar el valor total
        return valorTotal;
    }
}

/*
Complejidad:
	El algoritmo primero ordena los objetos en función de la relación valor/peso de mayor a menor usando:
		Arrays.sort(objetos, Comparator.comparingDouble(j -> -j.relacion));
	El tiempo de complejidad del método es O(n log n).
	Después de ordenar, el algoritmo recorre la lista de objetos y selecciona los que caben en la mochila, recorre todos los objetos una sola vez, por lo que tiene una complejidad de O(n).
	Sin embargo, dado que O(n log n) domina, esa es su complejidad final.
*/