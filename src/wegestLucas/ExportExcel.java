/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wegestLucas;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//http://www.javasobretodo.es/programacion/excel-importarexportar-con-java/
public class ExportExcel {

    public static boolean exportExcel(String nombreHoja, Map<String, Object[]> data, String fileName) {

        // Creamos el libro de trabajo
        XSSFWorkbook libro = new XSSFWorkbook();

        // Creacion de Hoja
        XSSFSheet hoja = libro.createSheet(nombreHoja);

        // Iteramos el map e insertamos los datos
        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset) {
            System.out.println("FILA: " + key);
            // cramos la fila
            Row row = hoja.createRow(rownum++);
            // obtenemos los datos de la fila
            Object[] objArr = data.get(key);
            int cellnum = 0;
            // iteramos cada dato de la fila
            for (Object obj : objArr) {

                // Creamos la celda
                Cell cell = row.createCell(cellnum++);
                // Setteamos el valor con el tipo de dato correspondiente
                if (obj instanceof String) {
                    cell.setCellValue((String) obj);
                } else if (obj instanceof Integer) {
                    cell.setCellValue((Integer) obj);
                }
            }
        }
        try {
            // Escribimos en fichero
            FileOutputStream out = new FileOutputStream(new File(fileName));
            libro.write(out);
            // cerramos el fichero y el libro
            out.close();
            libro.close();
            System.out.println("Excel exportado correctamente\n");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }
}
