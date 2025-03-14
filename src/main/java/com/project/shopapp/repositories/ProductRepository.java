package com.project.shopapp.repositories;

import com.project.shopapp.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {
    boolean existsByName(String title);

    Page<Product> findAll(Pageable pageable); //phan trang

}
