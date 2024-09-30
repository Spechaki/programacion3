package clase7Actividad1;

public class FloydWarshall {
final static int INF = 99999;  // Usamos un valor grande para representar el infinito
    
    public static void main(String[] args) {
        FloydWarshall fw = new FloydWarshall();
        int graph[][] = { 
                            {0, 2, INF, 5},
                            {INF, 0, INF, 4},
                            {INF, INF, 0, INF},
                            {INF, INF, 2, 0},
                        };
        int V = graph.length;
        fw.floydWarshall(graph, V);
    }


    
    
    void floydWarshall(int graph[][], int V) {
        int dist[][] = new int[V][V];
        // Inicializar la matriz de distancias
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }
     // Actualizar la matriz de distancias
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Imprimir la matriz de distancias
        printSolution(dist, V);
    }

    void printSolution(int dist[][], int V) {
        System.out.println("Matriz de distancias más cortas entre cada par de vértices:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + "   ");
            }
            System.out.println();
        }
    }

}

/* 
 * Prueba de escritorio:

Paso 1: Inicializacion de la matriz de distancias
(0,2,7,5)
(INF,0,I,4)
(INF,INF,0,INF)
(INF,INF,2,0)

Explicación de la matriz:
Nodo 1 a 1: Distancia 0, ya que es el mismo nodo.
Nodo 1 a 2: Distancia 2.
Nodo 1 a 3: No hay camino directo, así que INF.
Nodo 1 a 4: Distancia 5.
Nodo 2 a 1: No hay camino directo, así que INF.
Nodo 2 a 2: Distancia 0, ya que es el mismo nodo.
Nodo 2 a 3: No hay camino directo, así que INF.
Nodo 2 a 4: Distancia 4.
Nodo 3 a 1:No hay camino directo, así que INF.
Nodo 3 a 2: No hay camino directo, así que INF.
Nodo 3 a 3: Distancia 0, ya que es el mismo nodo.
Nodo 3 a 4:No hay camino directo, así que INF.
Nodo 4 a 1:No hay camino directo, así que INF.
Nodo 4 a 2:No hay camino directo, así que INF.
Nodo 4 a 3: Distancia 3.
Nodo 4 a 4:Distancia 0, ya que es el mismo nodo.

Ahora iteramos sobre cada nodo intermedio k (1, 2, 3 y 4) para actualizar las
distancias mínimas entre todos los pares de nodos (i, j).

Iteración k = 1:
Verificamos si pasar por el nodo intermedio 1 da una distancia más corta: 
Como esto no sucede, la matriz de distancias no cambia. Ningún camino usa al número 1 como vértice intermedio.

Iteración k = 2:
Verificamos si pasar por el nodo intermedio 2 da una distancia más corta: 
Como esto no sucede, la matriz de distancias no cambia. Ningún camino usa al número 2 como vértice intermedio.

Iteración k = 3:
Verificamos si pasar por el nodo intermedio 3 da una distancia más corta: 
Como esto no sucede, la matriz de distancias no cambia. Ningún camino usa al número 3 como vértice intermedio.

Iteración k = 4:
Para i = 1, j = 3:
dist[1][3] = min(dist[1][3],dist[1][4]+dist[4][3])
dist[1][3] = min(INF,7)
Ahora la distancia de 1 a 3 es 7.

Para i = 2, j = 3:
dist[2][3] = min(dist[2][3],dist[2][4]+dist[4][3])
dist[2][3] = min(INF,6)
Ahora la distancia de 2 a 3 es 6.
 * */
