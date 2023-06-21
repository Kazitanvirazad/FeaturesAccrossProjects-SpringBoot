package com.featuresaccrossprojects.featuresdata.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.featuresaccrossprojects.featuresdata.dao.Region;
import com.featuresaccrossprojects.featuresdata.dto.RegionDTO;
import com.featuresaccrossprojects.featuresdata.jparepo.RegionRepo;

@Service
public class RegionDataService {

	@Autowired
	private RegionRepo regionRepo;

	public List<Region> getRegions(List<RegionDTO> regionDTOs) {
		List<Region> regions = new ArrayList<>();
		if (!CollectionUtils.isEmpty(regionDTOs)) {
			regions = regionRepo.findAllById(getRegionIDs(regionDTOs));
		}
		return regions;
	}

	public List<String> getRegionIDs(List<RegionDTO> regionDTOs) {
		List<String> regionIds = new ArrayList<>();
		if (!CollectionUtils.isEmpty(regionDTOs)) {
			for (RegionDTO regionDTO : regionDTOs) {
				regionIds.add(regionDTO.getRegion_id());
			}
		}
		return regionIds;
	}
}
