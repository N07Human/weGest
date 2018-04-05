package wegest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ListIterator;

import javax.swing.JTextField;

public class GeneradorLista {

	//private ArrayList<String[]> datosExcel;
	private ArrayList<Pedido> pedidos;
	private ArrayList<Cliente> clientes;

	public GeneradorLista() {
		this.pedidos = new ArrayList<>();
		this.clientes = new ArrayList<>();
		
	}
	ArrayList<String[]> datosExcel = ImportExcel.importExcel("datosEmpresa.xlsx", 10);
	ListIterator<String[]> itCreador = datosExcel.listIterator();
	String[] data = itCreador.next(); // EL PRIMER ELEMENTO SON LAS ETIQUETAS

	public void generarListas() {
		JTextField textField = new JTextField();
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yy");

		while (itCreador.hasNext()) { // CREAR OBJETOS PEDIDO
			data = itCreador.next();
			Pedido pedido = new Pedido(data[0], data[1], data[3], Integer.parseInt(data[4]), data[8], data[6], data[7]);
			Cliente cliente = new ClienteEmpresa(data[1], data[2], data[3], null, null);
			pedidos.add(pedido);
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
	public int getCodPedido(int i){
		return Integer.parseInt(pedidos.get(i).getCodPedido());
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

