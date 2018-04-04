package wegest;

public class NodoArbol {
    private double prioridad;   // Este dato podria ser la prioridad o algo con lo qeu vamos a ordenar.
    private int codCliente;  // Podria ser el nombre o el codigo del cliente.
    private NodoArbol hijoDerecho, hijoIzquierdo;
    public NodoArbol(double prioridad, int codCliente){
        this.prioridad = prioridad;
        this.setCodCliente(codCliente);
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


	public int getCodCliente() {
		return codCliente;
	}


	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}
            
}

