package Clase06;

public class Act04bruta {
	
    // Clase que representa un objeto con peso y valor.
    static class Objeto {
        int peso;
        int valor;

        public Objeto(int peso, int valor) {
            this.peso = peso;
            this.valor = valor;
        }
    }

    // Método principal
    public static void main(String[] args) {
        // Definir los jugadores
    	Objeto[] objetos = {
            new Objeto(12, 150),  // Objeto 1
            new Objeto(20, 200),  // Objeto 2
            new Objeto(15, 100),   // Objeto 3
            new Objeto(25, 300)   // Objeto 4
        };
        
        int capmochila = 35;  // Capacidad de la mochila

        // Llamamos a la función que realiza la búsqueda de la mejor combinación
        Resultado mejorResultado = mejorCombinacion(objetos, capmochila);
        
        // Mostrar el resultado
        System.out.println("Valor máximo: " + mejorResultado.valorMaximo);
        System.out.println("Peso total: " + mejorResultado.pesoTotal);
    }

    // Clase para almacenar el resultado de la mejor combinación
    static class Resultado {
        int valorMaximo;
        int pesoTotal;

        public Resultado(int valorMaximo, int pesoTotal) {
            this.valorMaximo = valorMaximo;
            this.pesoTotal = pesoTotal;
        }
    }

    // Función para encontrar la mejor combinación
    static Resultado mejorCombinacion(Objeto[] objetos, int capmochila) {
        int n = objetos.length;
        int mejorValor = 0;
        int mejorPeso = 0;

        // Probar todas las combinaciones posibles (2^n combinaciones)
        for (int i = 0; i < (1 << n); i++) {  // "1 << n" es 2^n
            int pesoTotal = 0;
            int valorTotal = 0;

            // Recorremos cada bit de la combinación actual
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {  // Si el bit j está activado en i
                	pesoTotal += objetos[j].peso;
                	valorTotal += objetos[j].valor;
                }
            }

            // Verificar si el costo total no excede el presupuesto y si el rendimiento es mejor
            if (pesoTotal <= capmochila && valorTotal > mejorValor) {
            	mejorValor = valorTotal;
            	mejorPeso = pesoTotal;
            }
        }

        // Retornar el mejor resultado
        return new Resultado(mejorValor, mejorPeso);
    }
}

/*
Complejidad:
	mejorCombinacion(): Recorre todas las combinaciones posibles de proyectos usando un bucle que va desde 0 hasta 2^n. Por lo tanto, efectivamente, la complejidad temporal de esta solución O(2^n)
*/
