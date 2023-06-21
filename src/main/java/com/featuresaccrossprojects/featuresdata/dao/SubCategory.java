package com.featuresaccrossprojects.featuresdata.dao;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "sub_category")
public class SubCategory {

	@Id
	private String subcategory_name;

	@Column(length = 2000)
	private String subcategory_description;

	@OneToMany(mappedBy = "sub_category", fetch = FetchType.LAZY)
	private List<Feature> features = new ArrayList<>();

	public List<Feature> getFeatures() {
		return features;
	}

	public void setFeatures(List<Feature> features) {
		this.features = features;
	}

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

}
