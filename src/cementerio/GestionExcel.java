package cementerio;

import java.util.ArrayList;

public interface GestionExcel {

	public ArrayList<String[]> importExcel(String fileName, int numColums);
}
