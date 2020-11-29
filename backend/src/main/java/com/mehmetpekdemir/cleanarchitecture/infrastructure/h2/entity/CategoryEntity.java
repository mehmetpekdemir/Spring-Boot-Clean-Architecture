package com.mehmetpekdemir.cleanarchitecture.infrastructure.h2.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class CategoryEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "category_name", nullable = false, unique = true, length = 50)
	private String categoryName;

	public CategoryEntity(String categoryName) {
		this.categoryName = categoryName;
	}

}
