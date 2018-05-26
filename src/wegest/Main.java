package wegest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.mysql.jdbc.PreparedStatement;

public class Main {

	public static void main(String[] args) throws ParseException, IOException {

		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

		/*
		 * System.out.println("/////////WeGest de INTIsoft///////");
		 * System.out.println("/////////version 1.0///////"); Listas listas = new
		 * Listas(); System.out.println(" "); listas.importar();
		 * listas.ordenarPorMaquina(); System.out.println("Ingrese Fecha Histórica.");
		 * System.out.println("Use formato dd-mm-aaaa"); String fechaHistorica =
		 * lector.readLine(); listas.setVelocidadHistorica(fechaHistorica);
		 * System.out.println("Ingrese hora de inicio secuenciacion");
		 * System.out.println("Utilice formato 'dd/mm/yyy hh:mm' "); String horaInicio =
		 * lector.readLine();
		 * 
		 * 
		 * int menu=0; while(menu>=0) { System.out.println("Opciones. ");
		 * System.out.println("1. Importar datos.");
		 * System.out.println("2. Secuenciar. ");
		 * System.out.println("3. Exportar Maq Secuenciadas/Clientes. "); menu =
		 * Integer.parseInt(lector.readLine()); switch(menu) { case 1: {
		 * listas.importar(); break; } case 2:{ listas.secuenciar(horaInicio); break; }
		 * case 3:{ listas.exportar(); menu=-1; break; }
		 * 
		 * } }
		 */
		ConectarDB conectar = new ConectarDB("jdbc:mysql://localhost:3306/empresa", "root", "");

		try {
			conectar.conectarDB();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// conectar.manageDB("CREATE TABLE pedidos (idPedido int)");
		// conectar.manageDB("INSERT INTO pedidos (idPedido) VALUES(12345)");

		System.out.println("/////////WeGest de INTIsoft///////");
		System.out.println("/////////version 2.0///////");
		System.out.println("");
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

		int menu = -1;

		while (menu != 0) {
			System.out.println("MENÚ");
			System.out.println("1. Administrar Pedidos.");
			System.out.println("2. Administrar Clientes.");
			System.out.println("3. Programa de Producción.");
			System.out.println("4. Estadísticas.");
			System.out.println("Ingrese '0' para salir.");
			menu = Integer.parseInt(lector.readLine());

			switch (menu) {
			case 1: // ADMINISTRAR PEDIDOS
				while (menu != 0) {
					System.out.println("///Administrar Pedidos///");
					System.out.println("1. Ingresar nuevo pedido.");
					System.out.println("2. Editar pedido existente.");
					System.out.println("3. Eliminar pedido.");
					System.out.println("Ingrese '0' para salir.");
					menu = Integer.parseInt(lector.readLine());
					switch (menu) {
					case 1: // INGRESAR PEDIDO
						System.out.println("///1. Ingresar Pedido///");
						System.out.println("Ingrese código de pedido.");
						String codPedido = lector.readLine();
						System.out.println("Ingrese código de cliente.");
						String codCliente = lector.readLine();
						System.out.println("Ingrese tipo de producto.");
						String tipoProducto = lector.readLine();
						System.out.println("Ingrese cantidad de producto.");
						String cantidadProducto = lector.readLine();
						System.out.println("Ingrese fecha de entrega");
						// Date fechaEntrega = df.parse(lector.readLine());
						String fechaEntrega = lector.readLine();
						conectar.manageDB("INSERT INTO pedidos (idPedido,idCliente,producto,cantidad,entrega) VALUES("
								+ codPedido + "," + codCliente + "," + tipoProducto + "," + cantidadProducto + ","
								+ fechaEntrega + ")");
						break;

					case 2: // EDITAR PEDIDO
						System.out.println("///2. Editar pedido///");
						System.out.println("Ingrese código de pedido a editar.");
						// String codPedidoe = lector.readLine();
						System.out.println("1. Ingrese código de cliente.");
						System.out.println("2. Ingrese tipo de producto.");
						System.out.println("3. Ingrese cantidad de producto.");
						System.out.println("4. Ingrese fecha de entrega");
						System.out.println("Ingrese '0' para salir.");
						break;

					case 3: // ELIMINAR PEDIDO
						break;
					}
					break;
				}
			case 2: //ADMINISTRAR CLIENTES
				while (menu != 0) {
					System.out.println("///Administrar Clientes///");
					System.out.println("1. Ingresar nuevo cliente.");
					System.out.println("2. Editar cliente existente.");
					System.out.println("3. Eliminar cliente.");
					System.out.println("Ingrese '0' para salir.");
					menu = Integer.parseInt(lector.readLine());
					switch (menu) {
					case 1: // INGRESAR CLIENTE
						System.out.println("///(1) Ingresar Cliente///");
						System.out.println("Ingrese código de cliente.");
						String codCliente = lector.readLine();
						System.out.println("Ingrese razón social.");
						String tipoProducto = lector.readLine();
						System.out.println("Ingrese dirección de despacho.");
						String cantidadProducto = lector.readLine();
						System.out.println("Ingrese teléfono de contacto.");
						// Date fechaEntrega = df.parse(lector.readLine());
						String fechaEntrega = lector.readLine();
						conectar.manageDB("INSERT INTO pedidos (idPedido,idCliente,producto,cantidad,entrega) VALUES("
								+ codCliente + "," + tipoProducto + "," + cantidadProducto + ","
								+ fechaEntrega + ")");
						break;

					case 2: // EDITAR CLIENTE
						System.out.println("///(2) Editar Cliente///");
						System.out.println("Ingrese código de pedido a editar.");
						// String codPedidoe = lector.readLine();
						System.out.println("1. Ingrese código de cliente.");
						System.out.println("2. Ingrese tipo de producto.");
						System.out.println("3. Ingrese cantidad de producto.");
						System.out.println("4. Ingrese fecha de entrega");
						System.out.println("Ingrese '0' para salir.");
						break;

					case 3: // ELIMINAR CLIENTE
						break;
					}
				}
				
			case 3: // PROGRAMAS DE PRODUCCIÓN
				while(menu!=0) {
					System.out.println("///(3) Programas de producción.///");
					System.out.println("1 Obtener programa nuevo.");
					System.out.println("2 Revisar programa anterior.");
					System.out.println("Ingrese '0' para salir.");
					
					menu = Integer.parseInt(lector.readLine());
					switch(menu){
					case 1:
						
					}
					
				}
			}

		}
		/*
		 * try (PreparedStatement stmt =
		 * conectar.prepareStatement("SELECT country FROM country")) { ResultSet rs =
		 * stmt.executeQuery();
		 * 
		 * while (rs.next()) System.out.println (rs.getString("country"));
		 * 
		 * } catch (SQLException sqle) { System.out.println("Error en la ejecución:"+
		 * sqle.getErrorCode() + " " + sqle.getMessage()); }
		 */

	}

}