package com.featuresaccrossprojects.featuresdata.jparepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.featuresaccrossprojects.featuresdata.dao.Domain;

public interface DomainRepo extends JpaRepository<Domain, String> {

	@Query("SELECT D.domain_name FROM Domain D")
	List<String> findAllDomainName();
}
