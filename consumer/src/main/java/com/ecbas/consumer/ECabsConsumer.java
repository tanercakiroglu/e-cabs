package com.ecbas.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.*"})
public class ECabsConsumer {

    public static void main(String[] args) {
        SpringApplication.run(ECabsConsumer.class, args);
    }

}
