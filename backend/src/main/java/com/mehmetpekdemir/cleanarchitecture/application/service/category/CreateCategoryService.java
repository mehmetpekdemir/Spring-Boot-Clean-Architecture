package com.mehmetpekdemir.cleanarchitecture.application.service.category;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mehmetpekdemir.cleanarchitecture.application.repository.CategoryRepository;
import com.mehmetpekdemir.cleanarchitecture.application.usecase.category.CreateCategoryUseCase;
import com.mehmetpekdemir.cleanarchitecture.domain.category.Category;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
@Transactional
public class CreateCategoryService implements CreateCategoryUseCase {

	private final CategoryRepository categoryRepository;

	@Override
	public void execute(Command command, OutputHandler handler) {
		final Optional<Category> category = categoryRepository.findByCategoryName(command.getCategoryName());

		if (!category.isEmpty()) {
			handler.handleRegisteredCategoryWithCategoryName(command.getCategoryName());
			return;
		}

		final Category savedCategory = categoryRepository.createCategory(new Category(command.getCategoryName()));
		final Output output = buildOutput(savedCategory);
		handler.handle(output);
	}

	private Output buildOutput(Category category) {
		return Output.builder().categoryName(category.getCategoryName()).build();
	}

}
