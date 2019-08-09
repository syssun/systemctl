package com.sys.systemctl;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SystemctlApplication {

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(SystemctlApplication.class);
        //SpringApplication.run(SystemctlApplication.class, args);
        builder.headless(false)
               // .web(WebApplicationType.NONE)
               // .bannerMode(Banner.Mode.OFF)
                .run(args);
    }

}
