package wegest;
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
		this.lista = new HashMap<Long,LinkedList<Pedido>>();
	}
	
	public void agregarPedido(long prioridad,Pedido pedido) { //Agragar pedido, si no existe hash lo crea, si existe lo agrega a la lista de ese hash
		if(lista.containsKey(prioridad)) {
			if(!existePedido(pedido)) {
				lista.get(prioridad).add(pedido);
			}
		}else {
			LinkedList<Pedido> nuevo = new LinkedList<Pedido>();
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
			for(int j=0;j<listaInterna.size();j++) {
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
		
		
	}
	
	/*public void imprimirLista() {
		Set<Long> keys = lista.keySet();
		for(long i:keys) {
			System.out.println(lista.get(i).getFirst().getCodMaquina());
		}
	}*/

}
