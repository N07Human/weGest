package wegest;

public class Secuenciador {
	
	private double prioridad;
	private int codCliente;
	private GeneradorLista lista;
	private ArbolProrizado secuenciador;
	
	public Secuenciador() {
		this.secuenciador = new ArbolProrizado();
		this.lista = new GeneradorLista();
	}
	
	public void generarArbol() {
		int i=0;
		int totalPedidos = lista.getTotalPedidos();
		while(i<totalPedidos) {
			for(i=0;i<totalPedidos;i++) {
				NodoArbol nuevo = new NodoArbol(lista.getCodPedido(i),lista.getCodCliente(i));
			}
		}
	}
	
	
	
	
	

}
