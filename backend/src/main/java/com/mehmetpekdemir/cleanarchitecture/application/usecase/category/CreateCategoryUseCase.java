package com.mehmetpekdemir.cleanarchitecture.application.usecase.category;

import com.mehmetpekdemir.cleanarchitecture.common.Assertion;
import com.mehmetpekdemir.cleanarchitecture.domain.common.InputValidationException;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public interface CreateCategoryUseCase {

	void execute(Command command, OutputHandler handler);

	interface OutputHandler {

		void handle(Output output);

		void handleRegisteredCategoryWithCategoryName(String categoryName);

	}

	@Data
	@Builder
	class Command {

		private String categoryName;

		public Command(String categoryName) {
			Assertion.assertNotNull(categoryName, new InputValidationException("Category name cannot be null !"));
			this.categoryName = categoryName;
		}

	}

	@Data
	@RequiredArgsConstructor
	@Builder
	class Output {

		private final String categoryName;

	}

}
