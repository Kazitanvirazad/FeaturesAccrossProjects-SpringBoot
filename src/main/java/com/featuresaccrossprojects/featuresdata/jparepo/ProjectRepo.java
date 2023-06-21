package com.featuresaccrossprojects.featuresdata.jparepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.featuresaccrossprojects.featuresdata.dao.Project;

public interface ProjectRepo extends JpaRepository<Project, String> {

	@Query("SELECT P.project_name FROM Project P")
	List<String> findAllProjectNames();
}
