package com.product.model.repository.Impl;

import com.product.model.bean.Product;
import com.product.model.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class ProductRepositoryImpl implements IProductRepository {


    static final Map<Integer,Product> productMap;

    static {
        productMap = new HashMap<>();
        productMap.put(1,new Product(1,"Phone",30000,"Strong","USA"));
        productMap.put(2,new Product(2,"Sim",300,"Medium","Viet Nam"));
        productMap.put(3,new Product(3,"Car",2000,"Very Good","France"));
        productMap.put(4,new Product(4,"Bicycle",1000,"Medium","USA"));
        productMap.put(5,new Product(5,"Pen",30000,"Hii","Viet Nam"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        List<Product> productList = findAll();
        int id = 0;
        if(productList.isEmpty()){
            id = 1;
        }else {
            id = productList.get(productList.size()-1).getId() + 1;
        }
        product.setId(id);
        productMap.put(id,product);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id,product);
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }

    @Override
    public List<Product> seachProduct(String name) {
        List<Product> list = findAll();
        List<Product> searchList = new ArrayList<>();
        for(Product product : list){
            if(product.getNameProduct().contains(name)){
                searchList.add(product);
            }
        }
        return searchList;
    }
}
