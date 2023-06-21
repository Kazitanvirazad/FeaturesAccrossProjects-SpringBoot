package com.featuresaccrossprojects.featuresdata.dto;

import java.io.Serializable;

public class PracticeDTO implements Serializable {

	private static final long serialVersionUID = 4329733019037423593L;

	private String practice_name;

	public String getPractice_name() {
		return practice_name;
	}

	public void setPractice_name(String practice_name) {
		this.practice_name = practice_name;
	}

	public PracticeDTO(String practice_name) {
		this();
		this.practice_name = practice_name;
	}

	public PracticeDTO() {
		super();
	}

}
