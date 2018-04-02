package wegest;

public class NodoPedido {
	
	private Pedido pedido;
	private NodoPedido next;
	
	public NodoPedido(Pedido pedido, NodoPedido next) {
		this.pedido = pedido;
		this.next = next;
	}
	
	public Pedido getPedido() {
		return pedido;
	}
	
	public void setNext(NodoPedido next) {
		this.next = next;
	}

}
