package com.mehmetpekdemir.cleanarchitecture.webapi.presenter.category;

import com.mehmetpekdemir.cleanarchitecture.webapi.common.BasePresenter;
import com.mehmetpekdemir.cleanarchitecture.webapi.common.BaseResponse;
import com.mehmetpekdemir.cleanarchitecture.webapi.common.BaseStatus;
import com.mehmetpekdemir.cleanarchitecture.webapi.common.DataResponse;
import com.mehmetpekdemir.cleanarchitecture.webapi.common.MessageStatus;
import com.mehmetpekdemir.cleanarchitecture.webapi.response.category.CategoryResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.mehmetpekdemir.cleanarchitecture.application.usecase.category.CreateCategoryUseCase.Output;
import com.mehmetpekdemir.cleanarchitecture.application.usecase.category.CreateCategoryUseCase.OutputHandler;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public class CreateCategoryPresenter extends BasePresenter implements OutputHandler {

	@Override
	public void handle(Output output) {
		final String categoryName = output.getCategoryName();
		final BaseStatus status = BaseStatus.successful();

		final var response = new DataResponse<>(status, CategoryResponse.builder().categoryName(categoryName).build());

		viewModel = ResponseEntity.ok(response);
	}

	@Override
	public void handleRegisteredCategoryWithCategoryName(String categoryName) {
		final String message = String.format("%s already in use.", categoryName);
		final MessageStatus status = MessageStatus.withFailure(message);

		final var response = new BaseResponse(status);

		viewModel = ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}

}
