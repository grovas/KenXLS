package com.sdajava.kenxls.utility;

import com.sdajava.kenxls.model.DrugStore;
import com.sdajava.kenxls.model.Order;
import java.util.HashMap;
import java.util.Map;

/**
 * Class is responsible for conversion from 2 dimmension arrays to Map
 */

public class FromTableToMap {

    private ReadExcelFile readExcelFile = new ReadExcelFile();
    Object [][] data = readExcelFile.readDataFromExcel();

    /**
     *
     * @return Map with orders
     */
    public Map<DrugStore, Order> convertToMap () {
        Map<DrugStore, Order> orders = new HashMap<>();

        for (int row=1; row<data.length; row++) {
            // Get the count of columns based on length of first row
            for (int cell=1; cell<data[0].length; cell++) {
                //Do not add to Map empty orders
                    //Cast to proper type because we receive Object type data
                    DrugStore drugStore = new DrugStore((String) (data[0][cell]));
                    Order order = new Order((String) (data[row][0]), (String) (data[row][cell]));
                    orders.put(drugStore, order);
            }
        }
        return orders;
    }
}
