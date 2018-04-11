package wegest;

import java.text.ParseException;
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
	private Map<Long,Pedido> pedidos;
	private ArrayList<Cliente> clientes;
	private ArrayList<String[]> datosExcel;
	private ArrayList<Maquina> maquinas;

	public GeneradorLista() {
		this.pedidos = new HashMap<>();
		this.clientes = new ArrayList<>();
		this.maquinas= new ArrayList<>(3);
		this.datosExcel = ImportExcel.importExcel("Datos_Pedidos.xlsx", 10);
		
	}
	
	
	//ArrayList<String[]> datosExcel = ImportExcel.importExcel("datosEmpresa.xlsx", 10);
	//String[] data; // EL PRIMER ELEMENTO SON LAS ETIQUETAS

	public void generarListas() {
		ListIterator<String[]> itCreator = datosExcel.listIterator();
		String[] data = itCreator.next();
		long prioridad;
		Maquina m1 = new Maquina("M1",1.1);
		Maquina m2 = new Maquina("M2",1.5);
		Maquina m3 = new Maquina("M3",1.3);
		maquinas.add(m1);
		maquinas.add(m2);
		maquinas.add(m3);
		while (itCreator.hasNext()) { // CREAR OBJETOS PEDIDO
			data = itCreator.next();
			Pedido pedido = new Pedido(data[0], data[1], data[3], data[4], data[8], data[7], data[6]);
			String maquina = pedido.getMaquina();
			String estadoPedido = pedido.getEstadoPedido();
			
			switch (maquina){
				case "M1":
					
					if(comprobarEstadoNPRPRG(estadoPedido)) {
						prioridad = calcularPrioridad(data[6]);
						maquinas.get(0).agregarPedido(prioridad, pedido);
					}
				case "M2":
					if(comprobarEstadoNPRPRG(estadoPedido)) {
						prioridad = calcularPrioridad(data[6]);
						maquinas.get(1).agregarPedido(prioridad, pedido);
					}
				case "M3":
					if(comprobarEstadoNPRPRG(estadoPedido)) {
						prioridad = calcularPrioridad(data[6]);
						maquinas.get(2).agregarPedido(prioridad, pedido);
					}				
			}
			/*if(pedido.getEstadoPedido().equals("NPR")) {
				System.out.println("Imprmimir data: "+data[0]+" "+data[1]+" "+data[3]+" "+data[4]+" "+data[8]+" "+data[7]+" "+data[6]);
				System.out.println("Pedido :"+pedido.getEstadoPedido());
				System.out.println("Cliente :"+pedido.getCodCliente());
				System.out.println("CodPedido :"+pedido.getCodPedido());
				System.out.println("FechaEntrega :"+pedido.getFechaEntrega());
				System.out.println("TipoPedido :"+pedido.getTipoPedido());
				
				prioridad = calcularPrioridad(data[6]);
			}else {
				prioridad = -1;
			}
			
			Cliente cliente = new ClienteEmpresa(data[1], data[2], data[3], null, null);
			pedidos.put(prioridad,pedido); // key = codPedido, Objeto = pedido
			clientes.add(cliente);*/
		}
	}
	
	private boolean comprobarEstadoNPRPRG(String estadoPedido) {
		if(estadoPedido.equals("NPR")||estadoPedido.equals("PRG"))
			return true;
		return false;
	}


	private long calcularPrioridad(String fecha) {
			Date current = new Date();
			SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		    try {

		        Date fentrega = df.parse(fecha);
		        Date hoy = df.parse(df.format(current));
		        
		        long fechaEntrega = fentrega.getTime();
		        long fechaHoy = hoy.getTime();
		        
		        System.out.println("Entrega "+fentrega);
		        System.out.println("Hoy: "+hoy);
		        		        
		        long diferencia = (fechaEntrega - fechaHoy);
		        long diferenciaDias = diferencia/(1000*60*60*24);
		        System.out.println("Diferencia: "+diferencia+" cuociente: "+diferenciaDias);
		        return diferenciaDias;
		        //System.out.println(date);
		        //return System.out.println(formatter.format(date));

		    } catch (ParseException e) {
		        e.printStackTrace();
		    }
		return 0;
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
		Set<Long> keys = pedidos.keySet();
		for(Long i:keys) {
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

