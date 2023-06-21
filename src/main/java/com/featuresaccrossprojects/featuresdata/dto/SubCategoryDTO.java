package com.featuresaccrossprojects.featuresdata.dto;

import java.io.Serializable;

public class SubCategoryDTO implements Serializable {

	private static final long serialVersionUID = 5357644563823530317L;

	private String subcategory_name;

	private String subcategory_description;

	public String getSubcategory_name() {
		return subcategory_name;
	}

	public void setSubcategory_name(String subcategory_name) {
		this.subcategory_name = subcategory_name;
	}

	public String getSubcategory_description() {
		return subcategory_description;
	}

	public void setSubcategory_description(String subcategory_description) {
		this.subcategory_description = subcategory_description;
	}

	public SubCategoryDTO(String subcategory_name, String subcategory_description) {
		this();
		this.subcategory_name = subcategory_name;
		this.subcategory_description = subcategory_description;
	}

	public SubCategoryDTO() {
		super();
	}

}
