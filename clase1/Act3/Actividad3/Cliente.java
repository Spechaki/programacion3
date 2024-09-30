package Actividad3;

public class Cliente {
	private int IDCliente;
	private String nombre;
	
	public Cliente(int IDCliente, String nombre) {
		
		this.IDCliente = IDCliente;
		this.nombre = nombre;
		
	}

	public int getIDCliente() {
		return IDCliente;
	}

	public String getNombre() {
		return nombre;
	}

}
