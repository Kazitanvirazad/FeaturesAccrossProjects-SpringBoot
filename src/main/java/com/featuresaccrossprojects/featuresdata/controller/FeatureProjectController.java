package com.featuresaccrossprojects.featuresdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.featuresaccrossprojects.featuresdata.service.FeatureProjectDataService;
import com.featuresaccrossprojects.featuresdata.util.ResponseObject;

@RestController
@RequestMapping(path = "/featureprojects")
@CrossOrigin
public class FeatureProjectController {

	@Autowired
	private FeatureProjectDataService featureProjectDataService;

	@GetMapping(path = "/getfeatureprojects")
	public ResponseEntity<ResponseObject> getfeatureprojects() {
		ResponseObject responseObject = featureProjectDataService.getFeatureProjectList();

		if (responseObject.isError())
			return new ResponseEntity<>(responseObject, new HttpHeaders(), HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(responseObject, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping(path = "/search")
	public ResponseEntity<ResponseObject> searchFeatureProject(@RequestParam(name = "keyword") String keyword) {
		ResponseObject responseObject = featureProjectDataService.getFeatureProjectSearchDataCached(keyword) != null
				&& !featureProjectDataService.getFeatureProjectSearchDataCached(keyword).isError()
						? featureProjectDataService.getFeatureProjectSearchDataCached(keyword)
						: featureProjectDataService.getFeatureProjectSearchData(keyword);

		if (responseObject.isError())
			return new ResponseEntity<>(responseObject, new HttpHeaders(), HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(responseObject, new HttpHeaders(), HttpStatus.OK);
	}
}
