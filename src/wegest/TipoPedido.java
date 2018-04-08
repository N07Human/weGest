package wegest;

public class TipoPedido {
	
	private String tipoPedido;
	private String descripcionPedido;
	private String maquinaProcesa;
	private double tiempoProceso;
	
	public TipoPedido(String tipoPedido, String maquinaProcesa, double tiempoProceso) {
		this.tipoPedido = tipoPedido;
		this.maquinaProcesa = maquinaProcesa;
		this.tiempoProceso = tiempoProceso;
	}

	public String getTipoPedido() {
		return tipoPedido;
	}

	public void setTipoPedido(String tipoPedido) {
		this.tipoPedido = tipoPedido;
	}

	public String getDescripcionPedido() {
		return descripcionPedido;
	}

	public void setDescripcionPedido(String descripcionPedido) {
		this.descripcionPedido = descripcionPedido;
	}

	public String getMaquinaProcesa() {
		return maquinaProcesa;
	}

	public void setMaquinaProcesa(String maquinaProcesa) {
		this.maquinaProcesa = maquinaProcesa;
	}

	public double getTiempoProceso() {
		return tiempoProceso;
	}

	public void setTiempoProceso(double tiempoProceso) {
		this.tiempoProceso = tiempoProceso;
	}
	
	

}
