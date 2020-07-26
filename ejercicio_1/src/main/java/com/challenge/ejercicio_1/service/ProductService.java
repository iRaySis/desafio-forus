package com.challenge.ejercicio_1.service;

import com.challenge.ejercicio_1.dao.ProductDAO;
import com.challenge.ejercicio_1.dto.ProductDTO;
import com.challenge.ejercicio_1.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductService {

    @Autowired
    ProductDAO productDAO;

    @Transactional(readOnly = true)
    public List<ProductDTO> getAllProducts() {
        return this.productEntityListToDTO(productDAO.findAll());
    }

    @Transactional(readOnly = true)
    public ProductDTO getProductById(Long id) {
        Product product = this.getProductEntityById(id);
        return this.productEntityToDTO(product);
    }

    @Transactional
    public ProductDTO createProduct(ProductDTO dto) {
        Product product = new Product();
        BeanUtils.copyProperties(dto, product, "productId");
        productDAO.save(product);
        log.info("Producto creado con id "+product.getProductoId());
        return this.productEntityToDTO(product);
    }

    @Transactional
    public Boolean deleteProductById(Long id) {
        Product loadedProduct = getProductEntityById(id);
        productDAO.delete(loadedProduct);
        log.info("Producto con id "+id+" eliminado");
        return true;
    }

    @Transactional
    public ProductDTO updateProduct(ProductDTO dto) {
        Product product = getProductEntityById(dto.getProductoId());
        BeanUtils.copyProperties(dto, product, "productoId");
        productDAO.save(product);
        log.info("Producto con id "+product.getProductoId()+" editado");
        return this.productEntityToDTO(product);
    }

    @Transactional
    public Product getProductEntityById(Long id) {
        Optional<Product> loadedProduct = productDAO.findById(id);
        if (!loadedProduct.isPresent()) {
            log.info("Producto con id "+id+" no encontrado");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return loadedProduct.get();
    }

    private List<ProductDTO> productEntityListToDTO(List<Product> products) {
        return products.stream()
                .map(product -> this.productEntityToDTO(product))
                .collect(Collectors.toList());
    }

    private ProductDTO productEntityToDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        BeanUtils.copyProperties(product, dto);
        return dto;
    }

}
