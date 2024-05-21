package pkgDataStore;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class DataSource {
	
	private File filePath;
	private FileReader fileReader;
	private CSVReader csvReader;
	private FileWriter fileWriter;
	private CSVWriter csvWriter;
	
	LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
	
	private LinkedHashMap<String, String> loadDataFromCSV(String fileName) {
		try {
			filePath = new File(System.getProperty("user.dir")+"/testData/"+fileName+".csv");
			fileReader = new FileReader(filePath);
			csvReader = new CSVReader(fileReader);
			String[] rows;
			List<Object> keyList = new ArrayList<>();
			List<String> listKeys;
			String[] value;
			int currentRow = 0;
			
			while((rows = csvReader.readNext())!= null) {
				currentRow = currentRow + 1;
				int i =0;
				if(currentRow == 1) {
					for(String cell : rows) {
						keyList.add(i, cell);
						linkedHashMap.put(cell, null);
						i++;
					}
				} else if(currentRow > 1) {
					value = rows;
					if(value[0].contains("Yes")) {
						continue;
					} else if(value[0].contains("No")) {
						for(String cell : rows) {
							linkedHashMap.replace(keyList.get(i).toString(), cell);
							i++;
						}
						linkedHashMap.replace("Read", "Yes");
						listKeys = new LinkedList<String>(linkedHashMap.keySet());
						System.out.println("Index of Read : "+listKeys.indexOf("Read"));
						updateData(currentRow-1, listKeys.indexOf("Read"),fileName);
						break;
					}
				}	
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return linkedHashMap;
	}
	
//	public LinkedHashMap<String, String> readData(String fileName) {
//		linkedHashMap = loadDataFromCSV(fileName);
//		return linkedHashMap;
//	}
	
	public LinkedHashMap<String, String> readData(String fileName) {
		linkedHashMap = loadDataFromCSV(fileName);
		return linkedHashMap;
	}
	
	public void updateData(int row, int column, String fileName) {
		
		try {
			filePath = new File(System.getProperty("user.dir")+"/testData/"+fileName+".csv");
			fileReader = new FileReader(filePath);
			csvReader = new CSVReader(fileReader);
			List<String[]> csvBody = csvReader.readAll();
/*			System.out.println("--------------------Before Updating-----------------");
			for(int i = 0; i <csvBody.size(); i++) {
				for(String value1 : csvBody.get(i)) {
					System.out.print("\t"+value1);
				}
				System.out.println();
			}
*/
			System.out.println(row);
			System.out.println(column);
			csvBody.get(row)[column] = "Yes";
			
			System.out.println("Success");
			
			fileWriter = new FileWriter(filePath);
			csvWriter = new CSVWriter(fileWriter);
			csvWriter.writeAll(csvBody);
			csvWriter.flush();
			csvWriter.close();
/*			
			System.out.println("--------------------After Updating-----------------");
			for(int i = 0; i <csvBody.size(); i++) {
				for(String value1 : csvBody.get(i)) {
					System.out.print("\t"+value1);
				}
				System.out.println();
			}
*/
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
