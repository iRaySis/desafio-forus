package com.challenge.ejercicio_2.controller;

import com.challenge.ejercicio_2.dto.ProductDTO;
import com.challenge.ejercicio_2.service.ExternalProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("producto")
public class ProductController {

    @Autowired
    ExternalProductService externalProductService;

    @GetMapping(value = "{id}")
    public ProductDTO getProductById(@PathVariable(name = "id") Long id) {
        return externalProductService.getProductById(id);
    }

    @GetMapping()
    public List<ProductDTO> getAllProducts(){
        return externalProductService.getAllProducts();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public List<ProductDTO> createProduct(@RequestBody ProductDTO product){
        return externalProductService.createProduct(product);
    }

    @PutMapping()
    public ProductDTO updateProduct(@RequestBody ProductDTO product) {
        return externalProductService.updateProduct(product);
    }

    @DeleteMapping(value = "{id}")
    public Boolean deleteProductById(@PathVariable(name = "id") Long id) {
        return externalProductService.deleteProductById(id);
    }

}
