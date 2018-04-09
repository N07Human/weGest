package wegest;

public class NodoArbol {
    private double prioridad;   // Este dato podria ser la prioridad o algo con lo qeu vamos a ordenar.
    private Pedido pedido;  // Podria ser el nombre o el codigo del cliente.
    private NodoArbol hijoDerecho, hijoIzquierdo;
    public NodoArbol(double prioridad, Pedido pedido){
        this.prioridad = prioridad;
        this.setPedido(pedido);
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


	public Pedido getPedido() {
		return pedido;
	}


	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
            
}

