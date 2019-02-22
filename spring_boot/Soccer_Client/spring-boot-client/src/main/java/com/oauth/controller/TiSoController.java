package com.oauth.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.oauth.model.TiSo;
import org.apache.tomcat.util.codec.binary.Base64;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.*;

@Controller
public class TiSoController {
    @Autowired
   static RestTemplate restTemplate;
    @GetMapping(value = "/index")
    public String getEmployeeInfo() {
        System.out.println("Vao trang getemployee");
        return "getEmployees";
    }
private static HttpEntity<String> getAccess(@RequestParam("code") String code, String access_token_url) throws JsonProcessingException, IOException{
    System.out.println("Vao trang showemployee");
    ResponseEntity<String> response = null;

    restTemplate = new RestTemplate();

    String credentials = "tiso-client:secret";
//        String encodedCredentials = new String(Base64.encodeBase64(credentials.getBytes()));

    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    headers.add(HttpHeaders.AUTHORIZATION, "Basic " + new String(Base64.encodeBase64(credentials.getBytes())));

    HttpEntity<String> request = new HttpEntity(headers);


    System.out.println("Access token url ---------" + access_token_url+" "+code);

    response = restTemplate.exchange(access_token_url, HttpMethod.POST, request, String.class);

//        String encodedCredentials = new String(Base64.encodeBase64(response.getHeaders().toString().getBytes()));
    System.out.println("Access Token Response ---------" + response.getBody());
    // Get the Access Token From the recieved JSON response
    ObjectMapper mapper = new ObjectMapper();
    JsonNode node = mapper.readTree(response.getBody());
    String token = node.path("access_token").asText();
    System.out.println("token" + token);


    // Use the access token for authentication
    HttpHeaders headers1 = new HttpHeaders();
    headers1.add(HttpHeaders.AUTHORIZATION, "Bearer " + token);
    HttpEntity<String> entity = new HttpEntity<>(headers1);
    return entity;
}
    @GetMapping(value = "/getListScore")
    public static ModelAndView showEmployees(@RequestParam("code") String code )
            throws JsonProcessingException, IOException {
               String url = "http://localhost:8080/soccer/tiso";
        String access_token_url = "http://localhost:8080/oauth/token";
        access_token_url += "?code=" + code;
        access_token_url += "&grant_type=authorization_code";
        access_token_url += "&redirect_uri=http://localhost:8090/getListScore";

//        System.out.println("token" + getAccess(code,access_token_url));
        HttpEntity<String> entity= getAccess(code,access_token_url);
        ResponseEntity<TiSo[]> listtiso = restTemplate.exchange(url, HttpMethod.GET,entity, TiSo[].class);
        System.out.println(listtiso);
        TiSo[] employeeArray = listtiso.getBody();
        ModelAndView model = new ModelAndView("showEmployees");
        model.addObject("tiso", Arrays.asList(employeeArray));
        return model;
    }
}
