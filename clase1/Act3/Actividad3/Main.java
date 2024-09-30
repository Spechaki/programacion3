package Actividad3;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Cliente cliente1 = new Cliente(1, "Jorge");
		Cliente cliente2 = new Cliente(2, "Pedro");
		
		Factura factura1 = new Factura(1, 1, 1000);
		Factura factura2 = new Factura(2, 1, 1000);

		HashMap<Integer, Cliente> clientesHash = new HashMap<Integer, Cliente>();
		
		ArrayList<Cliente> clientes = new ArrayList<>();
		ArrayList<Factura> facturas = new ArrayList<>();
		
		clientes.add(cliente1);
		clientes.add(cliente2);
		
		facturas.add(factura1);
		facturas.add(factura2);
		
		Sistema sistema = new Sistema(clientes, facturas);
		
		for (ResultadoDto resultado: sistema.getResultados()) {
			System.out.println(resultado);
		}

	}

}
