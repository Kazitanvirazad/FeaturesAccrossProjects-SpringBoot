package com.featuresaccrossprojects.featuresdata.jparepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.featuresaccrossprojects.featuresdata.dao.Region;

public interface RegionRepo extends JpaRepository<Region, String> {

}
