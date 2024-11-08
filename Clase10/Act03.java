package Clase10;

public class Act03 {

    static int N = 4; // Tamaño del tablero 4x4

    // Función para verificar si la ubicación de un computadora es válida
    public static boolean esSeguroComputadora(int tablero[][], int fila, int col) {
        // Verificar fila
        for (int i = 0; i < N; i++) {
            if (tablero[fila][i] == 1) {
                return false;
            }
        }
        // Verificar columna
        for (int i = 0; i < N; i++) {
            if (tablero[i][col] == 1) {
                return false;
            }
        }
        return true;
    }

    // Función para verificar si la ubicación de una impresora es válida
    public static boolean esSeguroImpresora(int tablero[][], int fila, int col) {
        // Verificar fila
        for (int i = 0; i < N; i++) {
            if (tablero[fila][i] == 2) {
                return false;
            }
        }
        // Verificar columna
        for (int i = 0; i < N; i++) {
            if (tablero[i][col] == 2) {
                return false;
            }
        }
        return true;
    }

    // Función para resolver el problema
    public static void resolverDisenoInteriores() {
        int[][] tablero = new int[N][N]; // Crear un tablero vacío
        colocarComputadoras(tablero, 0, 0); // Iniciar colocando los computadoras
    }

    // Función recursiva para colocar computadoras
    public static boolean colocarComputadoras(int[][] tablero, int fila, int computadorasColocados) {
        if (computadorasColocados == 4) { // Si hemos colocado 4 computadoras, pasar a colocar impresoras
            colocarImpresoras(tablero, 0, 0);
            return true;
        }

        for (int i = fila; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (esSeguroComputadora(tablero, i, j)) {
                    // Colocar computadora
                    tablero[i][j] = 1;
                    
                    // Recursión para colocar el siguiente computadora
                    colocarComputadoras(tablero, i + 1, computadorasColocados + 1);
                    
                    // Backtrack: quitar computadora
                    tablero[i][j] = 0;
                }
            }
        }

        return false; // No hay solución válida en esta rama
    }

    // Función recursiva para colocar impresoras
    public static boolean colocarImpresoras(int[][] tablero, int fila, int impresorasColocadas) {
        if (impresorasColocadas == 4) { // Si se han colocado 4 impresoras, imprimir el tablero
            imprimirTablero(tablero);
            return true;
        }

        for (int i = fila; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (esSeguroImpresora(tablero, i, j) && tablero[i][j] == 0) {
                    // Colocar impresora
                    tablero[i][j] = 2;
                    
                    // Recursión para colocar la siguiente impresora
                    colocarImpresoras(tablero, i + 1, impresorasColocadas + 1);
                    
                    // Backtrack: quitar impresora
                    tablero[i][j] = 0;
                }
            }
        }

        return false; // No hay solución válida en esta rama
    }

    // Función para imprimir el tablero
    public static void imprimirTablero(int[][] tablero) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tablero[i][j] == 1) {
                    System.out.print("C "); // Computadora
                } else if (tablero[i][j] == 2) {
                    System.out.print("I "); // Impresora
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        resolverDisenoInteriores();
    }
}
