package tests;

import org.testng.annotations.DataProvider;
import utils.ExcelReader;

import java.io.IOException;

public class DataProviders {

    @DataProvider(name = "LoginData")
    public Object [][] getLoginData() throws IOException {
        String filePath = System.getProperty("user.dir") + "/src/test/resources/testData/LoginData.xlsx";
         Object [][] data = ExcelReader.getExcelData(filePath,"LoginCred");
         return data;
    }
}
