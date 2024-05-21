package pkgSetupFiles;

import java.io.*;
import java.util.*;

import au.com.bytecode.opencsv.CSVReader;

public class CSVReadSetupFile {
	
	public static Object[][] readCsv(File file) throws Exception {
        Object obj[][]=null;
        try {

            // Create an object of FileReader
            // class with CSV file as a parameter.
            FileReader fileReader = new FileReader(file);
            //Skipping Header
            CSVReader csvReader = new CSVReader(fileReader);

            List<String[]> allData = csvReader.readAll();

            int rowCount = allData.size();
            System.out.println("Row count= " + rowCount);

            String[] headers = allData.get(0);

            int colCount = headers.length;
            System.out.println("Col count=" + colCount);

            obj = new Object[rowCount][colCount];

            for (int i = 0, j = 0; i < rowCount; i++) {
                while (j < colCount) {
                    String[] rowData = allData.get(i);
                    for (String cell : rowData) {
                        //System.out.print("Row: " + i + ", Cell: " + j);
                        obj[i][j] = cell;
                        //System.out.println(" | " + obj[i][j]);
                        j++;
                    }
                }
                j = 0;
            }
            
            csvReader.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //To print 2D array
        System.out.println("CSV Data : "+Arrays.deepToString(obj));
        return obj;
	}

}
