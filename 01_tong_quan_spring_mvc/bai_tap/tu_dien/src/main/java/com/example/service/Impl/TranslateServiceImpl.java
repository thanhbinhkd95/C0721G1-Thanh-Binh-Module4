package com.example.service.Impl;

import com.example.service.ITranslateService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class TranslateServiceImpl implements ITranslateService {
    @Override
    public Map<String, String> storeDictionary() {
        Map<String,String> mapDic = new HashMap<>();
        mapDic.put("Hello","Xin Chao");
        mapDic.put("Good Morning","Chao Buoi Sang");
        mapDic.put("Thanks","Cam On");
        mapDic.put("Book","Quyen Sach");
        mapDic.put("Teacher","Giao Vien");

        return mapDic;
    }
}
