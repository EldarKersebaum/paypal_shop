package com.eldar.paypayl_shop;

import com.eldar.paypayl_shop.user.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@SpringBootApplication
@Import({MyConfig.class})
public class ApplicationController {

    private ObjectMapper mapper;

    public static void main(String[] args) {
        SpringApplication.run(ApplicationController.class, args);
    }

    @Autowired
    public ApplicationController(ObjectMapper mapper) {
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        this.mapper = mapper;
    }

    @RequestMapping("/user")
    String user() throws JsonProcessingException {
        return mapper.writeValueAsString(User.Son());
    }

    @RequestMapping("/user/bearer_token")
    String bearer_token() throws JsonProcessingException, IOException {
        return "";
    }

    @RequestMapping("/paypal_payment_success")
    String paymentSuccess() throws JsonProcessingException {
        //http://localhost:8080/paypal_payment_success?code=C21AAGHtXv7qDNgX4J1QyN2Yab9wB7yRYQl9WtpE637LVImjsgXERL7JponfW0YgM7v_0a74g-IyPmiN9lyDR2vX7fJxeVrWQ&scope=email%20openid%20profile

        return mapper.writeValueAsString(User.Son());
    }
}