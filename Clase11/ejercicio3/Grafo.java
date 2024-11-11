package ejercicio3;

import java.util.*;

public class Grafo {
    private final Map<Almacen, List<Almacen>> adjList;

    public Grafo() {
        this.adjList = new HashMap<>();
    }

    // Agrega un nuevo almacén al grafo
    public void agregarAlmacen(Almacen almacen) {
        adjList.putIfAbsent(almacen, new ArrayList<>());
    }

    // Crea una conexión (ruta) directa entre dos almacenes
    public void conectarAlmacenes(Almacen origen, Almacen destino) {
        adjList.get(origen).add(destino);
        adjList.get(destino).add(origen); // Para grafo no dirigido
    }

    // Recorrido en profundidad (DFS) desde un almacén de inicio
    public void dfs(Almacen inicio) {
        Set<Almacen> visitados = new HashSet<>();
        dfsRecursivo(inicio, visitados);
    }

    private void dfsRecursivo(Almacen actual, Set<Almacen> visitados) {
        visitados.add(actual);
        System.out.println(actual);

        for (Almacen vecino : adjList.get(actual)) {
            if (!visitados.contains(vecino)) {
                dfsRecursivo(vecino, visitados);
            }
        }
    }

    // Recorrido en anchura (BFS) desde un almacén de inicio
    public void bfs(Almacen inicio) {
        Set<Almacen> visitados = new HashSet<>();
        Queue<Almacen> cola = new LinkedList<>();

        visitados.add(inicio);
        cola.add(inicio);

        while (!cola.isEmpty()) {
            Almacen actual = cola.poll();
            System.out.println(actual);

            for (Almacen vecino : adjList.get(actual)) {
                if (!visitados.contains(vecino)) {
                    visitados.add(vecino);
                    cola.add(vecino);
                }
            }
        }
    }
}

