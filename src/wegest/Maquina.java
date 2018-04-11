package wegest;

public class Maquina {
	
	private String codMaquina;
	private ABB arbol;
	private double tiempoHistorico;
	
	public Maquina(String codMaquina, double tiempoHistorico) {
		this.codMaquina = codMaquina;
		this.tiempoHistorico = tiempoHistorico;
		this.arbol = new ABB();
	}
	
	public void agregarPedido(double prioridad,Pedido pedido) {
		arbol.agregarPedido(prioridad, pedido);
	}
	
	public String getCodMaquina() {
		return codMaquina;
	}
	
	public double getTempoHistorico() {
		return tiempoHistorico;
	}

}
