package com.featuresaccrossprojects.featuresdata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.featuresaccrossprojects.featuresdata.dao.SubCategory;
import com.featuresaccrossprojects.featuresdata.dto.SubCategoryDTO;
import com.featuresaccrossprojects.featuresdata.jparepo.SubCategoryRepo;

@Service
public class SubCategoryDataService {

	@Autowired
	private SubCategoryRepo subCategoryRepo;

	public SubCategory getSubCategoryData(SubCategoryDTO subCategoryDTO) {
		SubCategory subCategory = new SubCategory();
		if (subCategoryDTO != null && subCategoryDTO.getSubcategory_name() != null
				&& subCategoryDTO.getSubcategory_name().length() > 0) {
			subCategory = subCategoryRepo.getReferenceById(subCategoryDTO.getSubcategory_name());
		}
		return subCategory;
	}
}
