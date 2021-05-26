package navigationCommands;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excel {
	
	static XSSFSheet excelsheet;
	static XSSFWorkbook ExcelWBook;
	
	public static void setExcelFile() throws Exception {
		
		String path ="C:\\Users\\Sindhuja\\workspace\\MiniProject\\src\\Excel\\project.xlsx"; 
		File src = new File(path);                                
		FileInputStream fis = new FileInputStream(src);           
		ExcelWBook = new XSSFWorkbook(fis);
	}
	
	public static String getCellData(int i, int j) {	
		excelsheet = ExcelWBook.getSheetAt(0);                      		
		String data = excelsheet.getRow(i).getCell(j).getStringCellValue(); 
		return data;                                             		
	}
}
