package wegest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

public class Main {

	public static void main(String[] args) throws ParseException, IOException {
		
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("/////////WeGest de INTIsoft///////");
		System.out.println("/////////version 1.0///////");
		Listas listas = new Listas();
		System.out.println(" ");
		listas.importar();
		listas.ordenarPorMaquina();
		System.out.println("Ingrese Fecha Histórica.");
		System.out.println("Use formato dd-mm-aaaa");
		String fechaHistorica = lector.readLine();
		listas.setVelocidadHistorica(fechaHistorica);
		System.out.println("Ingrese hora de inicio secuenciacion");
		System.out.println("Utilice formato 'dd/mm/yyy hh:mm' ");
		String horaInicio = lector.readLine();
		
	
		int menu=0;
		while(menu>=0) {
			System.out.println("Opciones. ");
			System.out.println("1. Importar datos.");
			System.out.println("2. Secuenciar. ");
			System.out.println("3. Exportar. ");
			menu = Integer.parseInt(lector.readLine());
			switch(menu) {
			case 1: {
				listas.importar();
				break;
			}
			case 2:{
				listas.secuenciar(horaInicio);
				break;
			}
			case 3:{
				listas.exportar();
				break;
			}
			
			}
		}
		
		
	}

}