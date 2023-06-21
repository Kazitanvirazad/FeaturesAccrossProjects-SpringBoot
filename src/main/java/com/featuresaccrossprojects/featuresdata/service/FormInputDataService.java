package com.featuresaccrossprojects.featuresdata.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.featuresaccrossprojects.featuresdata.dao.Category;
import com.featuresaccrossprojects.featuresdata.dao.Region;
import com.featuresaccrossprojects.featuresdata.dao.User;
import com.featuresaccrossprojects.featuresdata.dto.CategoryDTO;
import com.featuresaccrossprojects.featuresdata.dto.RegionDTO;
import com.featuresaccrossprojects.featuresdata.dto.UserDTO;
import com.featuresaccrossprojects.featuresdata.jparepo.CategoryRepo;
import com.featuresaccrossprojects.featuresdata.jparepo.ClientLeadRepo;
import com.featuresaccrossprojects.featuresdata.jparepo.DomainRepo;
import com.featuresaccrossprojects.featuresdata.jparepo.PracticeRepo;
import com.featuresaccrossprojects.featuresdata.jparepo.ProjectRepo;
import com.featuresaccrossprojects.featuresdata.jparepo.RegionRepo;
import com.featuresaccrossprojects.featuresdata.jparepo.SectorRepo;
import com.featuresaccrossprojects.featuresdata.jparepo.SubCategoryRepo;
import com.featuresaccrossprojects.featuresdata.jparepo.UserRepo;
import com.featuresaccrossprojects.featuresdata.util.DaoToDtoConverter;
import com.featuresaccrossprojects.featuresdata.util.ResponseObject;

@Service
public class FormInputDataService {

	@Autowired
	private DaoToDtoConverter daoToDtoConverter;// = new DaoToDtoConverter();

	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private ClientLeadRepo clientLeadRepo;

	@Autowired
	private RegionRepo regionRepo;

	@Autowired
	private SubCategoryRepo subCategoryRepo;

	@Autowired
	private DomainRepo domainRepo;

	@Autowired
	private PracticeRepo practiceRepo;

	@Autowired
	private SectorRepo sectorRepo;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ProjectRepo projectRepo;

	public ResponseObject getFormDropDownData() {
		ResponseObject responseObject = new ResponseObject();
		Map<String, Object> data_map = new HashMap<>();

		List<CategoryDTO> categoryDTOList = getCategoryData();
		if (!CollectionUtils.isEmpty(categoryDTOList))
			data_map.put("categories", categoryDTOList);

		List<String> clientTypes = getClientTypeData();
		if (!CollectionUtils.isEmpty(clientTypes))
			data_map.put("clientType", clientTypes);

		List<RegionDTO> regionDTOList = getRegionDTOData();
		if (!CollectionUtils.isEmpty(regionDTOList))
			data_map.put("regions", regionDTOList);

		List<String> subCategorieNames = getSubCategoryNameData();
		if (!CollectionUtils.isEmpty(subCategorieNames))
			data_map.put("subCategories", subCategorieNames);

		List<String> domainNames = getDomainNameData();
		if (!CollectionUtils.isEmpty(domainNames))
			data_map.put("domainNames", domainNames);

		List<String> practiceNames = getPracticeNameData();
		if (!CollectionUtils.isEmpty(practiceNames))
			data_map.put("practiceNames", practiceNames);

		List<String> sectorNames = getSectorNameData();
		if (!CollectionUtils.isEmpty(sectorNames))
			data_map.put("sectorNames", sectorNames);

		List<UserDTO> users = getUserDTOData();
		if (!CollectionUtils.isEmpty(users))
			data_map.put("projectContactPoint", users);

		List<String> projectNames = getProjectNames();
		if (!CollectionUtils.isEmpty(projectNames))
			data_map.put("projectNames", projectNames);

		if (!CollectionUtils.isEmpty(data_map)) {
			responseObject.setError(false);
			responseObject.setData(data_map);
			return responseObject;
		} else {
			responseObject.setError(true);
			responseObject.setMessage("Data not found!");
			return responseObject;
		}
	}

	public List<CategoryDTO> getCategoryData() {
		List<Category> categories = categoryRepo.findAllCategoryOnly();
		List<CategoryDTO> categoryDTOList = daoToDtoConverter.copyCategoryListToCategoryDTOList(categories);
		return categoryDTOList;
	}

	public List<String> getClientTypeData() {
		List<String> clList = clientLeadRepo.findAllClientType();
		return clList;
	}

	public List<RegionDTO> getRegionDTOData() {
		List<Region> regions = regionRepo.findAll();
		List<RegionDTO> regionDTOs = daoToDtoConverter.copyRegionListToRegionDTOList(regions);
		return regionDTOs;
	}

	public List<String> getSubCategoryNameData() {
		List<String> subCategories = subCategoryRepo.findAllSubCategoryName();
		return subCategories;
	}

	public List<String> getDomainNameData() {
		List<String> domainNames = domainRepo.findAllDomainName();
		return domainNames;
	}

	public List<String> getPracticeNameData() {
		List<String> practiceNames = practiceRepo.findAllPracticeName();
		return practiceNames;
	}

	public List<String> getSectorNameData() {
		List<String> sectorNames = sectorRepo.findAllSectorName();
		return sectorNames;
	}

	public List<UserDTO> getUserDTOData() {
		List<User> users = userRepo.findAll();
		List<UserDTO> userDTOs = daoToDtoConverter.copyUserListToUserDTOList(users);
		return userDTOs;
	}

	public List<String> getProjectNames() {
		List<String> projetNames = projectRepo.findAllProjectNames();
		return projetNames;
	}
}
