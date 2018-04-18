package com.eldar.paypayl_shop;

import com.eldar.paypayl_shop.paypal_api.AuthCode;
import com.eldar.paypayl_shop.paypal_api.BearerToken;
import com.eldar.paypayl_shop.paypal_api.Requests;
import com.eldar.paypayl_shop.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import rest_test.Quote;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@RestController
@SpringBootApplication
@Import({MyConfig.class})
public class ApplicationController {

    private Requests requests;
    private BearerToken bearerToken;
    private LocalDateTime timestampBearerTokenReceived;

    @Autowired
    public ApplicationController(Requests requests) {
        this.requests = requests;
    }

    public static void main(String[] args) {
        SpringApplication.run(ApplicationController.class, args);
    }

    @RequestMapping("/user")
    User user(HttpSession httpSession) {
        return (User) httpSession.getAttribute(User.class.toString());
    }

    @RequestMapping("/test")
    Quote test() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
    }

    @RequestMapping("/bearer_token")
    BearerToken bearer_token() {
        if (bearerToken == null || bearerTokenToOld()) {
            timestampBearerTokenReceived = LocalDateTime.now();
            bearerToken = requests.getBearerTokenFromPaypal();
        }
        return bearerToken;
    }

    private boolean bearerTokenToOld() {
        return timestampBearerTokenReceived.plusSeconds(bearerToken.getExpires_in() * 100 / 95).isBefore(LocalDateTime.now());
    }

    @RequestMapping("/paypal_payment_success")
    User paymentSuccess(@RequestParam(value = "code") String authCode,
                        @RequestParam(value = "scope") String scope,
                        HttpSession httpSession) {
        User user = new User(new AuthCode(authCode, scope));


        httpSession.setAttribute(User.class.toString(), user);
        return (User) httpSession.getAttribute(User.class.toString());
    }

}