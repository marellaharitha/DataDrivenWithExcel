package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public static XSSFWorkbook workbook;
	public static XSSFSheet worksheet;
	public static org.apache.poi.ss.usermodel.Cell Cell;
	public static FileInputStream fis=null;
	public static FileOutputStream fileOut;
	public static String cellData = "";
	public static DataFormatter formatter;

	public static XSSFRow Row;

	public static String Path_TestData = "";
	public static String path = "";
	public static int rowcount;

	public static XSSFWorkbook setExcelFile(String Path) throws Exception {
		try {
			
			Path_TestData = Path;
			fis = new FileInputStream(Path);
			System.out.println("Total file size to read (in bytes) : "+ fis.available());
			workbook = new XSSFWorkbook(fis);

		} catch (Exception e) {
			
			e.printStackTrace();
			

		}
		return workbook;
	}

	public static String getCellData(int RowNum, int ColNum, String SheetName) throws Exception {
		try {
			setExcelFile("D:\\workspace\\SeleniumProject1\\src\\testData\\Login.xlsx");
			worksheet = workbook.getSheet(SheetName);
		
			formatter = new DataFormatter();
			String CellData = formatter.formatCellValue(worksheet.getRow(RowNum).getCell(ColNum));
			fis.close();
			return CellData;
			
			
			
		} catch (Exception e) {
			throw (e);
		}

	}

	public static int getRowCount(String SheetName) {
		int rowcount = 0;
		try {
			XSSFSheet sheet = workbook.getSheet(SheetName);
			rowcount =sheet.getPhysicalNumberOfRows();
			/*System.out.println("Row Count-->"+rowcount);*/
		} catch (Exception e) {

		}
		return rowcount;
	}

	public static int getRowContains(String sTestCaseName, int colNum, String SheetName) throws Exception {
		int iRowNum = 0;
		try {
			// ExcelWSheet = ExcelWBook.getSheet(SheetName);
			int rowCount = ExcelUtility.getRowCount(SheetName);
			for (; iRowNum < rowCount; iRowNum++) {
				if (ExcelUtility.getCellData(iRowNum, colNum, SheetName).isEmpty()) {
					break;
				}
			}
		} catch (Exception e) {

		}
		return iRowNum;
	}

	/*
	 * public static int getTestStepsCount(String SheetName, String sTesCaseID,
	 * int iTestCaseStart) throws Exception{ try { for(int
	 * i=iTestCaseStart;i<=ExcelUtilitys.getRowCount(SheetName);i++){
	 * if(!sTestCaseID.equals(ExcelUtilitys.getCellData(i,
	 * Constants.Col_TestCaseID, SheetName))){ int number = i; return number; }
	 * } worksheet = workbook.getSheet(SheetName); int
	 * number=worksheet.getLastRowNum()+1; return number; } catch (Exception e){
	 * 
	 * } }
	 */
	public static int setCellData(String Result,int rowcount,int ColNum, String SheetName) throws Exception {
		try {

			// create an object of Workbook and pass the FileInputStream object
			// into it to create a pipeline between the sheet and eclipse.

			 FileInputStream fis = new FileInputStream(Path_TestData);
			 XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(SheetName);
			//int rowcount =sheet.getPhysicalNumberOfRows();
			
			System.out.println("Row Count-setCellData-->"+rowcount);
		
			int iNum=rowcount++;
			XSSFRow row = sheet.createRow(iNum);
			 XSSFCell cell = row.createCell(ColNum);
			
		
			 cell.setCellValue(Result);
			 if (Result instanceof String) {
	             cell.setCellValue((String) Result);
			 }

			
			CellStyle cs = workbook.createCellStyle();
		    cs.setWrapText(true);
		    cell.setCellStyle(cs);

			
		    fis.close();
			 FileOutputStream fos = new FileOutputStream(Path_TestData);
			 workbook.write(fos);
			 fos.close();
			
			// fos.close();

		} catch (Exception e) {

		}
		return rowcount;


}
}
