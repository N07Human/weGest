package wegest;

import java.sql.Date;

public class Pedido {
	
	private String codPedido;
	private String codCliente;
	private String tipoPedido;
	private String fechaEntrega;
	private String estadoPedido;
	private String maquina;
	private int cantidadPedido;
	private int tiempoProceso;
	private int tiempoDisponible;
	private int pedidoHecho;
	private int pedidoEnCola;
	private double prioridad;
	
	public Pedido(String codPedido,String codCliente, String tipoPedido, int cantidadPedido, String estadoPedido, String maquina, String fechaEntrega) {
		this.codPedido = codPedido;
		this.codCliente = codCliente;
		this.tipoPedido = tipoPedido;
		this.cantidadPedido = cantidadPedido;
		this.estadoPedido = estadoPedido;
		this.fechaEntrega = fechaEntrega;
		this.maquina = maquina;
	}
	
	public String getCodPedido() {
		return codPedido;
	}
	
	public void setCodPedido(String numeroPedido) {
		this.codPedido = numeroPedido;
	}
	
	public String getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(String codigoCliente) {
		this.codCliente = codigoCliente;
	}

	public String getTipoPedido() {
		return tipoPedido;
	}

	public void setTipoPedido(String tipoPedido) {
		this.tipoPedido = tipoPedido;
	}

	public String getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public String getEstadoPedido() {
		return estadoPedido;
	}

	public void setEstadoPedido(String estadoPedido) {
		this.estadoPedido = estadoPedido;
	}

	public int getCantidadPedido() {
		return cantidadPedido;
	}

	public void setCantidadPedido(int cantidadPedido) {
		this.cantidadPedido = cantidadPedido;
	}

	public int getTiempoProceso() {
		return tiempoProceso;
	}

	public void setTiempoProceso(int tiempoProceso) {
		this.tiempoProceso = tiempoProceso;
	}

	public int getTiempoDisponible() {
		return tiempoDisponible;
	}

	public void setTiempoDisponible(int tiempoDisponible) {
		this.tiempoDisponible = tiempoDisponible;
	}

	public int getPedidoHecho() {
		return pedidoHecho;
	}

	public void setPedidoHecho(int pedidoHecho) {
		this.pedidoHecho = pedidoHecho;
	}

	public int getPedidoEnCola() {
		return pedidoEnCola;
	}

	public void setPedidoEnCola(int pedidoEnCola) {
		this.pedidoEnCola = pedidoEnCola;
	}
	
	public double getPrioridad() {
		return prioridad;
	}
	public void setPrioridad() {
		this.prioridad = prioridad;
	}
	
	

}
