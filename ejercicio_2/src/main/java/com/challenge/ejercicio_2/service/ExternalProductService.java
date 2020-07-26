package com.challenge.ejercicio_2.service;

import com.challenge.ejercicio_2.dto.ProductDTO;
import com.challenge.ejercicio_2.util.ProductServiceInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class ExternalProductService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    HttpService httpService;

    @Value("${EXTERNAL_SERVICE_URI}")
    private String apiUrl;

    public ProductDTO getProductById(Long id) {
        return httpService.get(apiUrl + id, ProductDTO.class);
    }

    public List<ProductDTO> getAllProducts() {
        ProductDTO[] response = httpService.get(apiUrl, ProductDTO[].class);
        return response != null ? Arrays.asList(response) : Collections.emptyList();
    }

    public List<ProductDTO> createProduct(ProductDTO productDTO){
        String response = httpService.post(apiUrl, productDTO, String.class);
        log.info(ProductServiceInfo.CREATED.message, response);
        return this.getAllProducts();
    }

    public ProductDTO updateProduct(ProductDTO dto) {
        if (dto.getProductoId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        String response = this.httpService.put(apiUrl, dto, String.class);
        log.info(ProductServiceInfo.UPDATED.message, dto.getProductoId(),response);
        return dto;
    }

    public Boolean deleteProductById(Long id) {
        return httpService.delete(apiUrl, id);
    }

}
