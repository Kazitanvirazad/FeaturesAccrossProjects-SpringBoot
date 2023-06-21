package com.featuresaccrossprojects.featuresdata.jparepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.featuresaccrossprojects.featuresdata.dao.ClientLead;

public interface ClientLeadRepo extends JpaRepository<ClientLead, String> {

	@Query("SELECT C.client_type FROM ClientLead C")
	List<String> findAllClientType();
}
