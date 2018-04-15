package wegestORIGINAL;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import cementerio.ClienteEmpresa;

public class Listas{

	// private ArrayList<String[]> datosExcel;
	private Map<String, Pedido> pedidos;
	private Map<String, Cliente> clientes;
	private List<Maquina> maquinas;
	private List<Maquina> maquinasSecuenciadas;
	private ImportExcel datosEntrada;
	// private ExportExcel datosSalida;

	public Listas() {
		this.pedidos = new LinkedHashMap<>();
		this.clientes = new LinkedHashMap<>();
		this.maquinas = new ArrayList<>();
		this.maquinasSecuenciadas = new LinkedList<>();
		this.datosEntrada = new ImportExcel("Datos_Pedidos_Test.xlsx", 10);
	}

	public void importar() {
		ListIterator<String[]> itCreator = datosEntrada.getDatosImportados().listIterator();
		String[] data = itCreator.next();
		while (itCreator.hasNext()) { // CREAR OBJETOS PEDIDO
			data = itCreator.next();
			Pedido pedido = new Pedido(data[0], data[1], data[3], data[4], data[8], data[7], data[6], data[9]);
			Cliente cliente = new ClienteEmpresa(data[1], data[2], data[3], null, null);
			pedidos.put(data[0], pedido); // key = codPedido, Objeto = pedido
			clientes.put(data[1], cliente);
			// System.out.println("Pedido Ingresado: "+pedidos.get(data[0]).getCodPedido());
		}
	}

	public void ordenarPorMaquina() throws ParseException {
		System.out.println("Entra a ordenar (Secuenciar)");
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		setMaquinas();
		Set<String> keys = pedidos.keySet();
		for (String i : keys) { // CREAR OBJETOS PEDIDO
			Pedido pedido = pedidos.get(i);
			String maquina = pedido.getCodMaquina();
			long prioridad = df.parse(pedido.getFechaEntrega()).getTime();
			switch (maquina) {
			case "M1":
				maquinas.get(0).agregarPedido(Long.toString(prioridad), pedido);
				System.out.println(pedidos.get(i).getCodCliente());
				break;
			// System.out.println("Se cargo en M1 (secuenciar)"); // <.-----ELIMINAR
			case "M2":
				System.out.println("HOLI ADENTRO DE ORDENAR 2!");
				maquinas.get(1).agregarPedido(Long.toString(prioridad), pedido);
				break;
			case "M3":
				maquinas.get(2).agregarPedido(Long.toString(prioridad), pedido);
				break;
			}
		}
		System.out.println("Sale de secuenciar (Secuenciar)");
	}

	public void setVelocidadHistorica(String fechaInicio) {
		for (int i = 0; i < maquinas.size(); i++) {
			try {
				Maquina aux = maquinas.get(i);
				aux.setVelocidadHistorica(fechaInicio);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}

	public void secuenciar(String horaInicio) throws ParseException {
		for (int i = 0; i < maquinas.size(); i++) {
			maquinas.get(i).secuenciar(horaInicio);
		}
	}


	private void setMaquinas() { // COnsulta cuantas máquinas crear
		for (int i = 0; i < 3; i++) {
			String codMaquina = "M" + Integer.toString(i);
			Maquina maquina = new Maquina(codMaquina);
			maquinas.add(maquina);
			maquinasSecuenciadas.add(maquina);
		}
	}


	public void imprimirImport() {
		ListIterator<String[]> it = datosEntrada.getDatosImportados().listIterator();
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

	public void imprimirSecuenciacionMaquinas() {
		for (int i = 0; i < maquinas.size(); i++) {
			System.out.println("Maquina: " + (i + 1));
			maquinas.get(i).imprimirLista();

		}
	}

	public void imprimirPedidos() {
		Set<String> keys = pedidos.keySet();
		for (String i : keys) {
			System.out.println(i + " " + pedidos.get(i).getCodCliente());
		}
	}

	public void printVelocidad() {
		setVelocidadHistorica("01-01-2015");
		System.out.println(maquinas.get(0).getVelocidadHistorico());
		System.out.println(maquinas.get(1).getVelocidadHistorico());
		System.out.println(maquinas.get(2).getVelocidadHistorico());
	}

	public void agregarNuevoPedido(Pedido pedido) {
		System.out.println("Solicita agregar pedido");
		pedidos.put(pedido.getCodPedido(), pedido);
	}

	public void exportar() {
		for (Maquina maquina : maquinas) {
			maquina.exportar();
		}

	}

}
