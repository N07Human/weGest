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
	protected Calendar cal;
	
	public Maquina(String codMaquina) {
		this.codMaquina = codMaquina;
		this.listaOrdenada = new LinkedList<>();
		this.lista = new HashMap<String, List<Pedido>>();
		this.listaSecuenciada = new LinkedHashMap<String, Object[]>();
	}

	public void agregarPedido(String prioridad, Pedido pedido) { // Agragar pedido, si no existe hash lo crea, si
																	// existe
																	// lo agrega a la lista de ese hash

		if (existePrioridad(prioridad)) {
			lista.get(prioridad).add(pedido);
		} else {
			LinkedList<Pedido> nuevo = new LinkedList<Pedido>();
			nuevo.add(pedido);
			lista.put(prioridad, nuevo);
		}
	}

	private boolean existePrioridad(String prioridad) {
		if (lista.containsKey(prioridad)) {
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

	public void secuenciar(String hInicio) throws ParseException {
		ordenarLista();
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		SimpleDateFormat dfatraso = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat dff = new SimpleDateFormat("dd/MM 'a las' hh:mm");
		
		Date horaInicioActual = new Date();
		horaInicioActual = df.parse(hInicio);
		Date horaInicioSiguiente = horaInicioActual;
		Pedido aux = listaOrdenada.get(0);
		double tiempoSumar = 0;
		int key = 0;
		listaSecuenciada.put("0",
				new Object[] { "Fecha de Inicio", "Codigo Pedido", "Detalle", "Cantidad", "Fecha de Entrega", "Atraso"});
		for (int i = 1; i < listaOrdenada.size(); i++) {
			aux = listaOrdenada.get(i);
			if (!aux.getEstadoPedido().equals("TRM")) {
					key++;
					horaInicioActual = horaInicioSiguiente;
					tiempoSumar = Double.parseDouble(aux.getCantidadPedido()) / velocidadHistorica;
					//System.out.println(tiempoSumar);
					//System.out.println(Double.parseDouble(aux.getCantidadPedido()) / velocidadHistorica);
					
					horaInicioSiguiente=new Date((long) (horaInicioActual.getTime() + (tiempoSumar*60*60)*1000));
					//System.out.println("HORA InicioActual: "+horaInicioActual.getTime());
					//System.out.println("HORA InicioActual: "+dff.format(horaInicioActual));
					//System.out.println("HORA InicioSiguiente: "+horaInicioSiguiente.getTime());
					//System.out.println("HORA InicioSiguiente: "+dff.format(horaInicioSiguiente));
					//System.out.println("Fecha Entrega: "+aux.getFechaEntrega());
					//System.out.println("Fecha Entrega: "+dfatraso.parse(aux.getFechaEntrega()).getTime());
					
					int atraso = calcularAtraso(horaInicioSiguiente, dfatraso.parse(aux.getFechaEntrega()));
					//System.out.println("ATRASO: "+atraso);
					
					listaSecuenciada.put(Integer.toString(key), new Object[] { dff.format(horaInicioActual), aux.getCodPedido(),
							aux.getTipoPedido(), aux.getCantidadPedido(), aux.getFechaEntrega(), Integer.toString(atraso) });

			}

		}
	}

	public int calcularAtraso(Date fechaTermino, Date fechaEntrega) {
		long actual = fechaTermino.getTime();
		long entrega = fechaEntrega.getTime();	
		long atraso = (actual-entrega);
		return (int)(atraso/(60*60*24*1000));		
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
