package wegest;

public class Secuenciador {
	
	private double prioridad;
	private int codCliente;
	private GeneradorLista lista;
	private Arbol secuenciador;
	
	/*DEBERIA SECUENCIAR LOS PEDIDOS POR PRIORIDAD DESDE EL ARBOL De CADA MAQUINA
	DEBE ENTREGAR UN DOCUMENTO CON LA LISTA DE PEDIDOS A REALIZAR
	CON CODIGO PEDIDO, CANTIDAD, TIEMPO APP, ESTADO*/
	
	public Secuenciador() {
		this.secuenciador = new Arbol();
		this.lista = new GeneradorLista();
	}
	
	/*public void generarArbol() {
		int i=0;
		int totalPedidos = lista.getTotalPedidos();
		while(i<totalPedidos) {
			for(i=0;i<totalPedidos;i++) {
				NodoArbol nuevo = new NodoArbol(lista.getCodPedido(i),);
			}
		}
	}*/
	
	
	
	
	

}
