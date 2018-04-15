package wegest;

import java.util.ArrayList;

import auxiliar.Pedido;

public class Cliente {
	
	private String codigoCliente;
	private String razonSocial;
	private String direccion;
	private String telefono;
	private ArrayList<Pedido> pedidos;
	
	public Cliente(String codigoCliente, String razonSocial, String direccion, String telefono) {
		this.codigoCliente = codigoCliente;
		this.razonSocial = razonSocial;
		this.direccion = direccion;
		this.telefono = telefono;
		this.pedidos = new ArrayList<>();
	}


}
