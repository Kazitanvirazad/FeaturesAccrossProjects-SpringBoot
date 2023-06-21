package com.featuresaccrossprojects.featuresdata.dto;

import java.io.Serializable;

public class SectorDTO implements Serializable {

	private static final long serialVersionUID = 1412998397658227760L;

	private String sector_name;

	public String getSector_name() {
		return sector_name;
	}

	public void setSector_name(String sector_name) {
		this.sector_name = sector_name;
	}

	public SectorDTO() {
		super();
	}

	public SectorDTO(String sector_name) {
		this();
		this.sector_name = sector_name;
	}

}
