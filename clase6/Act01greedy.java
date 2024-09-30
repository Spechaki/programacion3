package Clase06;

import java.util.Arrays;
import java.util.Comparator;

public class Act01greedy {
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
            new Objeto(3, 4),  // Objeto 1
            new Objeto(4, 5),  // Objeto 2
            new Objeto(2, 3)   // Objeto 3
        };

        int capmochila = 6;  // Presupuesto máximo

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
Prueba de escritorio:
	Seleccionamos primero al objeto 3, ya que tiene la mayor relación valor/costo (1.5). Esto nos 
	cuesta 2 unidades del peso y obtenemos un valor de 3.
	Ahora tenemos un peso restante de 6−2=4. Con este peso, seleccionamos al objeto 1, porque tiene la segunda mejor 
	relación valor/costo (1.25), y aún nos queda suficiente peso para llevarlo. Esto nos cuesta 
	3 unidades más, dejando un peso restante de 1, y obtenemos un valor adicional de 4. Con 
	un peso de 1, no podemos agregar mas objetos, ya que el objeto 2 peso 4. valor: 
	objeto 3 (valor 3) + objeto 1 (valor 4) = valor 7.
	
	Sin embargo, el greedy falla aca ya que la mejor combinacion es el 2 con el 3, con un peso total de 6 y un valor total de 8.
*/