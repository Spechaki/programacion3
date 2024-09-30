package Clase5;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RedSocialEj1 {
	 private Map<String, List<String>> grafo;
    
    // Constructor
	    public RedSocialEj1() {
	        grafo = new HashMap<>();
	    }
	    
	    public void agregarUsuario(String usuario) {
	        if (!grafo.containsKey(usuario)) {
	            grafo.put(usuario, new ArrayList<>());
	            System.out.println("Usuario " + usuario + " ha sido agregado.");
	        } else {
	            System.out.println("El usuario " + usuario + " ya existe.");
	        }
	    }
    
	    public void seguir(String seguidor, String seguido) {
	        if (grafo.containsKey(seguidor) && grafo.containsKey(seguido)) {
	            grafo.get(seguidor).add(seguido);
	            System.out.println("El usuario " + seguidor + " ahora sigue al usuario " + seguido);
	        } else {
	            System.out.println("Uno o ambos usuarios no existen.");
	        }
	    }
    
	    public void dejarDeSeguir(String usuario, String remover) {
	        if (grafo.containsKey(usuario) && grafo.containsKey(remover)) {
	            grafo.get(usuario).remove(remover);
	            System.out.println("El usuario " + usuario + " ya no sigue a " + remover);
	        } else {
	            System.out.println("Uno o ambos usuarios no existen.");
	        }
	    }
    
	    public void mostrarSeguidos(String usuario) {
	        if (grafo.containsKey(usuario)) {
	            System.out.print("El usuario " + usuario + " sigue a: ");
	            for (String seguido : grafo.get(usuario)) {
	                System.out.print(seguido + " ");
	            }
	            System.out.println();
	        } else {
	            System.out.println("El usuario no existe.");
	        }
	    } 
}



