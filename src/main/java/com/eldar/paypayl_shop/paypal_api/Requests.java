package com.eldar.paypayl_shop.paypal_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class Requests {
    private final RestTemplate restTemplate;

    @Autowired
    public Requests(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public BearerToken getBearerTokenFromPaypal() {
        String url = "https://api.sandbox.paypal.com/v1/oauth2/token";

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("content-type", "application/x-www-form-urlencoded");
        headers.add("authorization", "Basic QWFxcGxxMVNwVy1LN1VHbldsN0VMZ21aTkgxM1h5MGFjelM5djhMTzdOc3JPazBrcnhwcDNvam5sX1U5Qi1yanVaSGVqZDFrSDZvYjhLOTY6RUU2SHlXRDgzM0dxOEZwS0QyUk5UamZZblU3WElXZVc0MTFxUDRGNTlPY3JIN2RKV3ZqR1J6dTdPSVl2aFY4RmhlV28waFN0SEo1aFV6Zkg=");

        HttpEntity<String> entity = new HttpEntity<>("grant_type=client_credentials", headers);

        return restTemplate.postForObject(url, entity, BearerToken.class);
    }
}
