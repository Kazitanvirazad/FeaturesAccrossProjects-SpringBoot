package com.featuresaccrossprojects.featuresdata.jparepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.featuresaccrossprojects.featuresdata.dao.Category;

public interface CategoryRepo extends JpaRepository<Category, String> {

	@Query("SELECT C FROM Category C")
	List<Category> findAllCategoryOnly();
}
