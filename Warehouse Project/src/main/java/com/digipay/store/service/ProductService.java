package com.digipay.store.service;

import com.digipay.store.models.Commodity;
import com.digipay.store.repository.ProductRepository;

import static com.digipay.store.repository.ProductRepository.loadCategory;

public class ProductService {

    public static void serviceLoadCategory(){
        loadCategory();
    }
    public void saveProduct(Commodity commodity){
        ProductRepository productRepository = new ProductRepository();
        Commodity result = productRepository.findCommodityByBarcode(commodity.getBarcode());
        if(result == null) {
            productRepository.save(commodity);
        }
    }
}
