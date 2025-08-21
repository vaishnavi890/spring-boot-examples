package com.vaishnavi.practice.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


public class FoodOrderApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(FoodOrderApplication.class, args);
        System.out.println("🚀 Food Order Application Started Successfully...");
        System.out.println("🌐 Open: http://localhost:8080");
    }
}
