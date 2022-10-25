package com.digipay.store.controller;

import com.digipay.store.exception.BussinesException;
import com.digipay.store.service.ProductService;

public class ProductRemover {
    ProductService productService = new ProductService();
    public void removeProduct(int productNumber) throws BussinesException {
        productService.removeProduct(productNumber) ;
    }
}
