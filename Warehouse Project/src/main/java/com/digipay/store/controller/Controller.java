package com.digipay.store.controller;

import com.digipay.store.exception.BussinesException;
import com.digipay.store.models.Product;
import com.digipay.store.service.ProductService;

import java.util.Scanner;

public class Controller {
    ProductService productService = new ProductService();
    boolean running = true;

    public void programLoader() {
        while (running) {
            System.out.println("1. Save new Product");
            System.out.println("2. Load Products");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");

            Scanner in = new Scanner(System.in);
            String selectedAction = in.next();
            ProductLoader productLoader = new ProductLoader();
            switch (selectedAction) {
                case "1":
                    UserInputGetter getUserInputToSave = new UserInputGetter();
                    Product productToSave = getUserInputToSave.getUserInput();
                    try {
                        productService.register(productToSave);
                    } catch (BussinesException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "2":
                    try {
                        productLoader.loadProducts();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "3":
                    boolean updating = true;
                        try {
                            productLoader.loadProducts();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            break;
                        }
                        UserInputGetter getUserInputToUpdate = new UserInputGetter();
                        Product productToUpdate = getUserInputToUpdate.getUserInput();
                        System.out.println("Choose the product you want to update:");
                    while (updating) {
                        try {
                            productLoader.loadProducts();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            break;
                        }
                        while(!in.hasNextInt()){
                            System.out.println("Please enter a valid number ...");
                            in.next();
                        }
                        int productNumberToUpdate = in.nextInt() - 1;
                        ProductUpdater productUpdater = new ProductUpdater();
                        try {
                            productUpdater.updateProduct(productNumberToUpdate, productToUpdate);
                            updating = false;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case "4":
                    boolean deleting = true;
                    while (deleting) {
                        try {
                            productLoader.loadProducts();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            break;
                        }
                        System.out.println("Choose the product you want to delete:");
                        while(!in.hasNextInt()){
                            System.out.println("Please enter a valid number ...");
                            in.next();
                        }
                        int productNumberToRemove = in.nextInt() - 1;
                        ProductRemover productRemover = new ProductRemover();
                        try {
                            productRemover.removeProduct(productNumberToRemove);
                            deleting = false;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                default:
                    System.out.println("GOODBYE ...");
                    System.exit(0);
            }
        }
    }
}
