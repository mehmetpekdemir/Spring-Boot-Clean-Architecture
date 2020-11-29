package com.mehmetpekdemir.cleanarchitecture.application.service.category;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mehmetpekdemir.cleanarchitecture.application.repository.CategoryRepository;
import com.mehmetpekdemir.cleanarchitecture.application.usecase.category.GetCategoryByCategoryIdUseCase;
import com.mehmetpekdemir.cleanarchitecture.domain.category.Category;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class GetCategoryByCategoryIdService implements GetCategoryByCategoryIdUseCase {

	private final CategoryRepository categoryRepository;

	@Override
	public void execute(Query query, OutputHandler handler) {
		final Optional<Category> category = categoryRepository.findByCategoryId(query.getCategoryId());

		if (category.isEmpty()) {
			handler.handleNotFoundForCategoryId(query.getCategoryId());
			return;
		}

		final Output output = buildOutput(category.get());
		handler.handle(output);
	}

	private Output buildOutput(Category category) {
		return Output.builder().categoryName(category.getCategoryName()).build();
	}

}
