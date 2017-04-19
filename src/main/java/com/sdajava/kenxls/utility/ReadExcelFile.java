package com.sdajava.kenxls.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcelFile {

    //private static final String FILE_NAME = "medella.xlsx";
    //private static final String FILE_NAME = "Stylowa2.xlsx";
    private static final String FILE_NAME = "niezapominajka.xlsx";

    public static void main(String ar[]) {
        ReadExcelFile rw = new ReadExcelFile();
        rw.readDataFromExcel();

    }
    // 2 dimmension array holds data from excel table
    Object[][] data = null;

    /**
     *
     * @return reference to excel file
     * @throws FileNotFoundException
     */
    public static File getFile() throws FileNotFoundException {
        File file = new File(FILE_NAME);
        return new File(file.getAbsolutePath());
    }

    public Object[][] readDataFromExcel() {
        final DataFormatter df = new DataFormatter();
        try {

            FileInputStream file = new FileInputStream(getFile());
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