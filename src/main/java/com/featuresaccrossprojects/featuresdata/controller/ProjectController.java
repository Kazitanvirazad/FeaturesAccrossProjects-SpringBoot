package com.featuresaccrossprojects.featuresdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.featuresaccrossprojects.featuresdata.dto.ProjectDTO;
import com.featuresaccrossprojects.featuresdata.service.ProjectDataService;
import com.featuresaccrossprojects.featuresdata.util.ResponseObject;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/project")
@CrossOrigin
public class ProjectController {

	@Autowired
	private ProjectDataService projectDataService;

	@PostMapping(path = "/addproject", consumes = { "application/json" })
	public ResponseEntity<ResponseObject> addNewProject(@RequestBody @Valid ProjectDTO project) {
		ResponseObject responseObject = new ResponseObject();
		if (project != null && project.getProject_name() != null && project.getProject_name().length() > 0) {
			responseObject = projectDataService.addNewProject(project);
		}

		if (responseObject.isError())
			return new ResponseEntity<>(responseObject, new HttpHeaders(), HttpStatus.CONFLICT);
		return new ResponseEntity<>(responseObject, new HttpHeaders(), HttpStatus.CREATED);
	}

	@GetMapping(path = "/getprojects")
	public ResponseEntity<ResponseObject> getProjectList() {
		ResponseObject responseObject = projectDataService.getProjectListCached() != null
				&& !projectDataService.getProjectListCached().isError() ? projectDataService.getProjectListCached()
						: projectDataService.getProjectList();

		if (responseObject.isError())
			return new ResponseEntity<>(responseObject, new HttpHeaders(), HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(responseObject, new HttpHeaders(), HttpStatus.OK);
	}

}
