package com.digipay.store;

import com.digipay.store.models.Commodity;
import com.digipay.store.service.ProductService;

import java.util.Scanner;

import static com.digipay.store.service.ProductService.serviceLoadCategory;

public class Main {
    public static void main(String[] args) {
        boolean running = true;
        while(running) {
            System.out.println("If You Want to Add a Product, Press 1, Press Anything Else to Exit ...");
            Scanner in = new Scanner(System.in);
            String selectNumber = in.next();
            if (selectNumber.equals("1") != true) {
                running = false;
                System.out.println("GOODBYE ...");
                System.exit(0);
            }
            System.out.println("Please Enter Your Product Information:");
            System.out.println("Enter Product Name: ");
            String productName = in.next();
            System.out.println("Enter Product Barcode: ");
            String productBarcode = in.next();
            boolean selectCategory = false;
            String productCategory = new String();
            System.out.println("Select Product Category: ");
            while (!selectCategory) {
                serviceLoadCategory();
                String categoryNumber = in.next();
                switch (categoryNumber) {
                    case "1":
                        productCategory = "Electronics";
                        selectCategory = true;
                        break;
                    case "2":
                        productCategory = "Home";
                        selectCategory = true;
                        break;
                    case "3":
                        productCategory = "Clothing";
                        selectCategory = true;
                        break;
                    case "4":
                        productCategory = "Accessory";
                        selectCategory = true;
                        break;
                    case "exit":
                        System.out.println("Your Product did not Save ...");
                        System.exit(0);
                    default:
                        System.out.println( "Please Select a Category or Type" + "exit" + "to Exit the Program ..." );
                        selectCategory = false;
                }
            }

            // TODO: validate input data
            Commodity commodity = new Commodity();
            commodity.setName(productName);
            commodity.setCategory(productCategory);
            commodity.setBarcode(productBarcode);

            ProductService productService = new ProductService();
            productService.saveProduct(commodity);
        }




    }

}