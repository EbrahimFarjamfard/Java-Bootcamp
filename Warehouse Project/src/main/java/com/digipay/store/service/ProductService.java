package com.digipay.store.service;

import com.digipay.store.exception.BussinesException;
import com.digipay.store.models.Product;
import com.digipay.store.repository.ProductRepository;



public class ProductService extends ServiceManager {
    ProductRepository productRepository = ProductRepository.getProductRepository();

    public void loadProducts() throws BussinesException{
        productRepository.loadProducts();
    }

    @Override
    public void saveProduct(Product product) throws BussinesException {
        productRepository.saveProduct(product);
    }
    public void serviceCheckBarcode(Product product) throws BussinesException{
        Product result = productRepository.findCommodityByBarcode(product.getBarcode());
        if (result != null) throw new BussinesException("The Product is already exist in the Database");
    }
    public void serviceLoadCategory() {
        productRepository.loadCategory();
    }
    public void updateProduct(int productNumber, Product product) throws BussinesException{
        productRepository.updateProduct(productNumber, product);
    }
    public void removeProduct(int productNumber) throws BussinesException{
        productRepository.removeProduct(productNumber);
    }

}
