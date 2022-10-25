package com.digipay.store.service;
import com.digipay.store.exception.BussinesException;
import com.digipay.store.models.Product;

public abstract class ServiceManager {
    LocationValidation locationCheck = new LocationCheck();
    QualityValidation qualityCheck = new QualityCheck();


    public final void register(Product product) throws BussinesException {
        locationCheck.checkLocation();
        qualityCheck.checkQuality();
        saveProduct(product);

    }
    public abstract void saveProduct(Product product) throws BussinesException;
}

