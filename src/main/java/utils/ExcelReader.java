package utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {

    public static Object[][] getExcelData(String path, String sheetName) throws IOException {
        Object[][] data = null;

        try {
            FileInputStream fis = new FileInputStream(path);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(sheetName);

            int rowCount = sheet.getPhysicalNumberOfRows();
            int colCount = sheet.getRow(0).getLastCellNum();

            data = new Object[rowCount - 1][colCount];

            for(int i=1;i<rowCount;i++){
                Row row = sheet.getRow(i);

                for (int j=0;j<colCount;j++){
                    Cell cell = row.getCell(j);
                    data[i-1][j] = cell.toString();
                }
            }

            workbook.close();
            fis.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
}
