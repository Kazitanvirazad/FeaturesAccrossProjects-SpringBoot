package com.featuresaccrossprojects.featuresdata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.featuresaccrossprojects.featuresdata.dao.Category;
import com.featuresaccrossprojects.featuresdata.dto.CategoryDTO;
import com.featuresaccrossprojects.featuresdata.jparepo.CategoryRepo;

@Service
public class CategoryDataService {

	@Autowired
	private CategoryRepo categoryRepo;

	public Category getCategoryData(CategoryDTO categoryDTO) {
		Category category = new Category();
		if (categoryDTO != null && categoryDTO.getCategory_name() != null
				&& categoryDTO.getCategory_name().length() > 0) {
			category = categoryRepo.getReferenceById(categoryDTO.getCategory_name());
		}
		return category;
	}
}
