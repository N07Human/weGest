package wegest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import javax.swing.JTextField;

public class GeneradorLista {

	//private ArrayList<String[]> datosExcel;
	private Map<String,Pedido> pedidos;
	private ArrayList<Cliente> clientes;
	private ArrayList<String[]> datosExcel;

	public GeneradorLista() {
		this.pedidos = new HashMap<>();
		this.clientes = new ArrayList<>();
		this.datosExcel = ImportExcel.importExcel("datosEmpresa.xlsx", 10);
		
	}
	
	
	//ArrayList<String[]> datosExcel = ImportExcel.importExcel("datosEmpresa.xlsx", 10);
	//String[] data; // EL PRIMER ELEMENTO SON LAS ETIQUETAS

	public void generarListas() {
		ListIterator<String[]> itCreator = datosExcel.listIterator();
		String[] data = itCreator.next();
		while (itCreator.hasNext()) { // CREAR OBJETOS PEDIDO
			data = itCreator.next();
			Pedido pedido = new Pedido(data[0], data[1], data[3], data[4], data[8], data[6], data[7]);
			Cliente cliente = new ClienteEmpresa(data[1], data[2], data[3], null, null);
			pedidos.put(data[0],pedido); // key = codPedido, Objeto = pedido
			clientes.add(cliente);
		}
	}

	public void imprimirListas() {
		ListIterator<String[]> it = datosExcel.listIterator();
		while (it.hasNext()) {
			String[] datos = it.next(); // .next() lee hasta que encuentra espacio, a diferencia de
										// nextLine() que lee hasta un salto de línea
			String personaInfo = "";
			for (String fila : datos) { // for each, tambien conocido como for extendido
				personaInfo += fila + " "; // for ( tipoVariable nombreCualquiera : arregloaLeer)
			}
			System.out.println(personaInfo + "\n");
		}
	}
	
	public void imprimirPedidos() {
		Set<String> keys = pedidos.keySet();
		for(String i:keys) {
			System.out.println(i + " " +pedidos.get(i).getCodCliente());
		}
	}
	
	public String getCodigoCliente(String i) {
		return pedidos.get(i).getCodCliente();
	}
	
	public int getCodPedido(int i){
		return Integer.parseInt(pedidos.get(Integer.toString(i)).getCodPedido());
	}
	public int getCodCliente(int i) {
		return Integer.parseInt(pedidos.get(i).getCodCliente());
	}
	public int getTiempoProceso(int i) {
		return pedidos.get(i).getTiempoProceso();
	}
	public String getFechaEntrega(int i) {
		return pedidos.get(i).getFechaEntrega();
	}
	
	public int getTotalPedidos(){
		return pedidos.size();
	}
}

