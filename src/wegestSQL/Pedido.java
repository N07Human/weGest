package wegestSQL;

public class Pedido {
	
	private String codPedido;
	private String codCliente;
	private String tipoPedido;
	private String fechaEntrega;
	private String estadoPedido;
	private String codMaquina;
	private String cantidadPedido;
	private String tiempoProceso;
	private double prioridad;
	
	public Pedido(String codPedido,String codCliente, String tipoPedido, String cantidadPedido, String estadoPedido, String codMaquina, String fechaEntrega, String tiempoProceso) {
		this.codPedido = codPedido;
		this.codCliente = codCliente;
		this.tipoPedido = tipoPedido;
		this.cantidadPedido = cantidadPedido;
		this.estadoPedido = estadoPedido;
		this.fechaEntrega = fechaEntrega;
		this.codMaquina = codMaquina;
		this.tiempoProceso = tiempoProceso;
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

	public String getCantidadPedido() {
		return cantidadPedido;
	}

	public void setCantidadPedido(String cantidadPedido) {
		this.cantidadPedido = cantidadPedido;
	}

	public String getTiempoProceso() {
		return tiempoProceso;
	}

	public void setTiempoProceso(String tiempoProceso) {
		this.tiempoProceso = tiempoProceso;
	}
	
	public double getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(double prioridad) {
		this.prioridad = prioridad;
	}

	public String getCodMaquina() {
		return codMaquina;
	}
	
	

}
