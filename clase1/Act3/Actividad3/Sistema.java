package Actividad3;

import java.util.ArrayList;

public class Sistema {
	private ArrayList<Cliente> clientes;
	
	private ArrayList<Factura> facturas;
	
	
	public ArrayList<ResultadoDto> getResultados() {
		
		ArrayList<ResultadoDto> rta = new ArrayList<ResultadoDto>(); //1
	
		for (Cliente c: this.clientes) { //n
			double acu = 0.0; //1 * n
			
			for(Factura f: this.facturas) { //n
				if(c.getIDCliente() == f.getIDCliente()) { //1 n
					acu = acu + f.getImporte(); //2 * n
				}
			}
			rta.add(new ResultadoDto(c.getIDCliente(), acu)); // 1*n
		}
		return rta; //1
	}

	
	
	//f(n) = 1 + n( 1 + n(1 + 2)  + 1)
	//f(n) = 1 + n (n + n + 1*n + 2*n) + 1*n

	public Sistema(ArrayList<Cliente> clientes, ArrayList<Factura> facturas) {
		super();
		this.clientes = clientes;
		this.facturas = facturas;
	}
	
	

}
