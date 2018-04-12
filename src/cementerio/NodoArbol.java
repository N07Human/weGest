package cementerio;

import java.util.ArrayList;

import wegest.Pedido;

import java.util.*;

public class NodoArbol {
    private double prioridad;   // Este dato podria ser la prioridad o algo con lo qeu vamos a ordenar.
    private List<Pedido> pedidos;  // Podria ser el nombre o el codigo del cliente.
    private NodoArbol hijoDerecho, hijoIzquierdo;
    public NodoArbol(double prioridad){
        this.prioridad = prioridad;
        this.pedidos = new ArrayList<>();
        this.hijoDerecho=null;
        this.hijoIzquierdo=null;
    }
    
    
    public double getPrioridad(){
        return prioridad;
    }
    
    public void setHijoIzq(NodoArbol izq){
        hijoIzquierdo = izq;
    }
    
    public void setHijoDer(NodoArbol der){
        hijoDerecho = der;
    }
    
    public NodoArbol getHijoIzquierdo(){
        return hijoIzquierdo;
    }
    
    public NodoArbol getHijoDerecho(){
        return hijoDerecho;
    }


	//public Pedido getPedido(String codPedido) {
	//	return pedidos. (codPedido);
	//}


	public void setPedido(Pedido pedido) {
		this.pedidos.add(pedido);
	}
            
}

