package com.featuresaccrossprojects.featuresdata.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "project_regions")
public class ProjectRegion {
	
	@Id
    private int id;

	@JoinColumn(name = "project_project_name", nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	private Project project;

	@JoinColumn(name = "regions_region_id", nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	private Region region;

	public Project getProject() {
		return project;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

}
