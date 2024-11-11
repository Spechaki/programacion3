package ejercicio4;

import java.util.*;

public class Grafo {
    private final Map<Usuario, List<Usuario>> adjList;

    public Grafo() {
        this.adjList = new HashMap<>();
    }

    // Agrega un nuevo usuario al grafo
    public void agregarUsuario(Usuario usuario) {
        adjList.putIfAbsent(usuario, new ArrayList<>());
    }

    // Crea una conexión (ruta) directa entre dos uusarios
    public void conectarUsuarios(Usuario origen, Usuario destino) {
        adjList.get(origen).add(destino);
        adjList.get(destino).add(origen); // Para grafo no dirigido
    }

    // Recorrido en profundidad (DFS) desde un usuario de inicio
    public void dfs(Usuario inicio) {
        Set<Usuario> visitados = new HashSet<>();
        dfsRecursivo(inicio, visitados);
    }

    private void dfsRecursivo(Usuario actual, Set<Usuario> visitados) {
        visitados.add(actual);
        System.out.println(actual);

        for (Usuario vecino : adjList.get(actual)) {
            if (!visitados.contains(vecino)) {
                dfsRecursivo(vecino, visitados);
            }
        }
    }

    // Recorrido en anchura (BFS) desde un usuario de inicio
    public void bfs(Usuario inicio) {
        Set<Usuario> visitados = new HashSet<>();
        Queue<Usuario> cola = new LinkedList<>();

        visitados.add(inicio);
        cola.add(inicio);

        while (!cola.isEmpty()) {
            Usuario actual = cola.poll();
            System.out.println(actual);

            for (Usuario vecino : adjList.get(actual)) {
                if (!visitados.contains(vecino)) {
                    visitados.add(vecino);
                    cola.add(vecino);
                }
            }
        }
    }
}

