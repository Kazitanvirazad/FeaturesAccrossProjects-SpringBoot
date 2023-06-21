package com.featuresaccrossprojects.featuresdata.dao;

import java.util.ArrayList;
import java.util.List;

import com.featuresaccrossprojects.featuresdata.util.UniqueKeyGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "feature")
public class Feature {

	@Id
	@Column(length = 500)
	private String feature_ref;

	@Column(nullable = false)
	private int id;

	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinTable(name = "feature_project", joinColumns = { @JoinColumn(name = "feature_ref") }, inverseJoinColumns = {
			@JoinColumn(name = "project_name") })
	private List<Project> projects = new ArrayList<>();

	@Column(length = 1000)
	private String feature_name;

	@ManyToOne(fetch = FetchType.LAZY)
	private Category category;

	@ManyToOne(fetch = FetchType.LAZY)
	private SubCategory sub_category;

	@Column(name = "description", length = 2000)
	private String desc;

	@Column(name = "type", length = 1000)
	private String feature_type;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "poc")
	private User project_contact_point;

	@Column(length = 1000)
	private String artifact_detail;

	@Size(min = 4, max = 4)
	private String used_year;

	private boolean feature_extended;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "alternate_poc")
	private User alternate_contact_point;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public String getFeature_ref() {
		return feature_ref;
	}

	public void setFeature_ref(String feature_ref) {
		this.feature_ref = feature_ref;
	}

	public String getFeature_name() {
		return feature_name;
	}

	public void setFeature_name(String feature_name) {
		this.feature_name = feature_name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public SubCategory getSub_category() {
		return sub_category;
	}

	public void setSub_category(SubCategory sub_category) {
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

	public User getProject_contact_point() {
		return project_contact_point;
	}

	public void setProject_contact_point(User project_contact_point) {
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

	public User getAlternate_contact_point() {
		return alternate_contact_point;
	}

	public void setAlternate_contact_point(User alternate_contact_point) {
		this.alternate_contact_point = alternate_contact_point;
	}

	public Feature setUniqueIDValue() {
		this.id = UniqueKeyGenerator.generateUniqueInteger();
		return this;
	}
}
