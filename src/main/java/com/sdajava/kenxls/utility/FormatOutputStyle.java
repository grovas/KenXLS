package com.sdajava.kenxls.utility;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FormatOutputStyle {

    public static XSSFWorkbook backgroundCellColor(XSSFSheet sheet, XSSFWorkbook workbook, IndexedColors FGcolor) {

        // Setup columns width to autosize
        for (int i =0; i<3; i++) {
            sheet.autoSizeColumn(i);
        }

        // Added background color -- GREY_25_PERCENT
        for (Row r : sheet) {
            for (Cell c : r) {
                if (c.getColumnIndex() == 0 && c.getRowIndex() != 0) {
                    XSSFCellStyle style = workbook.createCellStyle();
                    style.setFillForegroundColor(FGcolor.getIndex());
                    style.setFillPattern(CellStyle.SOLID_FOREGROUND);
                    c.setCellStyle(style);
                }
            }
        }
        return workbook;
    }
}
