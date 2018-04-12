package cementerio;

public class Contrato {
	
	private String tipoContrato;
	private String descuento;
	private double prioridad;
	
	public Contrato(String tipoContrato, String descuento, double prioridad) {
		this.tipoContrato = tipoContrato;
		this.descuento = descuento;
		this.prioridad = prioridad;
	}

	public String getTipoContrato() {
		return tipoContrato;
	}

	public void setTipoContrato(String tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	public String getDescuento() {
		return descuento;
	}

	public void setDescuento(String descuento) {
		this.descuento = descuento;
	}

	public double getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(double prioridad) {
		this.prioridad = prioridad;
	}
	

}
