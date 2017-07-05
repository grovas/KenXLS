package com.sdajava.kenxls.utility;

import java.io.*;
import java.util.Map;

import com.sdajava.kenxls.model.DrugStore;
import com.sdajava.kenxls.model.Order;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelFile {

    /**
     *
     * @param order - map read from xlsx file
     *              Function write to XLSX file data into Zamówienia sheet.
     *              Sheet contain three columns:
     *              - nazwa apteki
     *              - nazwa leku
     *              - ilość leku zamówiona
     *              Orders with non value of quantity are omitted
     */
    public static void writeDataToExcelSheetZamowienie(Map order) {
        Map<DrugStore, Order> orderMap = order;

        try {
            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook();

            XSSFSheet sheet = workbook.createSheet("Zamówienie");

            final XSSFRow[] row = {sheet.createRow(0)};
            final int[] rowNumber = {1};
            //Headline
            row[0].createCell(0).setCellValue("Nazwa apteki");
            row[0].createCell(1).setCellValue("Nazwa preparatu");
            row[0].createCell(2).setCellValue("Ilość");

            orderMap.forEach((k,v) -> {

                if (!v.getQuantity().equals("0")) {

                    Row r = sheet.createRow(rowNumber[0]);
                    r.createCell(0).setCellValue(k.getStoreName());
                    r.createCell(1).setCellValue(v.getDrugName());
                    r.createCell(2).setCellValue(v.getQuantity());
                    rowNumber[0]++;
                }
            });

            workbook = FormatOutputStyle.backgroundCellColor(sheet, workbook, IndexedColors.GREY_25_PERCENT);

            FileOutputStream fileOut = new FileOutputStream(FileService.getFileOut());
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
