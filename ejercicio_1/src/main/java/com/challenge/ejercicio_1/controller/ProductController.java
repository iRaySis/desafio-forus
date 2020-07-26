package com.challenge.ejercicio_1.controller;

import com.challenge.ejercicio_1.dto.ProductDTO;
import com.challenge.ejercicio_1.service.ProductService;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("producto")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping()
    public List<ProductDTO> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping(value = "{id}")
    public ProductDTO getProductById(@PathVariable(name = "id") Long id) {
        return productService.getProductById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public ProductDTO createProduct(@RequestBody ProductDTO product){
        return productService.createProduct(product);
    }

    @PutMapping()
    public ProductDTO updateProduct(@RequestBody ProductDTO product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping(value = "{id}")
    public Boolean deleteProductById(@PathVariable(name = "id") Long id) {
        return productService.deleteProductById(id);
    }

}
