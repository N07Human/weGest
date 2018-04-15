package wegest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Maquina implements Secuenciable {

	private String codMaquina;
	private Map<String, List<Pedido>> lista;
	private List<Pedido> listaOrdenada;
	private Map<String, Object[]> listaSecuenciada;
	private double velocidadHistorica;

	public Maquina(String codMaquina) {
		this.codMaquina = codMaquina;
		this.listaOrdenada = new LinkedList<>();
		this.lista = new HashMap<String, List<Pedido>>();
		this.listaSecuenciada = new LinkedHashMap<String, Object[]>();
	}

	public void agregarPedido(String prioridad, Pedido pedido) { // Agragar pedido, si no existe hash lo crea, si
																	// existe
																	// lo agrega a la lista de ese hash

		if(existePrioridad(prioridad)) {
			lista.get(prioridad).add(pedido);
		}else{
			LinkedList<Pedido> nuevo = new LinkedList<Pedido>();
			nuevo.add(pedido);
			lista.put(prioridad, nuevo);
		}
	}

	private boolean existePrioridad(String prioridad) {	
		if(lista.containsKey(prioridad)) {
			return true;
		}
		return false;
	}

	private void ordenarLista() {
        Object[] keys = lista.keySet().toArray();
        Arrays.sort(keys);
		for (Object k : keys) {
			List<Pedido> listaIn = lista.get(k);
			for (int i = 0; i < listaIn.size(); i++) {
				listaOrdenada.add(listaIn.get(i));
			}
		}
	}

	public String getCodMaquina() {
		return codMaquina;
	}

	public double getVelocidadHistorico() {
		return velocidadHistorica;
	}

	public void setVelocidadHistorica(String fechaInicio) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		Date inicio = df.parse(fechaInicio);
		Date actual = new Date();
		double cantidadTotalPedidos = 0;
		double cantidadHoras = 0;
		Set<String> key = lista.keySet();
		for (String k : key) {
			List<Pedido> listaIn = lista.get(k);
			for (int i = 0; i < listaIn.size(); i++) {
				Pedido current = listaIn.get(i);
				actual = df.parse(current.getFechaEntrega());
				if (inicio.getTime() <= actual.getTime() && current.getEstadoPedido().equals("TRM")) {
					cantidadTotalPedidos += Double.parseDouble(current.getCantidadPedido());
					cantidadHoras += Double.parseDouble(current.getTiempoProceso());
					System.out.println("Cantidad de Horas: " + cantidadHoras);
					System.out.print("Cod Pedido: " + current.getCodCliente());
					System.out.print("Total Pedidos: " + cantidadTotalPedidos);
					System.out.print("Horas: " + cantidadHoras);
					System.out.println("Maquina: " + current.getCodMaquina());
					System.out.println("Estado: " + current.getEstadoPedido());
				}

			}

		}
		this.velocidadHistorica = cantidadTotalPedidos / cantidadHoras;
	}

	public void imprimirLista() {
		Set<String> key = lista.keySet();

		for (String k : key) {
			List<Pedido> listaIn = lista.get(k);
			for (int i = 0; i < listaIn.size(); i++) {
				Pedido aux = listaIn.get(i);
				System.out.println(aux.getCodPedido() + " " + aux.getCodCliente() + " " + aux.getCodMaquina());
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public void secuenciar(String hInicio) throws ParseException {
		ordenarLista();
		SimpleDateFormat df = new SimpleDateFormat("hh:mm");
		Date hoy = new Date();
		Date horaInicio = df.parse(hInicio);
		double horas = horaInicio.getHours();
		double minutos = horaInicio.getMinutes();
		double horasSumar, h;
		double minutosSumar, m;
		Pedido aux = listaOrdenada.get(0);
		double tiempoSumar = 0;
		int key = 0;
		System.out.println("PEDIDOS TOTAL: "+listaOrdenada.size());
		listaSecuenciada.put("0", new Object[] { "Fecha de Inicio", "Codigo Pedido", "Detalle",
				"Cantidad", "Fecha de Entrega" });
		for (int i = 1; i < listaOrdenada.size(); i++) {
			aux = listaOrdenada.get(i);
			System.out.println("For: "+i);
			if (!aux.getEstadoPedido().equals("TRM")) {
				if (key==0) {
					listaSecuenciada.put("1", new Object[] { df.format(horaInicio), aux.getCodPedido(), aux.getTipoPedido(),
							aux.getCantidadPedido(), aux.getFechaEntrega() });
					key=1;
				} else {
					key++;
					System.out.println("Contador: "+key);
					// System.out.println(tiempoSumar);
					tiempoSumar = Double.parseDouble(aux.getCantidadPedido()) / velocidadHistorica;
					horasSumar = (int) tiempoSumar;
					//System.out.println("Tiempo a Sumar: " + tiempoSumar);
					minutosSumar = (tiempoSumar - horasSumar) * 60;
					h = horas + horasSumar;
					m = minutos + minutosSumar;

					// System.out.println("Entra con h: "+h+" y m: "+m);
					while ((h >= 24) || (m >= 60)) {
						// System.out.println("Entra con h: "+h+" y m: "+m);
						if (m >= 60) {
							h = h + (m / 60);
						}
						if (h >= 24) {
							h = h - 24;
						}
						m = (m / 60) - (int) Math.floor(m / 60);
						// System.out.println(m);
					}

					// System.out.println(tiempoSumar);
					String hora = null, minuto = null;
					if (h < 10) {
						hora = "0" + Integer.toString((int) h);
					} else {
						hora = Integer.toString((int) h);
					}
					if (m < 10) {
						minuto = "0" + Integer.toString((int) m);
					} else {
						minuto = Integer.toString((int) m);
					}
					System.out.println("Ingresar pedido: " + aux.getCodPedido() + " a las " + hora + ":" + minuto
							+ " Feecha de entrega: " + aux.getFechaEntrega());
					System.out.println("");
					listaSecuenciada.put(Integer.toString(key), new Object[] { hora + ":" + minuto, aux.getCodPedido(),
							aux.getTipoPedido(), aux.getCantidadPedido(), aux.getFechaEntrega() });
					horas = h;
					minutos = m;
				}

			}

		}
	}

	public void exportar() {
		ExportExcel exportador = new ExportExcel();
		exportador.exportExcel("Maquina 1", listaSecuenciada, codMaquina + ".xlsx");

	}

	public void importar() {
		// TODO Auto-generated method stub

	}

	public void agregarElemento(Object elemento, Object raiz) {
		// TODO Auto-generated method stub

	}
}
