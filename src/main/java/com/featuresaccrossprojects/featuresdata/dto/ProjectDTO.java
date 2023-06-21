package com.featuresaccrossprojects.featuresdata.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.featuresaccrossprojects.featuresdata.util.UniqueKeyGenerator;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProjectDTO implements Serializable {

	private static final long serialVersionUID = 2064210978529335914L;

	@NotBlank(message = "Project name is mandatory")
	@NotNull(message = "Project name should be NULL")
	private String project_name;

	private int id;

	private List<RegionDTO> regions = new ArrayList<>();

	private SectorDTO sector;

	private UserDTO project_contact_point;

	private boolean multi_brand;

	private String brandnames;

	private boolean multi_site;

	private String project_notes;

	private String last_served_year;

	private ClientLeadDTO clientLead;

	private PracticeDTO practice;

	private DomainDTO domain;

	public ProjectDTO setUniqueKeyId() {
		this.id = UniqueKeyGenerator.generateUniqueInteger();
		return this;
	}

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<RegionDTO> getRegions() {
		return regions;
	}

	public void setRegions(List<RegionDTO> regions) {
		this.regions = regions;
	}

	public SectorDTO getSector() {
		return sector;
	}

	public void setSector(SectorDTO sector) {
		this.sector = sector;
	}

	public UserDTO getProject_contact_point() {
		return project_contact_point;
	}

	public void setProject_contact_point(UserDTO project_contact_point) {
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

	public ClientLeadDTO getClientLead() {
		return clientLead;
	}

	public void setClientLead(ClientLeadDTO clientLead) {
		this.clientLead = clientLead;
	}

	public PracticeDTO getPractice() {
		return practice;
	}

	public void setPractice(PracticeDTO practice) {
		this.practice = practice;
	}

	public DomainDTO getDomain() {
		return domain;
	}

	public void setDomain(DomainDTO domain) {
		this.domain = domain;
	}

	public ProjectDTO(String project_name, int id, List<RegionDTO> regions, SectorDTO sector,
			UserDTO project_contact_point, boolean multi_brand, String brandnames, boolean multi_site,
			String project_notes, String last_served_year, ClientLeadDTO clientLead, PracticeDTO practice,
			DomainDTO domain) {
		this();
		this.project_name = project_name;
		this.id = id;
		this.regions = regions;
		this.sector = sector;
		this.project_contact_point = project_contact_point;
		this.multi_brand = multi_brand;
		this.brandnames = brandnames;
		this.multi_site = multi_site;
		this.project_notes = project_notes;
		this.last_served_year = last_served_year;
		this.clientLead = clientLead;
		this.practice = practice;
		this.domain = domain;
	}

	public ProjectDTO() {
		super();
	}

}
