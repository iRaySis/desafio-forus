package com.challenge.ejercicio_1.dao;

import com.challenge.ejercicio_1.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ProductDAO extends JpaRepository<Product, Long> {
}
