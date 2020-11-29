package com.mehmetpekdemir.cleanarchitecture.webapi.controller.category;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mehmetpekdemir.cleanarchitecture.application.usecase.category.CreateCategoryUseCase;
import com.mehmetpekdemir.cleanarchitecture.application.usecase.category.CreateCategoryUseCase.Command;
import com.mehmetpekdemir.cleanarchitecture.webapi.common.ApiController;
import com.mehmetpekdemir.cleanarchitecture.webapi.presenter.category.CreateCategoryPresenter;
import com.mehmetpekdemir.cleanarchitecture.webapi.request.category.CreateCategoryRequest;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@ApiController
@RequiredArgsConstructor
public class CreateCategoryController {

	private final CreateCategoryUseCase createCategoryUseCase;

	@PostMapping("category")
	public ResponseEntity<?> createCategory(@RequestBody CreateCategoryRequest createCategoryRequest) {
		var presenter = new CreateCategoryPresenter();
		final var command = Command.builder().categoryName(createCategoryRequest.getCategoryName()).build();

		createCategoryUseCase.execute(command, presenter);
		return presenter.getViewModel();
	}

}
