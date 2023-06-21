package com.featuresaccrossprojects.featuresdata.dto;

import java.io.Serializable;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = 2998906568278747228L;

	private String user_id;
	private String company_id;
	private String first_name;
	private String last_name;
	private String email;
	private String displayName;

	public String getDisplayName() {
		return displayName;
	}

	public UserDTO setDisplayName() {
		String firstNameValue = getFirst_name() != null ? getFirst_name() : "";
		String lastNameValue = getLast_name() != null ? getLast_name() : "";
		this.displayName = firstNameValue + " " + lastNameValue;
		return this;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
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

	public UserDTO() {
		super();
	}

	public UserDTO(String user_id, String company_id, String first_name, String last_name, String email) {
		this();
		this.user_id = user_id;
		this.company_id = company_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
	}

}
