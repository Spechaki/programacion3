package ejercicio4;

public class Main {
    public static void main(String[] args) {
        Grafo redUsuarios = new Grafo();

        Usuario a1 = new Usuario(1, "Jorge");
        Usuario a2 = new Usuario(2, "Pedro");
        Usuario a3 = new Usuario(3, "Maria");
        Usuario a4 = new Usuario(4, "Fernando");

        redUsuarios.agregarUsuario(a1);
        redUsuarios.agregarUsuario(a2);
        redUsuarios.agregarUsuario(a3);
        redUsuarios.agregarUsuario(a4);

        redUsuarios.conectarUsuarios(a1, a2);
        redUsuarios.conectarUsuarios(a2, a3);
        redUsuarios.conectarUsuarios(a3, a4);

        System.out.println("Recorrido DFS desde Jorge:");
        redUsuarios.dfs(a1);

        System.out.println("\nRecorrido BFS desde Jorge:");
        redUsuarios.bfs(a1);
    }
}
