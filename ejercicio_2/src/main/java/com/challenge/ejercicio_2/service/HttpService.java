package com.challenge.ejercicio_2.service;

import com.challenge.ejercicio_2.util.HttpServiceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
@Service
public class HttpService {

    @Autowired
    RestTemplate restTemplate;

    public <T extends Serializable> T get(String url, Class<T> outputClass) {
        try {
            ResponseEntity<T> response = restTemplate.getForEntity(url, outputClass);
            return response.getBody();
        } catch (RestClientException e) {
            log.error(HttpServiceInfo.ERROR_GET_REQUEST.message, outputClass.getCanonicalName(), e.getMessage());
            throw e;
        }
    }

    public <T extends Serializable, X extends Serializable> X post(String url, T body, Class<X> outputClass) {
        try {
            return restTemplate.postForObject(url, body, outputClass);
        } catch (RestClientException e) {
            log.error(HttpServiceInfo.ERROR_POST_REQUEST.message, outputClass.getCanonicalName(), body.toString(), url, e.getMessage());
            throw e;
        }
    }

    public <T extends Serializable, X extends Serializable> X put(String url, T body, Class<X> outputClass) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<T> requestUpdate = new HttpEntity<>(body, headers);
            ResponseEntity<X> response = restTemplate.exchange(url, HttpMethod.PUT,requestUpdate, outputClass);
            return response.getBody();
        } catch (RestClientException e) {
            log.error(HttpServiceInfo.ERROR_PUT_REQUEST.message, outputClass.getCanonicalName(), body.toString(), url, e.getMessage());
            throw e;
        }
    }

    public Boolean delete(String url, Long id) {
        try {
            URI request = new URI(url+id);
            restTemplate.delete(request);
            return true;
        } catch (RestClientException | URISyntaxException e) {
            log.error(HttpServiceInfo.ERROR_DELETE_REQUEST.message, id,e.getMessage());
            return false;
        }
    }

}
