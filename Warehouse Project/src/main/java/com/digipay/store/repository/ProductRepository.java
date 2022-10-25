package com.digipay.store.repository;

import com.digipay.store.exception.BussinesException;
import com.digipay.store.models.Product;


import java.util.ArrayList;

public class ProductRepository {
    private ProductRepository() {
    }

    ;
    private static volatile ProductRepository productRepositoryInstance;

    private ArrayList<Product> productList = new ArrayList<>();

    public void loadProducts() throws BussinesException {
        if (productList.isEmpty()) {
            throw new BussinesException("\n No product in the Database ! \n");
        } else {
            System.out.println("\n");
            System.out.println("Products in the Database: [Barcode, Name, Category]");
            for (int i = 0; i < productList.size(); i++) {
                Product product = productList.get(i);
                int productNumber = i + 1;
                System.out.println("\t" + productNumber + ". " + showProduct(product));
            }
            System.out.println("\n");
        }
    }

    public void updateProduct(int productNumber, Product product) throws BussinesException{
        try{
            productList.set(productNumber, product);
        } catch (Exception e) {
            throw new BussinesException("*** Please enter a valid product Number ... ");
        }
    }

    private String showProduct(Product product) {
        String result = product.getBarcode() + " " + product.getName() + " " + product.getCategory();
        return result;
    }

    public void removeProduct(int productNumber) throws BussinesException {
        try {
            productList.remove(productNumber);
        } catch (Exception e) {
            throw new BussinesException("*** Please enter a valid product Number ... ");
        }
    }

    private enum Category {
        ELECTRONICS, HOME, CLOTHING, ACCESSORY
    }

    public static ProductRepository getProductRepository() {
        if (productRepositoryInstance == null) {
            synchronized (ProductRepository.class) {
                if (productRepositoryInstance == null) {
                    productRepositoryInstance = new ProductRepository();
                }
            }
        }
        return productRepositoryInstance;
    }

    public void loadCategory() {
        int i = 1;
        for (Category item : Category.values()) {
            System.out.println(i + "- " + item);
            i++;
        }
    }

    public void saveProduct(Product product) {
        productList.add(product);
        System.out.println("Your product is saved");
    }

    public Product findCommodityByBarcode(String barcode) {
        for (Product product : productList) {
            if (product.getBarcode().equals(barcode)) {
                return product;
            }
        }
        return null;
    }


}
