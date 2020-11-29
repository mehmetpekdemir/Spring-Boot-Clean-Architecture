package com.mehmetpekdemir.cleanarchitecture.webapi.response.category;

import lombok.Builder;
import lombok.Data;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Data
@Builder
public class CategoryResponse {
	
	private String categoryName;

}
