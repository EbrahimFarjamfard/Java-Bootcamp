package com.digipay.store.controller;

import com.digipay.store.exception.BussinesException;
import com.digipay.store.service.ProductService;
import com.digipay.store.models.Product;
public class ProductUpdater {
    ProductService productService = new ProductService();
    public void updateProduct(int productNumber, Product product) throws BussinesException {
        productService.updateProduct(productNumber, product);
    }
}
