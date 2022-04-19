package com.sys.systemctl;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import javax.annotation.Resource;

@SpringBootApplication
public class SystemctlApplication {

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(SystemctlApplication.class);
        builder.headless(false)
               // .web(WebApplicationType.NONE)
               // .bannerMode(Banner.Mode.OFF)
                .run(args);
    }

}
