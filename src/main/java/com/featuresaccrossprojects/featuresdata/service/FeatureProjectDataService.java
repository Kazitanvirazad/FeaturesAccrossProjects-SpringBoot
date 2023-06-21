package com.featuresaccrossprojects.featuresdata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.featuresaccrossprojects.featuresdata.dao.Feature;
import com.featuresaccrossprojects.featuresdata.dao.FeatureProject;
import com.featuresaccrossprojects.featuresdata.dao.Project;
import com.featuresaccrossprojects.featuresdata.dto.FeatureProjectDTO;
import com.featuresaccrossprojects.featuresdata.dto.ProjectDTO;
import com.featuresaccrossprojects.featuresdata.jparepo.FeatureProjectRepo;
import com.featuresaccrossprojects.featuresdata.util.CacheUtil;
import com.featuresaccrossprojects.featuresdata.util.DaoToDtoConverter;
import com.featuresaccrossprojects.featuresdata.util.ResponseObject;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

@Service
public class FeatureProjectDataService {

	@Autowired
	private FeatureProjectRepo featureProjectRepo;

	@Autowired
	private DaoToDtoConverter daoToDtoConverter;

	@Autowired
	private CacheUtil cacheUtil;

	@Transactional
	public void addFeatureProject(Feature feature, Project project) {
		if (feature != null && project != null) {
			FeatureProject featureProject = createFeatureProject(feature, project);
			featureProject = featureProjectRepo.save(featureProject);
		}
	}

	public FeatureProject createFeatureProject(Feature feature, Project project) {
		FeatureProject featureProject = new FeatureProject().setUniquePrimaryKeyValue();
		featureProject.setFeature(feature);
		featureProject.setProject(project);
		featureProject.setArtifact_detail(feature.getArtifact_detail());
		featureProject.setPoc(feature.getProject_contact_point());
		featureProject.setUsed_year(feature.getUsed_year());
		featureProject.setFeature_extended(feature.isFeature_extended());
		featureProject.setAlternate_poc(feature.getAlternate_contact_point());
		return featureProject;
	}

	public ResponseObject getFeatureProjectList() {
		List<FeatureProject> featureProjects = featureProjectRepo.findAll();
		List<FeatureProjectDTO> featureProjectDTOs = daoToDtoConverter
				.copyFeatureProjectListToFeatureProjectDTOList(featureProjects);

		if (!CollectionUtils.isEmpty(featureProjectDTOs))
			return new ResponseObject(false, featureProjectDTOs);
		return new ResponseObject(true, "Features not found!");
	}

	public ResponseObject getFeatureProjectSearchData(String searchkey) {
		List<FeatureProject> featureProjects = featureProjectRepo.findAllBySearchKey(searchkey);
		if (!CollectionUtils.isEmpty(featureProjects)) {
			List<FeatureProjectDTO> featureProjectDTOs = daoToDtoConverter
					.copyFeatureProjectListToFeatureProjectDTOList(featureProjects);
			if (!CollectionUtils.isEmpty(featureProjectDTOs)) {
				cacheUtil.cacheSearchFeatureProjectData(featureProjectDTOs, searchkey);
				return new ResponseObject(false, featureProjectDTOs);
			}
		}
		return new ResponseObject(true, "No search data found!");
	}

	public ResponseObject getFeatureProjectSearchDataCached(String searchkey) {
		Cache cache = CacheUtil.getCache(CacheUtil.EHCACHE_NAME);

		if (cache != null) {
			// Get the element from cache
			Element element = cache.get(searchkey);
			if (element != null) {
				List<FeatureProjectDTO> featureProjectDTOs = (List<FeatureProjectDTO>) element.getObjectValue();
				if (!CollectionUtils.isEmpty(featureProjectDTOs)) {
					return new ResponseObject(false, featureProjectDTOs);
				}
			}
		}
		return new ResponseObject(true, "No Cached search data found!");
	}

}
