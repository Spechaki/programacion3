package Clase06;

public class Act01bruta {
	
	// 1) Dada una mochila con una capacidad máxima de peso P, y dispones de n objetos. Cada objeto tiene un peso w  y un valor v
	//El objetivo es seleccionar algunos objetos de manera que maximicen el valor total, sin superar la capacidad de la mochila, que es de 6
	
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
            new Objeto(3, 4),  // Objeto 1
            new Objeto(4, 5),  // Objeto 2
            new Objeto(2, 3)   // Objeto 3
        };
        
        int capmochila = 6;  // Capacidad de la mochila

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
Prueba de escritorio:
Para el ejemplo con 3 objetos, hay 2^3 =8 combinaciones posibles.
	 Combinación 000: No seleccionamos nada → Valor: 0, Peso: 0
	 Combinación 001: Solo seleccionamos el Objeto 3 → Valor: 3, Peso: 2
	 Combinación 010: Solo seleccionamos el Objeto 2 → Valor: 5, Peso: 4
	 Combinación 011: Objetos 2 y 3 → Valor: 8, Peso: 6 (mejor)
	 Combinación 100: Solo seleccionamos el Objeto 1 → Valor: 4, Peso: 3
	 Combinación 101: Objetos 1 y 3 → Valor: 7, Peso: 5
	 Combinación 110: Objetos 1 y 2 → Valor: 9, Peso: 7 (Excede la capacidad de mochila)
	 Combinación 111: Objetos 1, 2 y 3 → Valor: 12, Peso: 9 (Excede la capacidad de mochila)
*/

