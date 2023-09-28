package Utilities;

import com.beust.jcommander.Parameters;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {

    @DataProvider(name = "LoginData")
    public Object[][] getData() throws IOException {

        String path = ".\\testData\\LoginData.xlsx";

        ExcelUtility excelUtility = new ExcelUtility(path);
        int totalRows = excelUtility.getRowCount("Sheet1");
        int totalCell = excelUtility.getCellCount("Sheet1",1);

        String[][] loginData = new String[totalRows][totalCell];
        for(int i =1; i<=totalRows; i++){
            for(int j=0; j<totalCell; j++){
                loginData[i-1][j] = excelUtility.getCellData("Sheet1",i,j);
            }
        }
        return loginData;
    }
}
