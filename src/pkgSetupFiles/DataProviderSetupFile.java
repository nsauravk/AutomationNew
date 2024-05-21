package pkgSetupFiles;

import java.io.File;

import org.testng.annotations.DataProvider;

public class DataProviderSetupFile
{
		
	@DataProvider(name = "UserDetails")
	public Object[][] addBuyerDetails() throws Exception {
		File filePath = new File(System.getProperty("user.dir")+"/testData/UserDetails.csv");
		Object obj[][] = CSVReadSetupFile.readCsv(filePath);

		return obj;
	}
}
