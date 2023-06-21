package com.featuresaccrossprojects.featuresdata.jparepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.featuresaccrossprojects.featuresdata.dao.Sector;

public interface SectorRepo extends JpaRepository<Sector, String> {

	@Query("SELECT S.sector_name FROM Sector S")
	List<String> findAllSectorName();
}
