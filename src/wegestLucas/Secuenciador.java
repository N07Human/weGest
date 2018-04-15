/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wegestLucas;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Secuenciador{
	private GestionListas lista;
	
	/*DEBERIA SECUENCIAR LOS PEDIDOS POR PRIORIDAD DESDE EL ARBOL De CADA MAQUINA
	DEBE ENTREGAR UN DOCUMENTO CON LA LISTA DE PEDIDOS A REALIZAR
	CON CODIGO PEDIDO, CANTIDAD, TIEMPO APP, ESTADO*/
	
	
	
	/*Al cambiar estado de algun pedido debe eliminarlo de la lista y retornarlo para guardarlo
	en un registro historico de peidos terminados.*/
	
	public Secuenciador() {
		this.lista = new GestionListas();
	}

	public void setMaquinas(int numMaquinas) {
		lista.setMaquinas(numMaquinas);
	}
	public void secuenciar() {
		System.out.println("Entra a secuenciar (Secuenciar)");
		lista.generarListas();
		//lista.setMaquinas(3);
		ArrayList<Pedido> pedidos = lista.getPedidos();
		System.out.println(pedidos.size());
		long prioridad;
		System.out.println("pedidos.size(): "+pedidos.size());
		for(int i=0;i<pedidos.size();i++){ // CREAR OBJETOS PEDIDO
			String maquina = pedidos.get(i).getCodMaquina();
			String estadoPedido = pedidos.get(i).getEstadoPedido();
			Pedido pedido = pedidos.get(i);
			prioridad = calcularPrioridad(pedido.getFechaEntrega());
			//System.out.println("Antes del if (secuenciar)"); 	
			if(comprobarEstadoNPRPRG(estadoPedido)) {
				switch (maquina){
					case "M1":
							lista.agregarPedido("M1", prioridad, pedido);
							break;
							//System.out.println("Se cargo en M1 (secuenciar)"); 					// <.-----ELIMINAR
					case "M2":
							lista.agregarPedido("M2", prioridad, pedido);
							break;
					case "M3":
							lista.agregarPedido("M3", prioridad, pedido);
							break;
				}
			}
		}
		System.out.println("Sale de secuenciar (Secuenciar)");
	}
	
	
	public void agregarNuevoPedido(Pedido pedido) {
		lista.agregarNuevoPedido(pedido);
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
		        
		        //System.out.println("Entrega "+fentrega);
		        //System.out.println("Hoy: "+hoy);
		        		        
		        long diferencia = (fechaEntrega - fechaHoy);
		        long diferenciaDias = diferencia/(1000*60*60*24);
		        //System.out.println("Diferencia: "+diferencia+" cuociente: "+diferenciaDias);
		        return diferenciaDias;
		        //System.out.println(date);
		        //return System.out.println(formatter.format(date));

		    } catch (ParseException e) {
		        e.printStackTrace();
		    }
		return 0;
	}

	public void imprimirImport() {
		lista.imprimirImport();
	}
	
	public void imprimirSecuenciacionMaquinas() {
		lista.imprimirSecuenciacionMaquinas();
	}
	
	public void exportSecuenciacion() {
		lista.exportarExcel();
	}
	
	
	

}
