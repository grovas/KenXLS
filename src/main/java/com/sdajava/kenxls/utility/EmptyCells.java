package com.sdajava.kenxls.utility;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;

/**
 * Class to handle with empty cells of xlsx files.
 *
 */
public class EmptyCells {
    /**
     *
     * @param sheet - get active sheet
     * @return sheet - and back sheet filled up with zeros against null cells
     * Iterator jumps over empty cells so we need to handle this situation
     *
     */
    public static XSSFSheet fillUpEmptyCells(XSSFSheet sheet){

        for (int r = 1; r < sheet.getLastRowNum()+1; r++){
            Row row = sheet.getRow(r);
            for (int c = 1; c < setupMaxColSize(sheet); c++) {
                // handle empty/null cell - if yes we set a numeric type and set '0'
                Cell cell = row.getCell(c, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
                if (cell == null) {
                    //First we create a cell
                    cell = row.createCell(c, Cell.CELL_TYPE_NUMERIC);
                    //Set value to '0'
                    cell.setCellValue(0);
                }
            }
        }
        return sheet;
    }

    /**
     *
     * @param sheet - get first row
     * @return int - max size of column in sheet
     * Without this operation we can't fill up all cells on every row
     */
    public static int setupMaxColSize (XSSFSheet sheet) {
        Row firstRow = sheet.getRow(0);
        return firstRow.getLastCellNum();
    }
}
