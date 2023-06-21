package com.featuresaccrossprojects.featuresdata.dto;

import java.io.Serializable;

public class DomainDTO implements Serializable {

	private static final long serialVersionUID = -3028033106614046145L;

	private String domain_name;

	public String getDomain_name() {
		return domain_name;
	}

	public void setDomain_name(String domain_name) {
		this.domain_name = domain_name;
	}

	public DomainDTO() {
		super();
	}

	public DomainDTO(String domain_name) {
		this();
		this.domain_name = domain_name;
	}

}
