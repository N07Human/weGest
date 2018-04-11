package wegest;

public class ABB {
	
	private NodoArbol raiz;
	
	public ABB() {
		this.raiz = null;
	}
	
	public void agregarPedido(double prioridad, Pedido pedido) {
		if(existeHoja(prioridad)) {
			buscarHoja(prioridad).setPedido(pedido);
		}else {
			NodoArbol nuevo = new NodoArbol(prioridad);
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
							nuevo.setPedido(pedido);
							padre.setHijoIzq(nuevo);
							return;
						}
					}else{
						aux = aux.getHijoDerecho();
						if(aux == null) {
							nuevo.setPedido(pedido);
							padre.setHijoDer(nuevo);
							return;
						}
					
					}
					
				}
			}
			
		}
		
		
	}
	
	private boolean existeHoja(double prioridad) {
		NodoArbol aux = raiz;
		if(aux==null) {
			return false;
		}else {
			while(aux!=null) {
				double dato = aux.getPrioridad();
				if(prioridad==dato) {
					return true;
				}else if (prioridad<dato) {
					aux = aux.getHijoIzquierdo();
				}else {
					aux=aux.getHijoDerecho();
				}
			
			}
		}
		return false;
	}
	
	private NodoArbol buscarHoja(double prioridad) {
		NodoArbol aux = raiz;
		while(aux!=null) {
			double dato = aux.getPrioridad();
			if(prioridad==dato) {
				return aux;
			}else if (prioridad<dato) {
				aux = aux.getHijoIzquierdo();
			}else {
				aux=aux.getHijoDerecho();
			}
			
		}
		return null;
	}
	

}
