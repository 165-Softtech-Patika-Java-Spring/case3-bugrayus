package com.case3bugrayus.repository;

import com.case3bugrayus.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
