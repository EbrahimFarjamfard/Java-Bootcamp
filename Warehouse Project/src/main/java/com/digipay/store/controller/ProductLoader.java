package com.digipay.store.controller;

import com.digipay.store.exception.BussinesException;
import com.digipay.store.service.ProductService;


public class ProductLoader {
    ProductService productService = new ProductService();

    public void loadProducts() throws BussinesException {
            productService.loadProducts();
    }
}
