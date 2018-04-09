package wegest;

import javax.swing.JOptionPane;

public class ArbolProrizado {
	
	private NodoArbol raiz;
	
	public ArbolProrizado() {
		this.raiz = null;
	}
	
	public void agregarHoja(double prioridad, int codCliente) {
		NodoArbol nuevo = new NodoArbol(prioridad,codCliente);
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
