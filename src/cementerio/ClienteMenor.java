package cementerio;

import wegestORIGINAL.Cliente2;

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
