
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class writeToExcelv2 {

    //private String FILE_NAME = "C:\\Users\\garre\\eclipse-workspace\\CSTool\\src\\"+ ;

   writeToExcelv2(int normal,int bots,int background, int totalFlows,String backgroundSt,String normalSt,String botNetst,String type,String fileType){
	   String FILE_NAME = "C:\\Users\\garre\\eclipse-workspace\\CSTool\\src\\"+fileType ;

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("sheet1");
        Object[][] datatypes = {{type,"Total"},
                {backgroundSt,normal},
                {normalSt,bots},{botNetst,background},{"totalFlows",totalFlows}
        };

        int rowNum = 0;
        System.out.println("Creating excel");

        for (Object[] datatype : datatypes) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (Object field : datatype) {
                Cell cell = row.createCell(colNum++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }

        try {
            FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Done");
    }
}