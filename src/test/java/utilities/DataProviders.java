package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	//DataProvider 1
	
	
	@DataProvider(name = "LoginData")
	public String [][] getData() throws IOException
	{
		String path = ".\\testData\\Opencart_LoginData.xlsx";   //taking x1 file from testData
		
		ExcelUtility xlutil = new ExcelUtility(path);  //creating an object for XLUtility--> link to constructor
		
		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getCellCount("Sheet1", 1);
		
		String logindata[][] = new String[totalrows][totalcols]; // created for 2D array which can stor
		
		for(int i=1; i<=totalrows; i++)  //1  //read the data from x1 Storing 
		{
			for(int j=0; j<totalcols; j++)   //0         i is rows     j is col 
			{
				logindata[i-1][j] = xlutil.getCellData("Sheet1", i, j);  //1, 0    //i-1  => because array index will start from "0"
			}
		}
		
		return logindata; // returning 2D array 
	}

	//DataProvider 2
	
	//DataProvider 3
	
}
