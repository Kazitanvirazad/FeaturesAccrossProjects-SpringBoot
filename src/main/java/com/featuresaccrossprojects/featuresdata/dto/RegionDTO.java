package com.featuresaccrossprojects.featuresdata.dto;

import java.io.Serializable;

public class RegionDTO implements Serializable {

	private static final long serialVersionUID = 6680024674584272198L;

	private String region_id;
	private String region_name;

	public String getRegion_id() {
		return region_id;
	}

	public void setRegion_id(String region_id) {
		this.region_id = region_id;
	}

	public String getRegion_name() {
		return region_name;
	}

	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}

	public RegionDTO() {
		super();
	}

	public RegionDTO(String region_id, String region_name) {
		this();
		this.region_id = region_id;
		this.region_name = region_name;
	}

}
