package com.featuresaccrossprojects.featuresdata.jparepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.featuresaccrossprojects.featuresdata.dao.Feature;

public interface FeatureRepo extends JpaRepository<Feature, String> {

}
