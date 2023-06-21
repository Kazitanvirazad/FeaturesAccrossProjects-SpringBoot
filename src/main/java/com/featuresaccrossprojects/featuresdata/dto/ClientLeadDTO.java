package com.featuresaccrossprojects.featuresdata.dto;

import java.io.Serializable;

public class ClientLeadDTO implements Serializable {

	private static final long serialVersionUID = -6640360539010648579L;

	private String client_type;

	public String getClient_type() {
		return client_type;
	}

	public void setClient_type(String client_type) {
		this.client_type = client_type;
	}

	public ClientLeadDTO(String client_type) {
		this();
		this.client_type = client_type;
	}

	public ClientLeadDTO() {
		super();
	}

}
