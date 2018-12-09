import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class Excel {
    public static final String xlsxPath = "./Test.xlsx";
    public void test()throws IOException, InvalidFormatException{
        Workbook workbook = WorkbookFactory.create(new File("C:/Users/NigaKolczan/Desktop/Test.xlsx"));
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
    }

}
