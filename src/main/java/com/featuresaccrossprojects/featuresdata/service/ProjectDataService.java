package com.featuresaccrossprojects.featuresdata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.featuresaccrossprojects.featuresdata.dao.Project;
import com.featuresaccrossprojects.featuresdata.dto.ProjectDTO;
import com.featuresaccrossprojects.featuresdata.jparepo.ProjectRepo;
import com.featuresaccrossprojects.featuresdata.util.CacheUtil;
import com.featuresaccrossprojects.featuresdata.util.DaoToDtoConverter;
import com.featuresaccrossprojects.featuresdata.util.DtoToDaoConverter;
import com.featuresaccrossprojects.featuresdata.util.ResponseObject;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

@Service
public class ProjectDataService {

	@Autowired
	private DtoToDaoConverter dtoToDaoConverter;

	@Autowired
	private DaoToDtoConverter daoToDtoConverter;

	@Autowired
	private ProjectRepo projectRepo;

	@Autowired
	private CacheUtil cacheUtil;

	public ResponseObject addNewProject(ProjectDTO projectDTO) {
		ResponseObject responseObject = new ResponseObject();
		if (projectDTO != null && projectDTO.getProject_name() != null && projectDTO.getProject_name().length() > 0) {
			if (!isProjectExists(projectDTO)) {
				Project project = dtoToDaoConverter.copyProjectDTOToProject(projectDTO);
				if (project.getProject_name() != null && project.getProject_name().length() > 0) {
					projectRepo.save(project);
					responseObject.setError(false);
					responseObject.setMessage("Project added successfully!");
				}
			} else {
				responseObject.setError(true);
				responseObject.setMessage("Project already exists");
			}
		}
		return responseObject;
	}

	public boolean isProjectExists(ProjectDTO project) {
		boolean isProjectExist = false;
		if (project != null && project.getProject_name() != null && project.getProject_name().length() > 0) {
			isProjectExist = projectRepo.existsById(project.getProject_name());
		}
		return isProjectExist;
	}

	public ResponseObject getProjectList() {
		List<Project> projects = projectRepo.findAll();
		if (!CollectionUtils.isEmpty(projects)) {
			List<ProjectDTO> projectDTOs = daoToDtoConverter.copyProjectListToProjectDTOList(projects);
			if (!CollectionUtils.isEmpty(projectDTOs)) {
				// cache data
				cacheUtil.cacheProjectData(projectDTOs);
				return new ResponseObject(false, projectDTOs);
			}
		}
		return new ResponseObject(true, "Project not found");

	}

	public ResponseObject getProjectListCached() {
		Cache cache = CacheUtil.getCache(CacheUtil.EHCACHE_NAME);

		if (cache != null) {
			// Get the element from cache
			Element element = cache.get(CacheUtil.PROJECT_DATA_LIST);
			if (element != null) {
				List<ProjectDTO> projectDTOs = (List<ProjectDTO>) element.getObjectValue();
				if (!CollectionUtils.isEmpty(projectDTOs)) {
					return new ResponseObject(false, projectDTOs);
				}
			}
		}
		return new ResponseObject(true, "Cached Project List not found");

	}
}
