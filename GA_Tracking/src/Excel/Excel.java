package Excel;


import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Excel {
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
 /*   public static void setCellData(String Result, int RowNum, int ColNum) throws Exception
    {
        try
        {
            Row = ExcelWSheet.getRow(RowNum);
            Cell = Row.getCell(ColNum,Row.RETURN_BLANK_AS_NULL);
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
            FileOutputStream fileOut = new FileOutputStream("C://Users//Ahtishan//workspace//Indusind_Bank//src//testCase//IndusInd_Bank.xls");
            ExcelWBook.write(fileOut);
            fileOut.flush();
            fileOut.close();
        }catch(Exception e)
        {
            throw(e);
        }*/
    }
    
    

    

//}



