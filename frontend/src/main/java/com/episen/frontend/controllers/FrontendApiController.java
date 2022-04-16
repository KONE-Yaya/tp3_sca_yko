package com.episen.frontend.controllers;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/frontend")
public class FrontendApiController {

    RestTemplate restTemplate = new RestTemplate();

    @Value("${backend.address}")
    private String address;

    @GetMapping("/")
    public String getBackendInfos() {

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String url = "http://" + address + "/api/backend/";
        return JSONObject.valueToString("Frontend calling Backend: Result -> " + restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody());
    }
}
