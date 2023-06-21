package com.featuresaccrossprojects.featuresdata.dao;

import com.featuresaccrossprojects.featuresdata.util.UniqueKeyGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "feature_project")
public class FeatureProject {

	@Id
	private int id;

	@JoinColumn(name = "feature_ref")
	@ManyToOne(fetch = FetchType.LAZY)
	private Feature feature;

	@JoinColumn(name = "project_name")
	@ManyToOne(fetch = FetchType.LAZY)
	private Project project;

	@Column(length = 1000)
	private String artifact_detail;

	@JoinColumn(name = "poc_user_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private User poc;

	@Size(min = 4, max = 4)
	private String used_year;

	private boolean feature_extended;

	@JoinColumn(name = "alternate_poc_user_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private User alternate_poc;

	public FeatureProject setUniquePrimaryKeyValue() {
		this.id = UniqueKeyGenerator.generateUniqueInteger();
		return this;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Feature getFeature() {
		return feature;
	}

	public void setFeature(Feature feature) {
		this.feature = feature;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getArtifact_detail() {
		return artifact_detail;
	}

	public void setArtifact_detail(String artifact_detail) {
		this.artifact_detail = artifact_detail;
	}

	public User getPoc() {
		return poc;
	}

	public void setPoc(User poc) {
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

	public User getAlternate_poc() {
		return alternate_poc;
	}

	public void setAlternate_poc(User alternate_poc) {
		this.alternate_poc = alternate_poc;
	}

}
