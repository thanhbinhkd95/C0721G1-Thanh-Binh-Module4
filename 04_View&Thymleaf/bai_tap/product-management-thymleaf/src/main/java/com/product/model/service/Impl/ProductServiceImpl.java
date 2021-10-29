package com.product.model.service.Impl;

import com.product.model.bean.Product;
import com.product.model.repository.IProductRepository;
import com.product.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Qualifier("productRepositoryImpl")
    @Autowired
    IProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> seachProduct(String name) {
        return productRepository.seachProduct(name);
    }

    @Override
    public void update(int id, Product product) {
        productRepository.update(id,product);
    }

    @Override
    public void remove(int id) {
        productRepository.remove(id);
    }
}
