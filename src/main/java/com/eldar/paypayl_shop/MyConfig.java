package com.eldar.paypayl_shop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("com.eldar.paypal_shop")
public class MyConfig {
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
