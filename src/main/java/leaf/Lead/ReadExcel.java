package leaf.Lead;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	public Object[][] fetchData(String fileName) throws IOException {
		//Open the workbook
		XSSFWorkbook wbook = new XSSFWorkbook("./data/"+fileName+".xlsx") ;
		//Go to the Sheet
		XSSFSheet sheet = wbook.getSheetAt(0); //wbook.getSheetAt();
		//Identify the Row
		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[rowCount][colCount];
		//Read the Data
		for (int i = 1; i <= rowCount; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < colCount; j++) {
				XSSFCell cell = row.getCell(j);
				data[i-1][j] = cell.getStringCellValue();
				//Print data
			}
		}
		wbook.close();
		return data;
	}




}
