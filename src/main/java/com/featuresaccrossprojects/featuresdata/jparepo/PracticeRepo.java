package com.featuresaccrossprojects.featuresdata.jparepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.featuresaccrossprojects.featuresdata.dao.Practice;

public interface PracticeRepo extends JpaRepository<Practice, String> {

	@Query("SELECT P.practice_name FROM Practice P")
	List<String> findAllPracticeName();
}
