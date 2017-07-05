package com.sdajava.kenxls.model;

import java.io.StringReader;

/**
 * Class to build order objects
 */
public class Order {

    private int bloz;
    private String drugName;
    private String quantity;

    public Order(String drugName, String quantity) {
        this.drugName = drugName;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "drugName='" + drugName + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    public String getDrugName() {
        return drugName;
    }

    public String getQuantity() {
        return quantity;
    }
}
