package com.sdajava.kenxls;

import com.sdajava.kenxls.model.DrugStore;
import com.sdajava.kenxls.model.Order;
import com.sdajava.kenxls.utility.FromTableToMap;
import com.sdajava.kenxls.view.PrintOutConsole;

import java.io.*;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;

/**
 * Klasa startowa -
 */
public class App {

    public static void main(String[] args) throws IOException {

        FromTableToMap fromTableToMap = new FromTableToMap();
        Map<DrugStore, Order> orderMap = fromTableToMap.convertToMap();

        // below some print out for test collection
        PrintOutConsole.collectionDrugStoreAndDrugNameByQty(orderMap);
        PrintOutConsole.collectionDrugStoreAndDrugNameByQtyN(orderMap);
        PrintOutConsole.collectionDrugStoreAndDrugNameByQtyS(orderMap);

        PrintOutConsole.collectionDrugNameAndQtyByDrugStore(orderMap);
        PrintOutConsole.collectionDrugNameAndQtyByDrugStoreN(orderMap);
        PrintOutConsole.collectionDrugNameAndQtyByDrugStoreS(orderMap);
    }
}
