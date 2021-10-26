package com.example.service.Impl;

import com.example.service.IConvertService;
import org.springframework.stereotype.Service;

@Service
public class ConvertServiceImpl implements IConvertService {
    @Override
    public int converUSD(int usd) {
        int vnd = usd * 23000;
        return vnd;
    }
}
