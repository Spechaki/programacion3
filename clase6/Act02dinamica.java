package Clase06;

public class Act02dinamica {
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
        int[] pesos = {2, 5, 6, 7};
        int[] valor = {4, 2, 1, 6};
        int capmochila = 10;

        int rendimientoMaximo = optimizarPresupuesto(pesos, valor, capmochila);
        System.out.println("Rendimiento máximo con el presupuesto " + capmochila + " es: " + rendimientoMaximo);
    }
}

/*
Prueba de escritorio:
		Pesos: {2, 5, 6, 7}
		Valores: {4, 2, 1, 6}
		Capacidad de la mochila: 10
		
		Paso 1:Crear la tabla de programación dinámica
		
		La tabla será de tamaño 5 x 11 (4 objetos más el caso base, y capacidad de la mochila de 0 a 10).
		
		i/j |	0 |	1 |	2 |	3 |	4 |	5 |	6 |	7 |	8 |	9  | 10
		0   |	0 |	0 |	0 |	0 |	0 |	0 |	0 |	0 |	0 |	0  | 0
		1   |	0 |	0 |	4 |	4 |	4 |	4 |	4 |	4 |	4 | 4  | 4
		2   |	0 |	0 |	4 |	4 |	4 |	4 |	4 |	6 |	6 |	6  | 6
		3   |	0 |	0 | 4 | 4 |	4 |	4 |	4 |	6 |	6 |	6  | 6
		4   |	0 |	0 |	4 |	4 |	4 |	4 |	4 |	6 |	6 |	10 | 10
		
		Paso 2: Completar la tabla
		
		1.	Objeto 1:
			Con capacidad de la mochila < 2, dp[1][j] = 0.
			Con capacidad de la mochila >= 2, podemos incluir al objeto 1 con valor 4.
		
			Resultados para el objeto 1:
				Para j >= 2, el valor es 4.
		
		2.	Objeto 2:
			Con capacidad de la mochila < 5, no podemos incluir al objeto 2.
			Con capacidad de la mochila >= 5, podemos incluir al objeto 2 con valor 2.
		
			Resultados para el objeto 2:
				Para j < 7: valor objeto 1 > valor objeto 2.
				Para j >= 7: Sumamos objeto 1 + objeto 2 = valor de 6.
				
		3.	Objeto 3:
			Con capacidad de la mochila < 6, no podemos incluir al objeto 3.
			Con capacidad de la mochila >= 6, podemos incluir al objeto 3 con valor 1.
			
			Resultados para el objeto 3:
				Para j = 6: La mejor combinacion sigue siendo 1+2, rendimiento es 6.
				Para j = 10: La mejor combinacion sigue siendo 1+2, rendimiento es 6.
				
		4.	Objeto 4:
			Con capacidad de la mochila < 7, no podemos incluir al objeto 4 con valor 6.
			Con capacidad de la mochila >= 7, incluimos al jugador 4, obteniendo un rendimiento de 6.
			
			Resultados para el objeto 4:
				Para j = 7:  1+2 rinde lo mismo que 4 solo, rendimiento es 6.
				Para j >= 9: La mejor combinacion es 1+4, rendimiento es 10.
		
		Paso 3: Resultado
			El rendimiento máximo con un presupuesto de 10 es 10.
*/
