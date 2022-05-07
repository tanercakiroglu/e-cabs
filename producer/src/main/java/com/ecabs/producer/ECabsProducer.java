package com.ecabs.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.*"})
public class ECabsProducer {

    public static void main(String[] args) {
        SpringApplication.run(ECabsProducer.class, args);
    }

}
