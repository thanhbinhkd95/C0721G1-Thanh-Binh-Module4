package com.example.borrowbook.aop.config;

import com.example.borrowbook.aop.AopBorrowBook;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class AOPConfig {
    @Bean
    public AopBorrowBook config(){
        return new AopBorrowBook();
    }
}
