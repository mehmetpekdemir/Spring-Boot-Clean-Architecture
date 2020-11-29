package com.mehmetpekdemir.cleanarchitecture.infrastructure.h2.repository.category;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.mehmetpekdemir.cleanarchitecture.application.repository.CategoryRepository;
import com.mehmetpekdemir.cleanarchitecture.domain.category.Category;
import com.mehmetpekdemir.cleanarchitecture.infrastructure.h2.entity.CategoryEntity;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Repository
@RequiredArgsConstructor
public class CategoryRepositoryImpl implements CategoryRepository {

	private final CategoryJpaRepository categoryJpaRepository;

	@Override
	public Category createCategory(Category category) {
		final CategoryEntity response = categoryJpaRepository.save(mapToCategoryEntity(category));
		return mapToCategory(response);
	}

	@Override
	public Optional<Category> findByCategoryName(String categoryName) {
		final Optional<CategoryEntity> response = categoryJpaRepository.findByCategoryName(categoryName);
		return response.map(this::mapToCategory);
	}

	@Override
	public Optional<Category> findByCategoryId(Long id) {
		final Optional<CategoryEntity> response = categoryJpaRepository.findById(id);
		return response.map(this::mapToCategory);
	}

	private CategoryEntity mapToCategoryEntity(Category category) {
		return new CategoryEntity(category.getCategoryName());
	}

	private Category mapToCategory(CategoryEntity categoryEntity) {
		return Category.builder().categoryName(categoryEntity.getCategoryName()).build();
	}

}
