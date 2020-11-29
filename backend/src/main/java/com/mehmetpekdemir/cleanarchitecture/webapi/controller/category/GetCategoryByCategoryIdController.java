package com.mehmetpekdemir.cleanarchitecture.webapi.controller.category;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mehmetpekdemir.cleanarchitecture.application.usecase.category.GetCategoryByCategoryIdUseCase;
import com.mehmetpekdemir.cleanarchitecture.application.usecase.category.GetCategoryByCategoryIdUseCase.Query;
import com.mehmetpekdemir.cleanarchitecture.webapi.common.ApiController;
import com.mehmetpekdemir.cleanarchitecture.webapi.presenter.category.GetCategoryByCategoryIdPresenter;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@ApiController
@RequiredArgsConstructor
public class GetCategoryByCategoryIdController {

	private final GetCategoryByCategoryIdUseCase getCategoryByCategoryIdUseCase;

	@GetMapping("category")
	public ResponseEntity<?> createCategory(@RequestParam(value = "categoryId") Long categoryId) {
		var presenter = new GetCategoryByCategoryIdPresenter();
		final var query = Query.builder().categoryId(categoryId).build();

		getCategoryByCategoryIdUseCase.execute(query, presenter);
		return presenter.getViewModel();
	}

}
