package com.featuresaccrossprojects.featuresdata.dao;

import java.util.ArrayList;
import java.util.List;

import com.featuresaccrossprojects.featuresdata.util.UniqueKeyGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "project")
public class Project {

	@ManyToMany(mappedBy = "projects", fetch = FetchType.LAZY)
	private List<Feature> features = new ArrayList<>();

	@Id
	private String project_name;

	@Column(nullable = false)
	private int id;

	@OneToMany(fetch = FetchType.LAZY)
	private List<Region> regions = new ArrayList<>();

	@ManyToOne(fetch = FetchType.LAZY)
	private Sector sector;

	@ManyToOne(fetch = FetchType.LAZY)
	private User project_contact_point;

	private boolean multi_brand;

	@Column(length = 2000)
	private String brandnames;

	private boolean multi_site;

	@Column(length = 2000)
	private String project_notes;

	@Size(min = 4, max = 4)
	private String last_served_year;

	@JoinColumn(name = "client_base")
	@ManyToOne(fetch = FetchType.LAZY)
	private ClientLead clientLead;

	@ManyToOne(fetch = FetchType.LAZY)
	private Practice practice;

	@ManyToOne(fetch = FetchType.LAZY)
	private Domain domain;

	public List<Feature> getFeatures() {
		return features;
	}

	public void setFeatures(List<Feature> features) {
		this.features = features;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public List<Region> getRegions() {
		return regions;
	}

	public void setRegions(List<Region> regions) {
		this.regions = regions;
	}

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	public User getProject_contact_point() {
		return project_contact_point;
	}

	public void setProject_contact_point(User project_contact_point) {
		this.project_contact_point = project_contact_point;
	}

	public boolean isMulti_brand() {
		return multi_brand;
	}

	public void setMulti_brand(boolean multi_brand) {
		this.multi_brand = multi_brand;
	}

	public String getBrandnames() {
		return brandnames;
	}

	public void setBrandnames(String brandnames) {
		this.brandnames = brandnames;
	}

	public boolean isMulti_site() {
		return multi_site;
	}

	public void setMulti_site(boolean multi_site) {
		this.multi_site = multi_site;
	}

	public String getProject_notes() {
		return project_notes;
	}

	public void setProject_notes(String project_notes) {
		this.project_notes = project_notes;
	}

	public String getLast_served_year() {
		return last_served_year;
	}

	public void setLast_served_year(String last_served_year) {
		this.last_served_year = last_served_year;
	}

	public ClientLead getClientLead() {
		return clientLead;
	}

	public void setClientLead(ClientLead clientLead) {
		this.clientLead = clientLead;
	}

	public Practice getPractice() {
		return practice;
	}

	public void setPractice(Practice practice) {
		this.practice = practice;
	}

	public Domain getDomain() {
		return domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	public Project setUniqueIDValue() {
		this.id = UniqueKeyGenerator.generateUniqueInteger();
		return this;
	}

}
