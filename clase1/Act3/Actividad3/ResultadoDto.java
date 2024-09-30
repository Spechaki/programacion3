package Actividad3;

public class ResultadoDto {
	private int idCliente;
	private double totalFacturas;
	
	public ResultadoDto(int idCliente, double totalFacturas) {
		super();
		this.idCliente = idCliente;
		this.totalFacturas = totalFacturas;
	}

	@Override
	public String toString() {
		return "ResultadoDto [idCliente=" + idCliente + ", totalFacturas=" + totalFacturas + "]";
	}
	
	
	
}
