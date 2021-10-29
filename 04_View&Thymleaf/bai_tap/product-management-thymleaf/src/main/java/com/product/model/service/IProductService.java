package com.product.model.service;

import com.product.model.bean.Product;
import com.product.model.repository.IProductRepository;

import java.util.List;

public interface IProductService extends IProductRepository {
    @Override
    List<Product> findAll();

    @Override
    void save(Product product);

    @Override
    Product findById(int id);

    @Override
    List<Product> seachProduct(String name);

    @Override
    void update(int id, Product product);

    @Override
    void remove(int id);
}
