package com.sdajava.kenxls.view;

import com.sdajava.kenxls.model.DrugStore;
import com.sdajava.kenxls.model.Order;

import java.util.Map;

/**
 * Different methods to print set of data
 */
public class PrintOutConsole {
    // example for medella file

    /**
     *
     * @param order - map of orders when key is drugStore and value order
     *              Method print out collection: DrugName - DrugStore - Quantity
     */
    public static void collectionDrugNameAndQtyByDrugStore (Map order) {
        Map<DrugStore, Order> orderMap = order;

        orderMap.forEach((k,v) -> {
            if(v.getDrugName().equals("Hepatil tabl. 0,15 g 40 tabl.") && v.getQuantity() != "0.0") {
                System.out.println("Zestawienie dla \"Hepatil tabl. 0,15 g 40 tabl.\":"
                                    + " DrugStore - " + k.getStoreName()
                                    + " ilość leku: " + v.getQuantity());
            }
        });
    }

    /**
     *
     * @param order - map of orders when key is drugStore and value order
     *              Method print out collection: DrugStore - DrugName - Quantity
     */
    public static void collectionDrugStoreAndDrugNameByQty (Map order) {
        Map<DrugStore, Order> orderMap = order;

        orderMap.forEach((k,v) -> {
            if(k.getStoreName().equals("OPOLE") && v.getQuantity() != "0.0"){
                System.out.println("Zamówienia dla \"OPOLE\":"
                                    + " Drug " + v.getDrugName()
                                    + " Ilość " + v.getQuantity());
            }
        });
    }
    // example output for niezapominajka
    /**
     *
     * @param order - map of orders when key is drugStore and value order
     *              Method print out collection: DrugName - DrugStore - Quantity
     */
    public static void collectionDrugNameAndQtyByDrugStoreN (Map order) {
        Map<DrugStore, Order> orderMap = order;

        orderMap.forEach((k,v) -> {
            if(v.getDrugName().equals("Aspifox 0,15 x 60 tabl.\n") && v.getQuantity() != "0.0") {
                System.out.println("Zestawienie dla \"Aspifox 0,15 x 60 tabl.\n\":"
                                    + " DrugStore - " + k.getStoreName()
                                    + " ilość leku: " + v.getQuantity());
            }
        });
    }

    /**
     *
     * @param order - map of orders when key is drugStore and value order
     *              Method print out collection: DrugStore - DrugName - Quantity
     */
    public static void collectionDrugStoreAndDrugNameByQtyN (Map order) {
        Map<DrugStore, Order> orderMap = order;

        orderMap.forEach((k,v) -> {
            if(k.getStoreName().equals("os. Przy Arce 1 Kraków\n") && v.getQuantity() != "0.0"){
                System.out.println("Zamówienia dla \"os. Przy Arce 1 Kraków\n\":"
                                    + " Drug " + v.getDrugName()
                                    + " Ilość " + v.getQuantity());
            }
        });
    }
    // example output for Stylowa2
    public static void collectionDrugNameAndQtyByDrugStoreS (Map order) {
        Map<DrugStore, Order> orderMap = order;

        orderMap.forEach((k,v) -> {
            if(v.getDrugName().equals("Hepatil tabl. 0,15 g 80 tabl.\n") && v.getQuantity() != "0.0") {
                System.out.println("Zestawienie dla \"Hepatil tabl. 0,15 g 80 tabl.\n\":"
                                  + " DrugStore - " + k.getStoreName()
                                  + " ilość leku: " + v.getQuantity());
            }
        });
    }

    /**
     *
     * @param order - map of orders when key is drugStore and value order
     *              Method print out collection: DrugStore - DrugName - Quantity
     */
    public static void collectionDrugStoreAndDrugNameByQtyS (Map order) {
        Map<DrugStore, Order> orderMap = order;

        orderMap.forEach((k,v) -> {
            if(k.getStoreName().equals("P2") && v.getQuantity() != "0.0"){
                System.out.println("Zamówienia dla \"P2\":"
                                    + " Drug " + v.getDrugName()
                                    + " Ilość " + v.getQuantity());
            }
        });
    }

}
