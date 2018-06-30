package wegestSQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Secuenciador {

	private String fechahistorica;
	private double[] velocidad;
	private ConectarDB conectar;
	private Connection conector;

	public Secuenciador() throws ClassNotFoundException {
		this.velocidad = new double[3];
		this.conectar = new ConectarDB();
	}

	public void setVelocidad(String fechaH) throws ParseException, SQLException {
		this.fechahistorica = fechaH;
		velocidad[0] = 0;
		velocidad[1] = 0;
		velocidad[2] = 0;
		// System.out.println(velocidad[0]);
		this.velocidad[0] = getVelocidad("M1", fechahistorica);
		this.velocidad[1] = getVelocidad("M2", fechahistorica);
		this.velocidad[2] = getVelocidad("M3", fechahistorica);
		// System.out.println("Aqui dentro de setvelocidad: "+velocidad[0]);
	}

	public double getVelocidadMaquina(int i) {
		return velocidad[i];
	}

	// Obtener Velocidad
	private double getVelocidad(String maquina, String ddMMyyyy) throws SQLException, ParseException {

		SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy");
		Date parsed = format.parse(ddMMyyyy);
		java.sql.Date fecha = new java.sql.Date(parsed.getTime());

		//System.out.println("Fecha dentro de getvelocidad: " + fecha);

		conector = conectar.getConnection();

		double velocidad = 0;
		String stmt = "SELECT sum(cantidadPedido)/sum(tiempoProceso) AS 'velocidadMaquina' FROM pedidos WHERE codigoMaquina = '"
				+ maquina + "' AND estado = 'TRM' AND 'fechaPactada' > '" + fecha + "' GROUP BY codigoMaquina";
		try (java.sql.PreparedStatement st = conector.prepareStatement(stmt)) {
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				velocidad = rs.getInt("velocidadMaquina");
				//System.out.println("Dentro de metodo sql: " + velocidad);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return velocidad;
	}

	
	public void secuenciar(String fechaInicial) throws ParseException {
		//String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

				/*
				 * Otra Forma getCurrentTime Calendar currenttime = Calendar.getInstance();
				 * java.sql.Date sqldate = new java.sql.Date((currenttime.getTime()).getTime());
				 */

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timeStamp = sdf.format(Calendar.getInstance().getTime());
		String start = fechaInicial;
		
		//java.sql.Date parsed = (java.sql.Date) sdf.parse(fechaComenzar);
		//java.sql.Date cT = (java.sql.Date) sdf.parse(timeStamp);
		//java.sql.Date fechaInicial = new java.sql.Date(parsed.getTime());
		//java.sql.Date currentTime = new java.sql.Date(cT.getTime());
		
		
		System.out.println("ANTES CurrentTime: "+timeStamp+", Fecha Inicial: "+fechaInicial);
		System.out.println("TIMESTAMP: "+timeStamp);
		conector = conectar.getConnection();

		double tiempoSumar = 0;
		for (int i = 1; i < 4; i++) {
			fechaInicial = start;
			String stmt = "SELECT codigoPedido, cantidadPedido FROM pedidos WHERE codigoMaquina='M"+i+"' AND estado='NPR' ORDER BY pedidos.FechaPactada ASC ";
			//System.out.println("STMT: " + stmt);

			ResultSet rs = null;
			try {
				java.sql.PreparedStatement st = conector.prepareStatement(stmt);
				rs = st.executeQuery();
				//rs.next();
				//System.out.println("Ejecutado '" + stmt + " , rs: " + rs.getInt(1));
				
				while (rs.next()) {

					int codigoPedido = rs.getInt("codigoPedido");
					int cantidadPedido = rs.getInt("cantidadPedido");
					
					
					stmt = "INSERT INTO programas (fechaPrograma, codigoPedido, fechaIngreso) VALUES('"+timeStamp+"',"+codigoPedido+",'"+fechaInicial+"')";
					System.out.println("Codigo Pedido: "+codigoPedido+", Cantidad Pedido: "+cantidadPedido);
					System.out.println("CurrentTime: "+timeStamp+", Fecha Inicial: "+fechaInicial);
					try  {
						java.sql.PreparedStatement stm = conector.prepareStatement(stmt);
						stm.executeUpdate();
						System.out.println("Ejecutado '" + stm);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					//fechaInicial = new java.sql.Date(parse)
					java.util.Date fechaInicio = sdf.parse(fechaInicial);
					tiempoSumar = (cantidadPedido/velocidad[i-1]) * (60 * 60 * 1000);
					fechaInicio = new java.sql.Date((long) (fechaInicio.getTime() + tiempoSumar));
					fechaInicial = sdf.format(fechaInicio);

				}
			} catch (SQLException sqle) {
				System.out.println("Error en la ejecución:" + sqle.getErrorCode() + " " + sqle.getMessage());
			}
		

		}
		conectar.desconectarDB();

	}

}
