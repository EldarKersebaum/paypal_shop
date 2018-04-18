package com.eldar.paypayl_shop.paypal_api;

import com.eldar.paypayl_shop.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class Requests {
    private final RestTemplate restTemplate;
    private final String baseUrl = "https://api.sandbox.paypal.com";

    @Autowired
    public Requests(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ClientCredentiels getClientCredentiels() {
        String url = this.baseUrl + "/v1/oauth2/token";
        HttpEntity<String> entity = new HttpEntity<>("grant_type=client_credentials", defaultHeaders());

        return restTemplate.postForObject(url, entity, ClientCredentiels.class);
    }

    public AccessToken getAccessToken(String authorization_code) {
        String url = this.baseUrl + "/v1/identity/openidconnect/tokenservice";
        HttpEntity<String> entity = new HttpEntity<>("grant_type=authorization_code&code=" + authorization_code,
                defaultHeaders());

        return restTemplate.postForObject(url, entity, AccessToken.class);
    }

    public User loadUserInformation(AccessToken accessToken) {
        String url = this.baseUrl + "/v1/oauth2/token/userinfo?schema=openid";
        ResponseEntity<UserInformation> responseEntity = restTemplate.exchange(url,
                HttpMethod.GET,
                new HttpEntity<>(loadUserInformationHeaders(accessToken)),
                UserInformation.class);
        UserInformation userInformation = responseEntity.getBody();
        return new User(userInformation);
    }

    private HttpHeaders defaultHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("content-type", "application/x-www-form-urlencoded");
        headers.add("authorization", "Basic QWFxcGxxMVNwVy1LN1VHbldsN0VMZ21aTkgxM1h5MGFjelM5djhMTzdOc3JPazBrcnhwcDNvam5sX1U5Qi1yanVaSGVqZDFrSDZvYjhLOTY6RUU2SHlXRDgzM0dxOEZwS0QyUk5UamZZblU3WElXZVc0MTFxUDRGNTlPY3JIN2RKV3ZqR1J6dTdPSVl2aFY4RmhlV28waFN0SEo1aFV6Zkg=");
        return headers;
    }

    private HttpHeaders loadUserInformationHeaders(AccessToken accessToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Authorization", "Bearer " + accessToken.getAccess_token());
        return headers;
    }
}
