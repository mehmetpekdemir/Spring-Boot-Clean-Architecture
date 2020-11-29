package com.mehmetpekdemir.cleanarchitecture.webapi.presenter.category;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.mehmetpekdemir.cleanarchitecture.application.usecase.category.GetCategoryByCategoryIdUseCase.Output;
import com.mehmetpekdemir.cleanarchitecture.application.usecase.category.GetCategoryByCategoryIdUseCase.OutputHandler;
import com.mehmetpekdemir.cleanarchitecture.webapi.common.BasePresenter;
import com.mehmetpekdemir.cleanarchitecture.webapi.common.BaseResponse;
import com.mehmetpekdemir.cleanarchitecture.webapi.common.BaseStatus;
import com.mehmetpekdemir.cleanarchitecture.webapi.common.DataResponse;
import com.mehmetpekdemir.cleanarchitecture.webapi.common.MessageStatus;
import com.mehmetpekdemir.cleanarchitecture.webapi.response.category.CategoryResponse;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public class GetCategoryByCategoryIdPresenter extends BasePresenter implements OutputHandler {

	@Override
	public void handle(Output output) {
		final String categoryName = output.getCategoryName();
		final BaseStatus status = BaseStatus.successful();

		final var response = new DataResponse<>(status, CategoryResponse.builder().categoryName(categoryName).build());

		viewModel = ResponseEntity.ok(response);
	}

	@Override
	public void handleNotFoundForCategoryId(Long categoryId) {
		final String message = String.format("Category id = %s not found .", categoryId);
		final MessageStatus status = MessageStatus.withFailure(message);

		final var response = new BaseResponse(status);

		viewModel = ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}

}
