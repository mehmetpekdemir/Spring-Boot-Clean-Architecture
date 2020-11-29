package com.mehmetpekdemir.cleanarchitecture.application.repository;

import java.util.Optional;

import com.mehmetpekdemir.cleanarchitecture.domain.category.Category;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public interface CategoryRepository {

	Category createCategory(Category category);

	Optional<Category> findByCategoryName(String categoryName);

	Optional<Category> findByCategoryId(Long id);

}
