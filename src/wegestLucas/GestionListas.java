/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wegestLucas;

import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.Date;

import cementerio.ClienteEmpresa;

public class GestionListas {

	// private ArrayList<String[]> datosExcel;
	private Map<String, Pedido> pedidos;
	private Map<String, Cliente> clientes;
	private List<Maquina> maquinas;
	private ImportExcel datosEntrada;
	// private ExportExcel datosSalida;
	// private Secuenciador secuenciador;

	public GestionListas() {
		this.pedidos = new HashMap<>();
		this.clientes = new HashMap<>();
		this.maquinas = new ArrayList<>();
		this.datosEntrada = new ImportExcel("Datos_Pedidos_Test.xlsx", 10);
	}

	// FALTAAAAAAAAAAAAAAAAAAA
	/*
	 * Al cambiar estado de algun pedido debe eliminarlo de la lista y retornarlo
	 * para guardarlo en un registro historico de pedidos terminados.
	 */
	// ArrayList<String[]> datosExcel = ImportExcel.importExcel("datosEmpresa.xlsx",
	// 10);
	// String[] data; // EL PRIMER ELEMENTO SON LAS ETIQUETAS
	public void generarListas() {
		ListIterator<String[]> itCreator = datosEntrada.getDatosImportados().listIterator();
		String[] data = itCreator.next();
		while (itCreator.hasNext()) { // CREAR OBJETOS PEDIDO
			data = itCreator.next();
			Date nuevo = new Date(100, 1, 1); // AGREGUE ESTO JP
			Pedido pedido = new Pedido(data[0], data[1], data[3], data[4], data[8], data[7], data[6], nuevo);
			Cliente cliente = new ClienteEmpresa(data[1], data[2], data[3], null, null);
			pedidos.put(data[0], pedido); // key = codPedido, Objeto = pedido
			clientes.put(data[1], cliente);
			// System.out.println("Pedido Ingresado: "+pedidos.get(data[0]).getCodPedido());
		}
	}

	public void setMaquinas(int numMaquinas) { // COnsulta cuantas máquinas crear
		for (int i = 0; i < numMaquinas; i++) {
			String codMaquina = "M" + Integer.toString(i);
			Maquina maquina = new Maquina(codMaquina, 1);
			maquinas.add(maquina);
		}
	}

	public ArrayList<Pedido> getPedidos() {
		ArrayList<Pedido> listaPedidos = new ArrayList<>();
		Set<String> keys = pedidos.keySet();
		for (String i : keys) {
			listaPedidos.add(pedidos.get(i));
		}
		return listaPedidos;
	}

	public void agregarPedido(String codMaquina, long prioridad, Pedido pedido) {
		Maquina maquina = getMaquina(codMaquina);
		maquina.agregarPedido(prioridad, pedido);
		// System.out.println("Agregar pedido");

	}

	private Maquina getMaquina(String codMaquina) {
		if (codMaquina.equals("M1")) {
			return maquinas.get(0);
		} else if (codMaquina.equals("M2")) {
			return maquinas.get(1);
		} else {
			return maquinas.get(2);
		}
	}

	/*
	 * private Maquina getMaquina(String codMaquina) { switch(codMaquina) {
	 * case"M1":{ System.out.println("Entra case M1"); return maquinas.get(0); }
	 * case "M2":{ System.out.println("Entra case M2"); return maquinas.get(1); }
	 * case "M3":{ System.out.println("Entra case M2"); return maquinas.get(2); }
	 * 
	 * } return null; }
	 */
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

	public void exportarExcel() {
		for (int i = 0; i < maquinas.size(); i++) {
			System.out.println("Maquina: " + (i + 1));
			maquinas.get(i).exportarExcel();
		}
	}

	public void agregarNuevoPedido(Pedido pedido) {
		System.out.println("Solicita agregar pedido");
		pedidos.put(pedido.getCodPedido(), pedido);
	}

	// DE ACA HACIA ABAJO HA CREADO EL MAGNIFICO LUCAS "GUIDI" AGUILERA.

	public ArrayList<Pedido> getPedidosTerminados() { // Crea un arraylist con los pedidos terminados.
		ArrayList<Pedido> pedidosTerminados = new ArrayList<>();
		ArrayList<Pedido> pedidosTotales = getPedidos();
		for (int i = 0; i < pedidosTotales.size(); i++) {
			if (pedidosTotales.get(i).getEstadoPedido().equals("TRM")) {
				pedidosTerminados.add(pedidosTotales.get(i));
			}
		}
		return pedidosTerminados;
	}

	public double calcularVelocidadMaquina1(Date n) {
		ArrayList<Pedido> pedidosTerminados = getPedidosTerminados();
		ArrayList<Pedido> pedidosFecha = new ArrayList<>();
		double velocidad = 0;
		double cantidadPedidos = 0;
		double horasDeProceso = 0;

		for (int i = 0; i < pedidosTerminados.size(); i++) { // Crear arraylist con pedidos mayores o iguales a la
																// fecha.
			if (pedidosTerminados.get(i).getCodMaquina().equals("M1")) {
				if (pedidosTerminados.get(i).getPedidoTerminado().getTime() >= n.getTime()) {
					pedidosFecha.add(pedidosTerminados.get(i));
				}
			}
		}
		for (int i = 0; i < pedidosFecha.size(); i++) { // Sacar cantidad de pedidos y hora de proceso.
			cantidadPedidos = Double.parseDouble(pedidosFecha.get(i).getCantidadPedido()) + cantidadPedidos;
			horasDeProceso = pedidosFecha.get(i).getHorasProcesoTermino() + horasDeProceso;
		}
		if (horasDeProceso != 0.0) {
			velocidad = cantidadPedidos / horasDeProceso;
		}

		return velocidad;
	}

	public double calcularVelocidadMaquina2(Date n) {
		ArrayList<Pedido> pedidosTerminados = getPedidosTerminados();
		ArrayList<Pedido> pedidosFecha = new ArrayList<>();
		double velocidad = 0;
		double cantidadPedidos = 0;
		double horasDeProceso = 0;

		for (int i = 0; i < pedidosTerminados.size(); i++) { // Crear arraylist con pedidos mayores o iguales a la
																// fecha.
			if (pedidosTerminados.get(i).getCodMaquina().equals("M2")) {
				if (pedidosTerminados.get(i).getPedidoTerminado().getTime() >= n.getTime()) {
					pedidosFecha.add(pedidosTerminados.get(i));
				}
			}
		}
		for (int i = 0; i < pedidosFecha.size(); i++) { // Sacar cantidad de pedidos y hora de proceso.
			cantidadPedidos = Double.parseDouble(pedidosFecha.get(i).getCantidadPedido()) + cantidadPedidos;
			horasDeProceso = pedidosFecha.get(i).getHorasProcesoTermino() + horasDeProceso;
		}
		if (horasDeProceso != 0.0) {
			velocidad = cantidadPedidos / horasDeProceso; // Velocidad en Pedidos/Hora
		}

		return velocidad;
	}

	public double calcularVelocidadMaquina3(Date n) {
		ArrayList<Pedido> pedidosTerminados = getPedidosTerminados();
		ArrayList<Pedido> pedidosFecha = new ArrayList<>();
		double velocidad = 0;
		double cantidadPedidos = 0;
		double horasDeProceso = 0;

		for (int i = 0; i < pedidosTerminados.size(); i++) { // Crear arraylist con pedidos mayores o iguales a la
																// fecha.
			if (pedidosTerminados.get(i).getCodMaquina().equals("M3")) {
				if (pedidosTerminados.get(i).getPedidoTerminado().getTime() >= n.getTime()) {
					pedidosFecha.add(pedidosTerminados.get(i));
				}
			}
		}
		for (int i = 0; i < pedidosFecha.size(); i++) { // Sacar cantidad de pedidos y hora de proceso.
			cantidadPedidos = Double.parseDouble(pedidosFecha.get(i).getCantidadPedido()) + cantidadPedidos;
			horasDeProceso = pedidosFecha.get(i).getHorasProcesoTermino() + horasDeProceso;
		}
		if (horasDeProceso != 0.0) {
			velocidad = cantidadPedidos / horasDeProceso;
		}

		return velocidad;
	}

	public void setHoraDeProcesar() { // Calcula la velocidad de Pedidos por hora
		ArrayList<Pedido> pedidosTotales = getPedidos();
		for (int i = 0; i < pedidosTotales.size(); i++) {
			if (pedidosTotales.get(i).getEstadoPedido().equals("PRG")
					|| pedidosTotales.get(i).getEstadoPedido().equals("NPR")) {
				if (pedidosTotales.get(i).getCodMaquina().equals("M1")) {
					pedidosTotales.get(i)
							.setVelocidadPedido(calcularVelocidadMaquina1(pedidosTotales.get(i).getTiempoHistorico()));
				}
				if (pedidosTotales.get(i).getCodMaquina().equals("M2")) {
					pedidosTotales.get(i)
							.setVelocidadPedido(calcularVelocidadMaquina2(pedidosTotales.get(i).getTiempoHistorico()));
				}
				if (pedidosTotales.get(i).getCodMaquina().equals("M3")) {
					pedidosTotales.get(i)
							.setVelocidadPedido(calcularVelocidadMaquina3(pedidosTotales.get(i).getTiempoHistorico()));
				}
			}
		}
	}

	public void setHoraProcesoTermino() { // Calcula cuanto se demoran los pedidos, cantidad * velocidad = Horas que
											// necesita para terminarse
		ArrayList<Pedido> pedidosTotales = getPedidos();
		for (int i = 0; i < pedidosTotales.size(); i++) {
			pedidosTotales.get(i).setHorasProcesoTermino(pedidosTotales.get(i).getVelocidadPedido()
					* Double.parseDouble(pedidosTotales.get(i).getCantidadPedido()));
		}
	}

}
