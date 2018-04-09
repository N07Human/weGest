package wegest;

public class Maquina {
	
	private String codMaquina;
	private ArbolProrizado arbol;
	private double tiempoHistorico;
	
	public Maquina(String codMaquina, double tiempoHistorico, ArbolProrizado arbol) {
		this.codMaquina = codMaquina;
		this.tiempoHistorico = tiempoHistorico;
		this.arbol = arbol;
	}

}
