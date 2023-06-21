package com.featuresaccrossprojects.featuresdata.jparepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.featuresaccrossprojects.featuresdata.dao.FeatureProject;

public interface FeatureProjectRepo extends JpaRepository<FeatureProject, Integer> {

	@Query(value = "SELECT FP.* FROM feature_project FP , project P, feature F where FP.project_name = P.project_name AND FP.feature_ref = F.feature_ref AND (FP.project_name ILIKE :searchKey OR	FP.feature_ref ILIKE :searchKey OR FP.artifact_detail ILIKE :searchKey OR	FP.poc_user_id ILIKE :searchKey OR FP.used_year ILIKE :searchKey OR FP.alternate_poc_user_id ILIKE :searchKey OR P.sector_sector_name ILIKE :searchKey OR P.client_base ILIKE :searchKey OR P.practice_practice_name ILIKE :searchKey OR P.domain_domain_name ILIKE :searchKey OR F.feature_name ILIKE :searchKey OR F.category_category_name ILIKE :searchKey OR F.sub_category_subcategory_name ILIKE :searchKey OR F.type ILIKE :searchKey)", nativeQuery = true)
	List<FeatureProject> findAllBySearchKey(@Param("searchKey") String searchKey);
}
