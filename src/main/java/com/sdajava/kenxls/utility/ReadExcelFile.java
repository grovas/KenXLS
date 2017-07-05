package com.sdajava.kenxls.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcelFile {

    // uncomment one and only one file to proceed
    private static final String FILE_NAME = "medella.xlsx";
    //private static final String FILE_NAME = "Stylowa2.xlsx";
    //private static final String FILE_NAME = "niezapominajka.xlsx";

    // 2 dimmension array holds data from excel table
    Object[][] data = null;

    public Object[][] readDataFromExcel() {
        final DataFormatter df = new DataFormatter();
        try {
            FileInputStream file = new FileInputStream(FileService.getFileIn());
            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            //Get first/desired sheet from the workbook - Arkusz 2
            XSSFSheet sheet = workbook.getSheetAt(0);

            //This function looks for an empty cells in sheet and fill them with 0.0 value
            sheet = EmptyCells.fillUpEmptyCells(sheet);

            int rownum = 0;
            int colnum;

            int rowcount = sheet.getLastRowNum()+1;
            int colcount = sheet.getRow(0).getLastCellNum();

            data = new Object[rowcount][colcount];

            for (Row row : sheet) {
                colnum = 0;
                for (Cell cell : row) {
                    data[rownum][colnum] = df.formatCellValue(cell);
                    colnum++;
                }
                rownum++;
            }
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}