package com.mehmetpekdemir.cleanarchitecture.application.usecase.category;

import com.mehmetpekdemir.cleanarchitecture.common.Assertion;
import com.mehmetpekdemir.cleanarchitecture.domain.common.InputValidationException;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public interface GetCategoryByCategoryIdUseCase {

	void execute(Query query, OutputHandler handler);

	interface OutputHandler {

		void handle(Output output);
		
		void handleNotFoundForCategoryId(Long categoryId);
		
	}

	@Data
	@Builder
	class Query {

		private Long categoryId;

		public Query(Long categoryId) {
			Assertion.assertNotNull(categoryId, new InputValidationException("CategoryId cannot be null !"));
			this.categoryId = categoryId;
		}

	}

	@Getter
	@Setter
	@AllArgsConstructor
	@Builder
	class Output {

		private String categoryName;

	}

}
