package com.featuresaccrossprojects.featuresdata.dao;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "practice")
public class Practice {
	@Id
	private String practice_name;

	@OneToMany(mappedBy = "practice", fetch = FetchType.LAZY)
	private List<Project> project = new ArrayList<>();

	public List<Project> getProject() {
		return project;
	}

	public void setProject(List<Project> project) {
		this.project = project;
	}

	public String getPractice_name() {
		return practice_name;
	}

	public void setPractice_name(String practice_name) {
		this.practice_name = practice_name;
	}

}
