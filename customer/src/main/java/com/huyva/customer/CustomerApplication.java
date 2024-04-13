package com.huyva.customer;

import com.huyva.base.utils.HashUtils;
import com.huyva.base.utils.JwtUtils;
import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;

@SpringBootApplication
@Log4j2
@EnableDiscoveryClient
public class CustomerApplication {

    @Autowired
    Environment environment;
    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }
    @EventListener(ApplicationReadyEvent.class)
    public void serverReady(){


        System.out.println("==================================================");
        System.out.println("|      CUSTOMER SERVICE SERVER IS READY       |");
        System.out.println("|        DEPLOY BY DIGITAL PLATFORM TEAM        |");
        System.out.println("==================================================");


        log.info("==================================================");
        log.info("|      CUSTOMER  SERVICE SERVER IS READY       |");
        log.info("|        DEPLOY BY DIGITAL PLATFORM TEAM         |");
        log.info("|                    STARTED                     |");
        log.info("==================================================");

        this.initData();


    }

    public void initData(){
        String privateKeyJWT = environment.getProperty("jwt.secret", "vuanhyhuy1993100292");
        Long expiredTimeJwt = environment.getProperty("jwt.time-out" , Long.class, 360000L);

        JwtUtils.loadData(expiredTimeJwt, privateKeyJWT);

        HashUtils.setHashids(privateKeyJWT);
    }
}
