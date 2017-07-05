package com.sdajava.kenxls.model;

/**
 * POJO class
 */

public class DrugStore {

    private String storeName;
    private String address;

    public DrugStore(String name) {
        this.storeName = name;
    }

    public String getStoreName() {
        return storeName;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "DrugStore{" +
                "name='" + storeName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
