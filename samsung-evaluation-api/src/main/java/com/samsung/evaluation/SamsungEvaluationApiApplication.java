package com.samsung.evaluation;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.samsung.evaluation.controller")
public class SamsungEvaluationApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SamsungEvaluationApiApplication.class, args);
    }
}
