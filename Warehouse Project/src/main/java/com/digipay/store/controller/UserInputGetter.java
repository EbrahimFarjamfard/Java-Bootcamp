package com.digipay.store.controller;

import com.digipay.store.exception.BussinesException;
import com.digipay.store.models.Product;
import com.digipay.store.service.ProductService;

import java.util.Scanner;

public class UserInputGetter {
    ProductService productService = new ProductService();


    public Product getUserInput() {
        Scanner in = new Scanner(System.in);
        Product product = new Product();
        System.out.println("Please Enter Your Product Information:");
        System.out.println("Enter Product Barcode: ");
        String productBarcode = in.next();
        product.setBarcode(productBarcode);
        try {
            productService.serviceCheckBarcode(product);
        } catch (BussinesException e) {
            System.out.println(e.getMessage());
            return null;
        }
        System.out.println("Enter Product Name: ");
        String productName = in.next();
        boolean selectCategory = false;
        String productCategory = new String();
        System.out.println("Select Product Category: ");
        while (!selectCategory) {
            productService.serviceLoadCategory();
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
                    System.out.println("Please Select a Category or Type" + "exit" + "to Exit the Program ...");
                    selectCategory = false;
            }
        }
        product.setName(productName);
        product.setCategory(productCategory);
        return product;
    }
}
