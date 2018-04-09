package wegest;

public class Maquina {
	
	private String codMaquina;
	private Arbol arbol;
	private double tiempoHistorico;
	
	public Maquina(String codMaquina, double tiempoHistorico, Arbol arbol) {
		this.codMaquina = codMaquina;
		this.tiempoHistorico = tiempoHistorico;
		this.arbol = arbol;
	}
	
	public void agregarNodoArbol(double prioridad,Pedido pedido) {
		arbol.agregarHoja(prioridad, pedido);
	}
	
	public String getCodMaquina() {
		return codMaquina;
	}
	
	public double getTempoHistorico() {
		return tiempoHistorico;
	}

}
