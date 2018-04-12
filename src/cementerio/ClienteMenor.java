package cementerio;

import wegest.Cliente;

public class ClienteMenor extends Cliente {
	
	private double prioridad;
	
	public ClienteMenor(String codigoCliente, String razonSocial, String direccion, String telefono) {
		super(codigoCliente, razonSocial, direccion, telefono);
	}
	
	public double getPrioridad() { 
		return prioridad;
	}
	
	public void setPrioridad(double prioridad) {
		this.prioridad = prioridad;
	}

}
