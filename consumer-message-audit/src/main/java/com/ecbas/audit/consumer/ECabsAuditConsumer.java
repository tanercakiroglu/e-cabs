package com.ecbas.audit.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan({"com.*"})
public class ECabsAuditConsumer {

    public static void main(String[] args) {
        SpringApplication.run(ECabsAuditConsumer.class, args);
    }

}
