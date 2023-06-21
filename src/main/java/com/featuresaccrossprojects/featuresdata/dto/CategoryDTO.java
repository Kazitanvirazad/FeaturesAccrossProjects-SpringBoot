package com.featuresaccrossprojects.featuresdata.dto;

import java.io.Serializable;

public class CategoryDTO implements Serializable {

	private static final long serialVersionUID = 1926698218465643965L;

	private String category_name;
	private String category_description;

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getCategory_description() {
		return category_description;
	}

	public void setCategory_description(String category_description) {
		this.category_description = category_description;
	}

	public CategoryDTO(String category_name, String category_description) {
		this();
		this.category_name = category_name;
		this.category_description = category_description;
	}

	public CategoryDTO() {
		super();
	}

}
