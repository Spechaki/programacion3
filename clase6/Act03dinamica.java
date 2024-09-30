package Clase06;

public class Act03dinamica {
    public static int optimizarPresupuesto(int[] pesos, int[] valor, int capmochila) {
        int n = pesos.length;
        int[][] dp = new int[n + 1][capmochila + 1];

        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= capmochila; j++) {
                if (pesos[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - pesos[i - 1]] + valor[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][capmochila];
    }

    public static void main(String[] args) {
        int[] pesos = {10, 15, 20, 25};
        int[] valor = {100, 200, 150, 300};
        int capmochila = 40;

        int rendimientoMaximo = optimizarPresupuesto(pesos, valor, capmochila);
        System.out.println("Rendimiento máximo con el presupuesto " + capmochila + " es: " + rendimientoMaximo);
    }
}

/*
Complejidad:
	En el enfoque de programación dinámica, se construye una tabla dp[i][j], donde i representa los jugadores considerados y j el presupuesto disponible.
	Cada celda dp[i][j] almacena el rendimiento máximo al fichar jugadores dentro de un presupuesto j.
	Para cada jugador, se compara ficharlo o no ficharlo usando la recurrencia: dp[i][j] = max(dp[i−1][j],dp[i−1][j−ci]+ri).
	La tabla tiene tamaño n×P, donde n es el número de jugadores y P el presupuesto.
 	Resolviendo n×P subproblemas, cada uno en tiempo constante O(1).
 	Por tanto, la complejidad total es O(n×P).
*/