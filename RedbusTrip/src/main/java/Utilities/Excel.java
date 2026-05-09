package Utilities;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;


public class Excel {

    public static String[][] get(String filename) {
        String[][] dataTable = null;
        File file = new File(filename);
        try {
            FileInputStream xlfile = new FileInputStream(file);
            HSSFWorkbook xlwb = new HSSFWorkbook(xlfile);  // Fix 1: was "__xlwb__", used as "xlwb"
            HSSFSheet xlSheet = xlwb.getSheetAt(0);

            int numRows = xlSheet.getLastRowNum();          // Fix 2: removed +1, start from row index 1 below
            int numCols = xlSheet.getRow(0).getLastCellNum();

            dataTable = new String[numRows][numCols];       // Array sized for data rows only (no header)

            for (int i = 1; i <= numRows; i++) {            // Fix 3: i starts at 1 (skip header row)
                HSSFRow xlRow = xlSheet.getRow(i);
                for (int j = 0; j < numCols; j++) {
                    HSSFCell xlCell = xlRow.getCell(j);
                    dataTable[i - 1][j] = xlCell.toString(); // i-1 to write into 0-based array
                }
            }
        } catch (IOException e) {
            System.out.println("ERROR FILE HANDLING " + e.toString());
        }
        return dataTable;
    }

    @DataProvider(name = "ActualData")
    public static String[][] GetData() {
        return Utilities.Excel.get("D:\\Selenium Workspace\\Git\\RedbusTrip\\Test Data\\RedBus.xls");
    }
    
    @DataProvider(name = "ActualTrainData")
    public static String[][] GetTrainData() {
        return Utilities.Excel.get("D:\\Selenium Workspace\\Git\\RedbusTrip\\Test Data\\RedTrain.xls");
    }
}
