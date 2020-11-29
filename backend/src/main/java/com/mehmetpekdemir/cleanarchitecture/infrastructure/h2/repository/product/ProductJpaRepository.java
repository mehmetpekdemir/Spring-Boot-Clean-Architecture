package com.mehmetpekdemir.cleanarchitecture.infrastructure.h2.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mehmetpekdemir.cleanarchitecture.infrastructure.h2.entity.ProductEntity;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {

}
