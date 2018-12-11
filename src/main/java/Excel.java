import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class Excel {
    Workbook wb;
    public static final String xlsxPath = "./Test.xls";

    public void checkExists()throws IOException{
        File file = new File("C:/Test.xls");
        Boolean exists = file.exists();
        if(!exists){
            file.createNewFile();
            wb = new XSSFWorkbook();
        }
    }
    public String test()throws IOException, InvalidFormatException{
        Workbook workbook = WorkbookFactory.create(new File("C://Test.xls"));
        System.out.println("oto jest: "+ workbook.getNumberOfSheets()+" stron");

        Iterator<Sheet> sheetIterator = workbook.sheetIterator();
        System.out.println("zbieram kartki iteratorem");
        while(sheetIterator.hasNext()){
            Sheet sheet = sheetIterator.next();
            System.out.println("=> "+sheet.getSheetName());
            Sheet sheet1 = workbook.getSheetAt(0);
            DataFormatter dataFormatter = new DataFormatter();
            System.out.println("\n\nIteruje rzedy i kolumny");
            Iterator<Row> rowIterator = sheet.rowIterator();
            while (rowIterator.hasNext()){
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    String cellValue = dataFormatter.formatCellValue(cell);
                    System.out.println(cellValue+"\t");
                }
            }
            workbook.close();
        }
        return null;
    }

}
