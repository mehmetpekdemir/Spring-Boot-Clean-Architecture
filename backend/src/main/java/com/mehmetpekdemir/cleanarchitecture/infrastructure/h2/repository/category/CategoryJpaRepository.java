package com.mehmetpekdemir.cleanarchitecture.infrastructure.h2.repository.category;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mehmetpekdemir.cleanarchitecture.infrastructure.h2.entity.CategoryEntity;
import java.lang.String;
import java.util.Optional;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public interface CategoryJpaRepository extends JpaRepository<CategoryEntity, Long> {

	Optional<CategoryEntity> findByCategoryName(String categoryName);

}
