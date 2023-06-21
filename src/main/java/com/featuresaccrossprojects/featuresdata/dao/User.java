package com.featuresaccrossprojects.featuresdata.dao;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "userdata")
public class User {
	@Id
	private String user_id;
	private String company_id;
	private String first_name;
	private String last_name;
	private String email;

	@OneToMany(mappedBy = "project_contact_point", fetch = FetchType.LAZY)
	private List<Project> project = new ArrayList<>();

	@OneToMany(mappedBy = "project_contact_point", fetch = FetchType.LAZY)
	private List<Feature> project_contact_point = new ArrayList<>();

	@OneToMany(mappedBy = "alternate_contact_point", fetch = FetchType.LAZY)
	private List<Feature> alternate_contact_point = new ArrayList<>();

	public List<Project> getProject() {
		return project;
	}

	public void setProject(List<Project> project) {
		this.project = project;
	}

	public List<Feature> getProject_contact_point() {
		return project_contact_point;
	}

	public void setProject_contact_point(List<Feature> project_contact_point) {
		this.project_contact_point = project_contact_point;
	}

	public List<Feature> getAlternate_contact_point() {
		return alternate_contact_point;
	}

	public void setAlternate_contact_point(List<Feature> alternate_contact_point) {
		this.alternate_contact_point = alternate_contact_point;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getCompany_id() {
		return company_id;
	}

	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
