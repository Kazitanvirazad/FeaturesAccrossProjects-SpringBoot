package com.featuresaccrossprojects.featuresdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.featuresaccrossprojects.featuresdata.dto.FeatureDTO;
import com.featuresaccrossprojects.featuresdata.service.FeatureDataService;
import com.featuresaccrossprojects.featuresdata.util.ResponseObject;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/feature")
@CrossOrigin
public class FeatureController {

	@Autowired
	private FeatureDataService featureDataService;

	@PostMapping(path = "/addfeature", consumes = { "application/json" })
	public ResponseEntity<ResponseObject> addFeature(@RequestBody @Valid FeatureDTO feature) {
		ResponseObject responseObject = new ResponseObject();
		if (feature != null && feature.getFeature_ref() != null && feature.getFeature_ref().length() > 0) {
			responseObject = featureDataService.addNewFeature(feature);
		}

		if (responseObject.isError())
			return new ResponseEntity<>(responseObject, new HttpHeaders(), HttpStatus.CONFLICT);
		return new ResponseEntity<>(responseObject, new HttpHeaders(), HttpStatus.CREATED);
	}
}
