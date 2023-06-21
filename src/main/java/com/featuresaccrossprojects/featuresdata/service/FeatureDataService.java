package com.featuresaccrossprojects.featuresdata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.featuresaccrossprojects.featuresdata.dao.Feature;
import com.featuresaccrossprojects.featuresdata.dto.FeatureDTO;
import com.featuresaccrossprojects.featuresdata.jparepo.FeatureRepo;
import com.featuresaccrossprojects.featuresdata.jparepo.ProjectRepo;
import com.featuresaccrossprojects.featuresdata.util.DtoToDaoConverter;
import com.featuresaccrossprojects.featuresdata.util.ResponseObject;

@Service
public class FeatureDataService {

	@Autowired
	private FeatureRepo featureRepo;

	@Autowired
	private DtoToDaoConverter dtoToDaoConverter;

	@Autowired
	private FeatureProjectDataService featureProjectDataService;

	@Autowired
	private ProjectRepo projectRepo;

	@Transactional
	public ResponseObject addNewFeature(FeatureDTO featureDTO) {
		Feature feature = new Feature();
		ResponseObject responseObject = new ResponseObject();
		if (featureDTO != null && featureDTO.getFeature_ref() != null && featureDTO.getFeature_ref().length() > 0) {

			if (!isFeatureExists(featureDTO)) {
				feature = dtoToDaoConverter.copyFeatureDTOToFeature(featureDTO);
				if (feature.getFeature_ref() != null && feature.getFeature_ref().length() > 0) {
					featureRepo.save(feature);
					featureProjectDataService.addFeatureProject(feature,
							projectRepo.getReferenceById(featureDTO.getProject_name()));
					responseObject.setError(false);
					responseObject.setMessage("Feature added successfully!");
				}
			} else {
				responseObject.setError(true);
				responseObject.setMessage("Feature already exists");
			}
		}
		return responseObject;
	}

	public boolean isFeatureExists(FeatureDTO featureDTO) {
		boolean isFeatureExist = false;
		if (featureDTO != null && featureDTO.getFeature_ref() != null && featureDTO.getFeature_ref().length() > 0) {
			isFeatureExist = featureRepo.existsById(featureDTO.getFeature_ref());
		}
		return isFeatureExist;
	}
}
