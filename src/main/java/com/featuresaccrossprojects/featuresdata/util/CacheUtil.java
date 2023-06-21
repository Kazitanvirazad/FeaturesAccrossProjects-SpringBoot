package com.featuresaccrossprojects.featuresdata.util;

import java.util.List;

import org.springframework.stereotype.Component;

import com.featuresaccrossprojects.featuresdata.dto.FeatureProjectDTO;
import com.featuresaccrossprojects.featuresdata.dto.ProjectDTO;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

@Component
public class CacheUtil {

	public static final String PROJECT_DATA_LIST = "ProjectDataList";
	public static final String EHCACHE_NAME = "apidatacache";

	public static Cache getCache(String config) {
		CacheManager cacheManager = CacheManager.getInstance();
		Cache cache = cacheManager.getCache(config);
		return cache;
	}

	public void cacheProjectData(List<ProjectDTO> projects) {
		Cache cache = CacheUtil.getCache(EHCACHE_NAME);
		if (cache != null) {
			cache.put(new Element(PROJECT_DATA_LIST, projects));
		}
	}

	public void cacheSearchFeatureProjectData(List<FeatureProjectDTO> featureProjects, String searchkey) {
		Cache cache = CacheUtil.getCache(EHCACHE_NAME);
		if (cache != null) {
			cache.put(new Element(searchkey, featureProjects));
		}
	}

}
