package wegest;

public class Arbol {
	
	private NodoArbol raiz;
	
	public Arbol() {
		this.raiz = null;
	}
	
	public void agregarHoja(double prioridad, Pedido pedido) {
		NodoArbol nuevo = new NodoArbol(prioridad,pedido);
		if(raiz == null) {
			raiz = nuevo;	
		}else {
			NodoArbol aux = raiz;
			NodoArbol padre;
			while(true) {
				padre = aux;
				double dato = aux.getPrioridad();
				if(prioridad<dato) {
					aux = aux.getHijoIzquierdo();
					if(aux==null) {
						padre.setHijoIzq(nuevo);
						return;
					}
				}else {
					aux = aux.getHijoDerecho();
					if(aux == null) {
						padre.setHijoDer(nuevo);
						return;
					}
				}
				
			}
		}
	}
	

}
