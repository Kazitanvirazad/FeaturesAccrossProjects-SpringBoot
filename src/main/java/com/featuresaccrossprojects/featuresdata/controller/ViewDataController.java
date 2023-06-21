package com.featuresaccrossprojects.featuresdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.featuresaccrossprojects.featuresdata.service.FormInputDataService;
import com.featuresaccrossprojects.featuresdata.util.ResponseObject;

@RestController
@RequestMapping(path = "/data")
@CrossOrigin
public class ViewDataController {

	@Autowired
	private FormInputDataService formInputData;

	@GetMapping(path = "/forminputdata", produces = { "application/json" })
	public ResponseEntity<ResponseObject> getDropdownData() {
		ResponseObject responseObject = formInputData.getFormDropDownData();

		if (responseObject.isError())
			return new ResponseEntity<>(responseObject, new HttpHeaders(), HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(responseObject, new HttpHeaders(), HttpStatus.OK);
	}

}
