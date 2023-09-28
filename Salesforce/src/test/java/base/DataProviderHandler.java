package base;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import utils.ExcelData;


public class DataProviderHandler {
	public String excelFile;
	
	@DataProvider(name = "fetchData")
	public  String[][] fetchData() throws IOException {
		return ExcelData.readValue(excelFile);
	}	

}
