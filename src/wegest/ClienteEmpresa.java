package wegest;

public class ClienteEmpresa extends Cliente {
	
	private Contrato tipoContrato;
	
	public ClienteEmpresa(String codigoCliente, String razonSocial, String direccion, String telefono, Contrato tipoContrato) {
		super(codigoCliente, razonSocial, direccion, telefono);
		this.tipoContrato = tipoContrato;
	}

	public Contrato getTipoContrato() {
		return tipoContrato;
	}

	public void setTipoContrato(Contrato tipoContrato) {
		this.tipoContrato = tipoContrato;
	}
	
	public double getPrioridad() {
		return tipoContrato.getPrioridad();
	}
	

}
