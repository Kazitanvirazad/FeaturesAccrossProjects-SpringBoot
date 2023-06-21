package com.featuresaccrossprojects.featuresdata.dao;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "client_lead")
public class ClientLead {
	@Id
	private String client_type;

	@OneToMany(mappedBy = "clientLead", fetch = FetchType.LAZY)
	private List<Project> project = new ArrayList<>();

	public List<Project> getProject() {
		return project;
	}

	public void setProject(List<Project> project) {
		this.project = project;
	}

	public String getClient_type() {
		return client_type;
	}

	public void setClient_type(String client_type) {
		this.client_type = client_type;
	}

}
