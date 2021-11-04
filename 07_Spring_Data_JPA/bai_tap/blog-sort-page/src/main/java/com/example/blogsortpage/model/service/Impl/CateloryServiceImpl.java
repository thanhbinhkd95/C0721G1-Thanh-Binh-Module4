package com.example.blogsortpage.model.service.Impl;

import com.example.blogsortpage.model.entity.Catelory;
import com.example.blogsortpage.model.repository.ICateloryRepository;
import com.example.blogsortpage.model.service.ICateloryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CateloryServiceImpl implements ICateloryService {

    @Autowired
    ICateloryRepository cateloryRepository;


    @Override
    public List<Catelory> findAll() {
        return cateloryRepository.findAll();
    }

    @Override
    public Catelory findById(Integer id) {
        return cateloryRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Catelory catelory) {
        cateloryRepository.save(catelory);
    }

    @Override
    public void update(Catelory catelory) {
        cateloryRepository.save(catelory);
    }

    @Override
    public void delete(Integer id) {
        cateloryRepository.deleteById(id);
    }
}
