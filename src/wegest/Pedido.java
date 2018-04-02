package wegest;

public class Pedido {
	
	private String numeroPedido;
	private String codigoCliente;
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
	
	public Pedido(String numeroPedido,String codigoCliente, String tipoPedido, int cantidadPedido, String estadoPedido, String fechaEntrega, String maquina) {
		this.numeroPedido = numeroPedido;
		this.codigoCliente = codigoCliente;
		this.tipoPedido = tipoPedido;
		this.cantidadPedido = cantidadPedido;
		this.estadoPedido = estadoPedido;
		this.fechaEntrega = fechaEntrega;
		this.maquina = maquina;
	}
	
	public String getNumeroPedido() {
		return numeroPedido;
	}
	
	public void setNumeroPedido(String numeroPedido) {
		this.numeroPedido = numeroPedido;
	}
	
	public String getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
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
