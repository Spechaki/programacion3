package Actividad3;

public class Factura {
	private int IDFactura;
	private int IDCliente;
	private double importe;
	
	public Factura(int iDFactura, int iDCliente, double importe) {
		super();
		IDFactura = iDFactura;
		IDCliente = iDCliente;
		this.importe = importe;
	}

	public int getIDFactura() {
		return IDFactura;
	}

	public void setIDFactura(int iDFactura) {
		IDFactura = iDFactura;
	}

	public int getIDCliente() {
		return IDCliente;
	}

	public void setIDCliente(int iDCliente) {
		IDCliente = iDCliente;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	
	
	
}
