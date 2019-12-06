package lotame.laptopurl;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Xlfile_Reader {
	private static HSSFSheet ExcelWSheet;
    private static HSSFWorkbook ExcelWBook;
    private static HSSFRow Row;
    private static HSSFCell Cell;
    
    public static void setExcelFile(String Path, String SheetName) throws Exception
    
    {
        // Open Excel File
        FileInputStream ExcelFile = new FileInputStream(Path);
        // Access the required testCase Sheet
        ExcelWBook = new HSSFWorkbook(ExcelFile);
        ExcelWSheet = ExcelWBook.getSheet(SheetName);
        
    }
    //To read test data from excel file
    public static String getCellData(int RowNum, int ColNum) throws Exception
    {
        try{
            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
            String CellData = Cell.getStringCellValue();
            return CellData;
            
        } catch(Exception e)
        
        {
            return"";
        }
        
    }
    // To Write in Excel Cell
    public static void setCellData(int Result, int RowNum, int ColNum) throws Exception
    {
        try
        {
            Row = ExcelWSheet.getRow(RowNum);
           Cell = Row.getCell(ColNum);
            if(Cell == null)
            {
                Cell = Row.createCell(ColNum);
                Cell.setCellValue(Result);
            }
            else
            {
                Cell.setCellValue(Result);
            }
            // Constant variable Test data path & test data file name
            FileOutputStream fileOut = new FileOutputStream("../Lotame-Url/src/test/java/lotame/laptopurl/Lotame_laptop_pages.xls");
            ExcelWBook.write(fileOut);
            fileOut.flush();
            fileOut.close();
        }catch(Exception e)
        {
            throw(e);
        }
    }
    
    
    public static void setCellData1(long Result, int RowNum, int ColNum) throws Exception
    {
        try
        {
            Row = ExcelWSheet.getRow(RowNum);
           Cell = Row.getCell(ColNum);
            if(Cell == null)
            {
                Cell = Row.createCell(ColNum);
                Cell.setCellValue(Result);
            }
            else
            {
                Cell.setCellValue(Result);
            }
            // Constant variable Test data path & test data file name
            FileOutputStream fileOut = new FileOutputStream("../Lotame-Url/src/test/java/Lotame/laptop_url/Lotame_laptop_pages.xls");
            ExcelWBook.write(fileOut);
            fileOut.flush();
            fileOut.close();
        }catch(Exception e)
        {
            throw(e);
        }
    }
    
    
    public static int getRowCount(String sheetName){
		int index = ExcelWBook.getSheetIndex(sheetName);
		if(index==-1)
			return 0;
		else{
			ExcelWSheet = ExcelWBook.getSheetAt(index);
		int number=ExcelWSheet.getLastRowNum()+1;
		return number;
		}
		
	}
    

    

	
	
}

