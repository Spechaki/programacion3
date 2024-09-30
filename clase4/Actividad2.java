package Clase4;

import java.util.ArrayList;
import java.util.Arrays;

public class Actividad2 {

	    public static ArrayList<Integer> minimoComprobantes(int[] comprobantes, int montoCompra) {
	        Arrays.sort(comprobantes);
	        
	        ArrayList<Integer> comprobantesUsados = new ArrayList<Integer>();
	        
	        for (int i = comprobantes.length - 1; i >= 0; i--) {
	            while (montoCompra >= comprobantes[i]) {
	                montoCompra -= comprobantes[i];
	                comprobantesUsados.add(comprobantes[i]); 
	            }
	        }
	       
	        return comprobantesUsados;
	    }

	    public static void main(String[] args) {
	        int[] comprobantes = {5, 10, 50, 100, 200, 200};  
	        int montoCompra = 501;
	        
	        ArrayList<Integer> resultado = minimoComprobantes(comprobantes, montoCompra);
	        
	      
	            System.out.println("El número mínimo de comprobantes necesarios es: " + resultado);
	     
	        }
	}
     
