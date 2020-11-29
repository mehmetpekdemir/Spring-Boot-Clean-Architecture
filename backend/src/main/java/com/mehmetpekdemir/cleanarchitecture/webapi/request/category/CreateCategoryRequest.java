package com.mehmetpekdemir.cleanarchitecture.webapi.request.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCategoryRequest {

	private String categoryName;

}
