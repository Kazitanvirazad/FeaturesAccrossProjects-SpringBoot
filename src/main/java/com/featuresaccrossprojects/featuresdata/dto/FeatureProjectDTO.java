package com.featuresaccrossprojects.featuresdata.dto;

import java.io.Serializable;

import com.featuresaccrossprojects.featuresdata.util.UniqueKeyGenerator;

public class FeatureProjectDTO implements Serializable {

	private static final long serialVersionUID = -2576903264942041108L;

	private int id;

	private FeatureDTO feature;

	private ProjectDTO project;

	private String artifact_detail;

	private UserDTO poc;

	private String used_year;

	private boolean feature_extended;

	private UserDTO alternate_poc;

	public FeatureProjectDTO setUniquePrimaryKeyValue() {
		this.id = UniqueKeyGenerator.generateUniqueInteger();
		return this;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public FeatureDTO getFeature() {
		return feature;
	}

	public void setFeature(FeatureDTO feature) {
		this.feature = feature;
	}

	public ProjectDTO getProject() {
		return project;
	}

	public void setProject(ProjectDTO project) {
		this.project = project;
	}

	public String getArtifact_detail() {
		return artifact_detail;
	}

	public void setArtifact_detail(String artifact_detail) {
		this.artifact_detail = artifact_detail;
	}

	public UserDTO getPoc() {
		return poc;
	}

	public void setPoc(UserDTO poc) {
		this.poc = poc;
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

	public UserDTO getAlternate_poc() {
		return alternate_poc;
	}

	public void setAlternate_poc(UserDTO alternate_poc) {
		this.alternate_poc = alternate_poc;
	}

	public FeatureProjectDTO(int id, FeatureDTO feature, ProjectDTO project, String artifact_detail, UserDTO poc,
			String used_year, boolean feature_extended, UserDTO alternate_poc) {
		this();
		this.id = id;
		this.feature = feature;
		this.project = project;
		this.artifact_detail = artifact_detail;
		this.poc = poc;
		this.used_year = used_year;
		this.feature_extended = feature_extended;
		this.alternate_poc = alternate_poc;
	}

	public FeatureProjectDTO() {
		super();
	}

}
