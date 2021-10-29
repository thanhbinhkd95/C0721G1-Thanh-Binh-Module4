package com.practices.service.Impl;

import com.practices.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements ICalculatorService {
    @Override
    public double calculator(double numberone, double numbertwo, String calculator) {
        double result = 0;
        switch (calculator){
            case "Addition(+)" :
                result = numberone + numbertwo;
                break;
            case "Subtraction(-)" :
                result = numberone - numbertwo;
                break;
            case "Multiplication(X)" :
                result = numberone * numbertwo;
                break;
            case "Division(/)" :
                if(numbertwo != 0){
                    result = numberone / numbertwo;
                }else {
                    throw new ArithmeticException();
                }
                break;
        }
        return result;
    }
}
