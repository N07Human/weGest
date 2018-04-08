package wegest;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
//import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ImportExcel {

	@SuppressWarnings("deprecation")
	public static ArrayList<String[]> importExcel(String fileName, int numColums) {

		// ArrayList donde guardaremos todos los datos del excel
		ArrayList<String[]> data = new ArrayList<>();

		try {
			// Acceso al fichero xlsx
			FileInputStream file = new FileInputStream(new File(fileName));

			// Creamos la referencia al libro del directorio dado
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Obtenemos la primera hoja
			XSSFSheet sheet = workbook.getSheetAt(0);

			// Iterador de filas
			Iterator<Row> rowIterator = sheet.iterator();

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				// Iterador de celdas
				Iterator<Cell> cellIterator = row.cellIterator();
				// contador para el array donde guardamos los datos de cada fila
				int contador = 0; 
				// Array para guardar los datos de cada fila
				// y añadirlo al ArrayList
				String[] fila = new String[numColums];
				// iteramos las celdas de la fila
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();

					// Guardamos los datos de la celda segun su tipo

					// si es numerico
					if (cell.getCellTypeEnum() == CellType.NUMERIC)
						fila[contador] = (int) cell.getNumericCellValue() + "";

					// si es cadena de texto asad
					if (cell.getCellTypeEnum() == CellType.STRING)
						fila[contador] = cell.getStringCellValue() + "";
					
					

					/*// SI ES TIPO DATE (FALTA)
					if(cell.getCellTypeEnum()!=CellType.NUMERIC && cell.getCellTypeEnum()!=CellType.STRING) {
						//Date fecha = cell.getDateCellValue();
						Date date = cell.getDateCellValue();
						SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-mm-yy");
						fila[contador] = formatoFecha.format(date);				
					}*/

					// Si hemos terminado con la uasdltima celda de la fila
					if ((contador+1) % numColums == 0) {
						
						fila[contador] = cell.getStringCellValue() + "";
						// Añadimos la fila al ArrayList con todos los datos
						data.add(fila);
					}
					// Incrementamos el contadorsa asd
					// con cada fila terminada al redeclarar arriba el contador,
					// no obtenemos excepciones de ArrayIndexOfBounds
					contador++;
				}
			}
			// Cerramos el fichero y workbook
			file.close();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Excel importado correctamente\n");

		return data;
	}

	private static String dateInString(Date fecha) {
		// TODO Auto-generated method stub
		return null;
	}

}
