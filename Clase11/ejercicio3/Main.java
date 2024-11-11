package ejercicio3;

public class Main {
    public static void main(String[] args) {
        Grafo redAlmacenes = new Grafo();

        Almacen a1 = new Almacen(1, "Almacen A");
        Almacen a2 = new Almacen(2, "Almacen B");
        Almacen a3 = new Almacen(3, "Almacen C");
        Almacen a4 = new Almacen(4, "Almacen D");

        redAlmacenes.agregarAlmacen(a1);
        redAlmacenes.agregarAlmacen(a2);
        redAlmacenes.agregarAlmacen(a3);
        redAlmacenes.agregarAlmacen(a4);

        redAlmacenes.conectarAlmacenes(a1, a2);
        redAlmacenes.conectarAlmacenes(a2, a3);
        redAlmacenes.conectarAlmacenes(a3, a4);
        redAlmacenes.conectarAlmacenes(a4, a1);

        System.out.println("Recorrido DFS desde Almacen A:");
        redAlmacenes.dfs(a1);

        System.out.println("\nRecorrido BFS desde Almacen A:");
        redAlmacenes.bfs(a1);
    }
}
