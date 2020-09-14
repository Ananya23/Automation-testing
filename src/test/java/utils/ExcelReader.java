package utils;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	Workbook wb;
	
	public ExcelReader(String filenamewithLocation) {
		try {
	
		if(filenamewithLocation.endsWith(".xls")) {
			 wb = new HSSFWorkbook(new FileInputStream("C:\\Users\\ananya\\Desktop\\LTI\\Training\\SPECIALIZATION\\Book1.xls"));
		}
		else if(filenamewithLocation.endsWith(".xlsx"))
		{
			 wb = new XSSFWorkbook(new FileInputStream("C:\\Users\\ananya\\Desktop\\LTI\\Training\\SPECIALIZATION\\Book1.xlsx"));
		}
		else
		{
				System.out.println("Invalid file type");
		}
		  }
		catch(Exception e)
		{
			System.out.println("Err with file reading"+ e.getMessage());
		}
	}
	
	public String readCellData(String sheetName, int row, int col)
	{
		System.out.println(row+" "+col);
		String data = wb.getSheet(sheetName).getRow(row).getCell(col).toString();
		return data;
	}
	public int rowNumbers(String sheetName) {
		return wb.getSheet(sheetName).getLastRowNum()+1;
	}
	public int colNumbers(String sheetName) {
		return wb.getSheet(sheetName).getRow(0).getLastCellNum();
	}
}

