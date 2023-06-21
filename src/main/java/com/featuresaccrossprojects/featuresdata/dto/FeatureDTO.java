package com.featuresaccrossprojects.featuresdata.dto;

import java.io.Serializable;

import com.featuresaccrossprojects.featuresdata.util.UniqueKeyGenerator;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class FeatureDTO implements Serializable {

	private static final long serialVersionUID = 3561894732929978705L;

	@NotBlank(message = "Feature reference is mandatory")
	@NotNull(message = "Feature reference should not be NULL")
	private String feature_ref;

	private int id;

	@NotBlank(message = "Project name field is mandatory")
	@NotNull(message = "Project name field should not be NULL")
	private String project_name;

	private String feature_name;

	private CategoryDTO category;

	private SubCategoryDTO sub_category;

	private String desc;

	private String feature_type;

	private UserDTO project_contact_point;

	private String artifact_detail;

	private String used_year;

	private boolean feature_extended;

	private UserDTO alternate_contact_point;

	public FeatureDTO setUniqueIDValue() {
		this.id = UniqueKeyGenerator.generateUniqueInteger();
		return this;
	}

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public String getFeature_ref() {
		return feature_ref;
	}

	public void setFeature_ref(String feature_ref) {
		this.feature_ref = feature_ref;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFeature_name() {
		return feature_name;
	}

	public void setFeature_name(String feature_name) {
		this.feature_name = feature_name;
	}

	public CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}

	public SubCategoryDTO getSub_category() {
		return sub_category;
	}

	public void setSub_category(SubCategoryDTO sub_category) {
		this.sub_category = sub_category;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getFeature_type() {
		return feature_type;
	}

	public void setFeature_type(String feature_type) {
		this.feature_type = feature_type;
	}

	public UserDTO getProject_contact_point() {
		return project_contact_point;
	}

	public void setProject_contact_point(UserDTO project_contact_point) {
		this.project_contact_point = project_contact_point;
	}

	public String getArtifact_detail() {
		return artifact_detail;
	}

	public void setArtifact_detail(String artifact_detail) {
		this.artifact_detail = artifact_detail;
	}

	public String getUsed_year() {
		return used_year;
	}

	public void setUsed_year(String used_year) {
		this.used_year = used_year;
	}

	public boolean isFeature_extended() {
		return feature_extended;
	}

	public void setFeature_extended(boolean feature_extended) {
		this.feature_extended = feature_extended;
	}

	public UserDTO getAlternate_contact_point() {
		return alternate_contact_point;
	}

	public void setAlternate_contact_point(UserDTO alternate_contact_point) {
		this.alternate_contact_point = alternate_contact_point;
	}

	public FeatureDTO() {
		super();
	}

	public FeatureDTO(
			@NotBlank(message = "Feature reference is mandatory") @NotNull(message = "Feature reference should not be NULL") String feature_ref,
			int id, String project_name, String feature_name, CategoryDTO category, SubCategoryDTO sub_category,
			String desc, String feature_type, UserDTO project_contact_point, String artifact_detail, String used_year,
			boolean feature_extended, UserDTO alternate_contact_point) {
		this();
		this.feature_ref = feature_ref;
		this.id = id;
		this.project_name = project_name;
		this.feature_name = feature_name;
		this.category = category;
		this.sub_category = sub_category;
		this.desc = desc;
		this.feature_type = feature_type;
		this.project_contact_point = project_contact_point;
		this.artifact_detail = artifact_detail;
		this.used_year = used_year;
		this.feature_extended = feature_extended;
		this.alternate_contact_point = alternate_contact_point;
	}

}
