package wegest;

public class Main {

	public static void main(String[] args) {		
	
	/*
		//Datos a escribir en map(Object[])
        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        //Cabecera
        data.put("1", new Object[] {"ID", "Nombre", "Apellidos"});
        //Datos
        data.put("2", new Object[] {1, "Jose", "Roldan"});
        data.put("3", new Object[] {2, "Antonio", "Jimenez"});
        data.put("4", new Object[] {3, "Laura", "Perez"});
        data.put("5", new Object[] {4, "Pedro", "Garcia"});
        
        boolean correcto = ExportExcel.exportExcel("DatosPersonas",data,"/home/fothwira/Documentos/Excel.xlsx");
   */ 
		
	/*
       // if(correcto){
        	
        	ArrayList<String[]> datosExcel = ImportExcel.importExcel("datosEmpresa.xlsx",10);
        	ArrayList<Pedido> pedidos = new ArrayList<>();
        	ArrayList<Cliente> clientes = new ArrayList<>();
       
        	
        	System.out.println((datosExcel.get(3))[1]);
            ListIterator<String[]> itCreador = datosExcel.listIterator();
            String[] data = itCreador.next(); //EL PRIMER ELEMENTO SON LAS ETIQUETAS
            while(itCreador.hasNext()) {  // CREAR OBJETOS PEDIDO
            	data = itCreador.next();
            	Pedido pedido = new Pedido(data[0], data[1], data[3], Integer.parseInt(data[4]), data[8], data[6], data[7]);
            	Cliente cliente = new ClienteEmpresa(data[1], data[2], data[3], null,null);
            	pedidos.add(pedido);
            	clientes.add(cliente);
            }
            
            ListIterator<Pedido> itPedidos = pedidos.listIterator();  //LEER EL ARRAY 
            while(itPedidos.hasNext()) {
            	Pedido dato  = itPedidos.next();
            	System.out.println(dato.getCodigoCliente());		//IMPRIMIR CODIGOS DE CLIENTE
            }
            
            
            //COdigo Original
            ListIterator<String[]> it = datosExcel.listIterator();
            while (it.hasNext()) {
    			String[] datos =  it.next(); 	//.next() lee hasta que encuentra espacio, a diferencia de
    											//nextLine() que lee hasta un salto de línea
    			String personaInfo = "";
    			for (String fila : datos) {		// for each, tambien conocido como for extendido
    				personaInfo += fila + " ";	// for ( tipoVariable nombreCualquiera : arregloaLeer)
    			}
    			System.out.println(personaInfo+"\n");
    		}
        //}
		*/
		
		//GestionListas listas = new GestionListas();
		
		
		//listas.generarListas();
		//listas.setMaquinas(3);
		//listas.imprimirListas();
        //listas.imprimirPedidos();
		//listas.getCodigoCliente("11384");
		
		Secuenciador sec = new Secuenciador();
		
		sec.secuenciar();
		//sec.imprimirImport();
		sec.imprimirSecuenciacionMaquinas();
		Pedido nuevoPedido = new Pedido("000000", "0000", "CAJITAS" ,"50", "NPR", "M3", "12-12-2018");
		sec.agregarNuevoPedido(nuevoPedido);
		sec.secuenciar();
		sec.imprimirSecuenciacionMaquinas();
	}

}

