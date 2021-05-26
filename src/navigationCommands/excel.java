package navigationCommands;     //package name

import java.io.File;
import java.io.FileInputStream;

//importing required statements used to retrieve data from excel sheet
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excel {
	
	//setting up the path to excel sheet
	static XSSFSheet excelsheet;
	static XSSFWorkbook ExcelWBook;
	
	public static void setExcelFile() throws Exception {
		
		String path ="C:\\Users\\Sindhuja\\workspace\\MiniProject\\src\\Excel\\project.xlsx";  //path of the excel sheet
		File src = new File(path);               //creating an object of file class             
		FileInputStream fis = new FileInputStream(src);          //creating an object for FileInputStream 
		ExcelWBook = new XSSFWorkbook(fis);
	}
	
	//Getting data from the excel sheet
	public static String getCellData(int i, int j) {	
		excelsheet = ExcelWBook.getSheetAt(0);            //Getting the first sheet          		
		String data = excelsheet.getRow(i).getCell(j).getStringCellValue();       //Getting the value of 'i' th row and 'j' th column from the excel sheet
		return data;                           //returns data
	}
}
