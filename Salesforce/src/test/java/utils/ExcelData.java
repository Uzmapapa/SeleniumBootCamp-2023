package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {

	public static String[][] readValue(String fileName) {
		String[][] data = null;
		try {
			XSSFWorkbook workBook = new XSSFWorkbook("./data/" + fileName + ".xlsx");
			XSSFSheet sheet = workBook.getSheetAt(0);
			XSSFRow fisrtRow = sheet.getRow(0);
			int lastRowNum = sheet.getLastRowNum();
			short lastCellNum = fisrtRow.getLastCellNum();
			data = new String[lastRowNum][lastCellNum];
			for (int row = 1; row <= lastRowNum; row++) {
				for (int col = 0; col < lastCellNum; col++) {
					data[row - 1][col] = sheet.getRow(row).getCell(col).getStringCellValue();
				}
			}
			workBook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

}
