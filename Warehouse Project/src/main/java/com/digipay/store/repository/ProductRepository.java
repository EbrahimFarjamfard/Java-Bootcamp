package com.digipay.store.repository;

import com.digipay.store.models.Commodity;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    enum Category {
        ELECTRONICS, HOME, CLOTHING, ACCESSORY
    }
    ArrayList<Commodity> commodityList = new ArrayList<>();

    public static void loadCategory(){
        int i = 1;
        for (Category item : Category.values()){
            System.out.println(i+"- "+item);
            i++;
        }
    }
    public void save(Commodity commodity) {
        commodityList.add(commodity);
        for (Commodity item : commodityList) {
            System.out.println("Your Product is Saved With the Name: " + item.getName() + ", Barcode:  " + item.getBarcode() + ", in Category: " + item.getCategory());

        }

    }

    public Commodity findCommodityByBarcode(String barcode) {
        //Database

        for (Commodity commodity : commodityList) {
            if (commodity.getBarcode().equals(barcode)) {
                return commodity;
            }
        }
        return null;

    }
}
