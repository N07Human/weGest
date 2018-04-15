/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wegestLucas;

import java.util.*;

public class Maquina {
	
	private String codMaquina;
	private Map<Long,LinkedList<Pedido>> lista;
	private double tiempoHistorico;
	
	
	/*CAMBIAR A MAP, DE TAL FORMA QUE AL AGREGAR SE AGREGUE EN EL 
	HASH QUE TIENE LA PRIORIDAD O SI NO EN UN NUEEVO 
	QUE CALCULE LA PARTE ENTERA Y LUEGO LO META A LA COLECCION*/
	
	public Maquina(String codMaquina, double tiempoHistorico) {
		this.codMaquina = codMaquina;
		this.tiempoHistorico = tiempoHistorico;
		this.lista = new HashMap<>();
	}
	
	public void agregarPedido(long prioridad,Pedido pedido) { //Agragar pedido, si no existe hash lo crea, si existe lo agrega a la lista de ese hash
		if(lista.containsKey(prioridad)) {
			if(!existePedido(pedido)) {
				lista.get(prioridad).add(pedido);
			}
		}else {
			LinkedList<Pedido> nuevo = new LinkedList<>();
			//nuevo.add(pedido);
			lista.put(prioridad, nuevo);
			lista.get(prioridad).add(pedido);
			
		}
	}
	
	private boolean existePedido(Pedido pedido) {
		String codPedido = pedido.getCodPedido();
		Set<Long> keys = lista.keySet();
		for(long i:keys) {
			LinkedList<Pedido> listaInterna = lista.get(i);
			for(int j=0;j<listaInterna.size();) {
				if(listaInterna.get(j).getCodPedido().equals(codPedido))
					System.out.println("ExistePedido");
					return true;
			}
			
		}
		return false;
	}
	
	public String getCodMaquina() {
		return codMaquina;
	}
	
	public double getTempoHistorico() {
		return tiempoHistorico;
	}

	public void imprimirLista() {
		Set<Long> keys = lista.keySet();
		for(long i:keys) {
			LinkedList<Pedido> aux = new LinkedList<>();
			aux = lista.get(i);
			for(int j=0;j<aux.size();j++) {
				System.out.println(aux.get(j).getCodPedido()+" "+aux.get(j).getCodCliente()+" "+aux.get(j).getCodMaquina());
			}
		}
		
	}
	
	

	public void exportarExcel() {
		Map<String,Object[]> datos = new TreeMap<String,Object[]>();
		Object[] filas = new Object[3];
		Set<Long> keys = lista.keySet();
		int contador = 0;
		for(long i:keys) {
			LinkedList<Pedido> aux = new LinkedList<>();
			aux = lista.get(i);
			for(int j=0;j<aux.size();j++) {
				/*
				filas[0] = aux.get(j).getCodPedido();
				filas[1] = aux.get(j).getCodCliente();
				filas[2] = aux.get(j).getCodMaquina();
				*/
				
				datos.put(Integer.toString(contador), new Object[] {aux.get(j).getCodPedido(),aux.get(j).getCodCliente(),aux.get(j).getCodMaquina()});
				System.out.println("Entro for put");
				contador++;
			}
			
				//System.out.println(aux.get(j).getCodPedido()+" "+aux.get(j).getCodCliente()+" "+aux.get(j).getCodMaquina());
		}
		ExportExcel.exportExcel("DatosPersonas",datos,"/Desktop/ExcelSALIDA.xlsx");
			
	}
		
		
	
	/*public void imprimirLista() {
		Set<Long> keys = lista.keySet();
		for(long i:keys) {
			System.out.println(lista.get(i).getFirst().getCodMaquina());
		}
	}*/

}