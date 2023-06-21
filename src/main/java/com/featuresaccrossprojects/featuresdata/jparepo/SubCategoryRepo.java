package com.featuresaccrossprojects.featuresdata.jparepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.featuresaccrossprojects.featuresdata.dao.SubCategory;

public interface SubCategoryRepo extends JpaRepository<SubCategory, String> {

	@Query("SELECT S.subcategory_name FROM SubCategory S")
	List<String> findAllSubCategoryName();
}
