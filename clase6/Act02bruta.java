package Clase06;

public class Act02bruta {
	
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
            new Objeto(2, 4),  // Objeto 1
            new Objeto(5, 2),  // Objeto 2
            new Objeto(6, 1),   // Objeto 3
            new Objeto(7, 6)   // Objeto 4
        };
        
        int capmochila = 10;  // Capacidad de la mochila

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
Para el ejemplo con 4 objetos, hay 2^4 =16 combinaciones posibles.
	 Combinación 0000: Nada → Valor: 0, Peso: 0
	 Combinación 0001: Objeto 4 → Valor: 6, Peso: 7
	 Combinación 0010: Objeto 3 → Valor: 1, Peso: 6
	 Combinación 0011: Objetos 3 y 4 → Valor: 7, Peso: 13 (Excede la capacidad de mochila)
	 Combinación 0100: Objeto 2 → Valor: 2, Peso: 5
	 Combinación 0101: Objetos 2 y 4 → Valor: 8, Peso: 12 (Excede la capacidad de mochila)
	 Combinación 0110: Objetos 2 y 3 → Valor: 3, Peso: 11 (Excede la capacidad de mochila) 
	 Combinación 0111: Objetos 2, 3 y 4 → Valor: 9, Peso: 18 (Excede la capacidad de mochila)
	 Combinación 1000: Objeto 1 → Valor: 4, Peso: 2
	 Combinación 1001: Objetos 1 y 4 → Valor: 10, Peso: 9 (mejor)
	 Combinación 1010: Objetos 1 y 3 → Valor: 5, Peso: 8
	 Combinación 1011: Objetos 1, 3 y 4 → Valor: 11, Peso: 15 (Excede la capacidad de mochila)
	 Combinación 1100: Objetos 1 y 2 → Valor: 6, Peso: 7
	 Combinación 1101: Objetos 1, 2 y 4 → Valor: 12, Peso: 14 (Excede la capacidad de mochila)
	 Combinación 1110: Objetos 1, 2 y 3 → Valor: 7, Peso: 13 (Excede la capacidad de mochila)
	 Combinación 1111: Objetos 1, 2, 3 y 4 → Valor: 13, Peso: 20 (Excede la capacidad de mochila)
*/