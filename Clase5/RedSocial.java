package Clase5;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RedSocial {
	private List<List<Integer>> grafo; // Lista de adyacencia
    private int numUsuarios;
    
    // Constructor
    public RedSocial(int numUsuarios) {
        this.numUsuarios = numUsuarios;
        grafo = new ArrayList<>();
        
        // Inicializar la lista de adyacencia
        for (int i = 0; i < numUsuarios; i++) {
            grafo.add(new ArrayList<>());
        }
    }
    
    public void seguir(int seguidor, int seguido) {
        if (seguidor < numUsuarios && seguido < numUsuarios) {
            grafo.get(seguidor).add(seguido);
            System.out.println("El usuario " + seguidor + " ahora sigue al usuario " + seguido);
        } else {
            System.out.println("Uno o ambos usuarios no existen.");
        }
    }
    
    public void dejarDeSeguir(int usuario, int remover) {
        if (usuario < numUsuarios && remover < numUsuarios) {
            grafo.get(usuario).remove(remover);
            System.out.println("El usuario " + usuario + " ya no sigue a " + remover);
        } else {
            System.out.println("Uno o ambos usuarios no existen.");
        }
    }
    
    public void mostrarSeguidos(int usuario) {
        if (usuario < numUsuarios) {
            System.out.print("El usuario " + usuario + " sigue a: ");
            for (Integer seguido : grafo.get(usuario)) {
                System.out.print(seguido + " ");
            }
            System.out.println();
        } else {
            System.out.println("El usuario no existe.");
        }
    }
	        

}

