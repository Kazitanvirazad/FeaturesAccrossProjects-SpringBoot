package com.featuresaccrossprojects.featuresdata.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.featuresaccrossprojects.featuresdata.dao.Category;
import com.featuresaccrossprojects.featuresdata.dao.ClientLead;
import com.featuresaccrossprojects.featuresdata.dao.Domain;
import com.featuresaccrossprojects.featuresdata.dao.Feature;
import com.featuresaccrossprojects.featuresdata.dao.FeatureProject;
import com.featuresaccrossprojects.featuresdata.dao.Practice;
import com.featuresaccrossprojects.featuresdata.dao.Project;
import com.featuresaccrossprojects.featuresdata.dao.Region;
import com.featuresaccrossprojects.featuresdata.dao.Sector;
import com.featuresaccrossprojects.featuresdata.dao.SubCategory;
import com.featuresaccrossprojects.featuresdata.dao.User;
import com.featuresaccrossprojects.featuresdata.dto.CategoryDTO;
import com.featuresaccrossprojects.featuresdata.dto.ClientLeadDTO;
import com.featuresaccrossprojects.featuresdata.dto.DomainDTO;
import com.featuresaccrossprojects.featuresdata.dto.FeatureDTO;
import com.featuresaccrossprojects.featuresdata.dto.FeatureProjectDTO;
import com.featuresaccrossprojects.featuresdata.dto.PracticeDTO;
import com.featuresaccrossprojects.featuresdata.dto.ProjectDTO;
import com.featuresaccrossprojects.featuresdata.dto.RegionDTO;
import com.featuresaccrossprojects.featuresdata.dto.SectorDTO;
import com.featuresaccrossprojects.featuresdata.dto.SubCategoryDTO;
import com.featuresaccrossprojects.featuresdata.dto.UserDTO;

@Component
public class DaoToDtoConverter {

	public List<CategoryDTO> copyCategoryListToCategoryDTOList(List<Category> categoryList) {
		List<CategoryDTO> categoryDTOList = new ArrayList<>();

		if (!CollectionUtils.isEmpty(categoryList)) {
			for (Category category : categoryList) {
				if (category != null) {
					CategoryDTO categoryDTO = copyCategoryToCategoryDTO(category);
					categoryDTOList.add(categoryDTO);
				}
			}
		}
		return categoryDTOList;
	}

	public CategoryDTO copyCategoryToCategoryDTO(Category category) {
		CategoryDTO categoryDTO = new CategoryDTO();
		if (category != null) {
			categoryDTO.setCategory_name(category.getCategory_name());
			categoryDTO.setCategory_description(category.getCategory_description());
		}
		return categoryDTO;
	}

	public SubCategoryDTO copySubCategoryToSubCategoryDTO(SubCategory subCategory) {
		SubCategoryDTO subCategoryDTO = new SubCategoryDTO();
		if (subCategory != null) {
			subCategoryDTO.setSubcategory_name(subCategory.getSubcategory_name());
			subCategoryDTO.setSubcategory_description(subCategory.getSubcategory_description());
		}
		return subCategoryDTO;
	}

	public List<RegionDTO> copyRegionListToRegionDTOList(List<Region> regionList) {
		List<RegionDTO> regionDTOList = new ArrayList<>();

		if (!CollectionUtils.isEmpty(regionList)) {
			for (Region region : regionList) {
				if (region != null) {
					RegionDTO regionDTO = copyRegionToRegionDTO(region);
					regionDTOList.add(regionDTO);
				}
			}
		}
		return regionDTOList;
	}

	public RegionDTO copyRegionToRegionDTO(Region region) {
		RegionDTO regionDTO = new RegionDTO();
		if (region != null) {
			regionDTO.setRegion_id(region.getRegion_id());
			regionDTO.setRegion_name(region.getRegion_name());
		}
		return regionDTO;
	}

	public List<UserDTO> copyUserListToUserDTOList(List<User> users) {
		List<UserDTO> userDTOList = new ArrayList<>();

		if (!CollectionUtils.isEmpty(users)) {
			for (User user : users) {
				if (user != null) {
					UserDTO userDTO = copyUserToUserDTO(user);
					userDTOList.add(userDTO);
				}
			}
		}
		return userDTOList;
	}

	public UserDTO copyUserToUserDTO(User user) {
		UserDTO userDTO = new UserDTO();
		if (user != null) {
			userDTO.setUser_id(user.getUser_id());
			userDTO.setFirst_name(user.getFirst_name());
			userDTO.setLast_name(user.getLast_name());
		}
		return userDTO.setDisplayName();
	}

	public SectorDTO copySectorToSectorDTO(Sector sector) {
		SectorDTO sectorDTO = new SectorDTO();
		if (sector != null) {
			sectorDTO.setSector_name(sector.getSector_name());
		}
		return sectorDTO;
	}

	public ClientLeadDTO copyClientLeadToClientLeadDTO(ClientLead clientLead) {
		ClientLeadDTO clientLeadDTO = new ClientLeadDTO();
		if (clientLead != null) {
			clientLeadDTO.setClient_type(clientLead.getClient_type());
		}
		return clientLeadDTO;
	}

	public PracticeDTO copyPracticeToPracticeDTO(Practice practice) {
		PracticeDTO practiceDTO = new PracticeDTO();
		if (practice != null) {
			practiceDTO.setPractice_name(practice.getPractice_name());
		}
		return practiceDTO;
	}

	public DomainDTO copyDomainToDomainDTO(Domain domain) {
		DomainDTO domainDTO = new DomainDTO();
		if (domain != null) {
			domain.setDomain_name(domain.getDomain_name());
		}
		return domainDTO;
	}

	public List<ProjectDTO> copyProjectListToProjectDTOList(List<Project> projects) {
		List<ProjectDTO> projectDTOs = new ArrayList<>();

		if (!CollectionUtils.isEmpty(projects)) {
			for (Project project : projects) {
				ProjectDTO projectDTO = copyProjectToProjectDTO(project);
				projectDTOs.add(projectDTO);
			}
		}
		return projectDTOs;
	}

	public ProjectDTO copyProjectToProjectDTO(Project project) {
		ProjectDTO projectDTO = new ProjectDTO();
		if (project != null && project.getProject_name() != null && project.getProject_name().length() > 0) {
			projectDTO.setProject_name(project.getProject_name());
			projectDTO.setRegions(copyRegionListToRegionDTOList(project.getRegions()));
			projectDTO.setSector(copySectorToSectorDTO(project.getSector()));
			projectDTO.setProject_contact_point(copyUserToUserDTO(project.getProject_contact_point()));
			projectDTO.setMulti_brand(project.isMulti_brand());
			projectDTO.setBrandnames(project.getBrandnames());
			projectDTO.setMulti_site(project.isMulti_site());
			projectDTO.setProject_notes(project.getProject_notes());
			projectDTO.setLast_served_year(project.getLast_served_year());
			projectDTO.setClientLead(copyClientLeadToClientLeadDTO(project.getClientLead()));
			projectDTO.setPractice(copyPracticeToPracticeDTO(project.getPractice()));
			projectDTO.setDomain(copyDomainToDomainDTO(project.getDomain()));
		}
		return projectDTO;
	}

	public List<FeatureProjectDTO> copyFeatureProjectListToFeatureProjectDTOList(List<FeatureProject> featureProjects) {
		List<FeatureProjectDTO> featureProjectDTOs = new ArrayList<>();
		if (!CollectionUtils.isEmpty(featureProjects)) {
			for (FeatureProject featureProject : featureProjects) {
				FeatureProjectDTO featureProjectDTO = copyFeatureProjectToFeatureProjectDTO(featureProject);
				featureProjectDTOs.add(featureProjectDTO);
			}
		}
		return featureProjectDTOs;

	}

	public FeatureProjectDTO copyFeatureProjectToFeatureProjectDTO(FeatureProject featureProject) {
		FeatureProjectDTO featureProjectDTO = new FeatureProjectDTO();
		if (featureProject != null) {
			featureProjectDTO.setFeature(copyFeatureToFeatureDTO(featureProject.getFeature()));
			featureProjectDTO.setProject(copyProjectToProjectDTO(featureProject.getProject()));
			featureProjectDTO.setArtifact_detail(featureProject.getArtifact_detail());
			featureProjectDTO.setPoc(copyUserToUserDTO(featureProject.getPoc()));
			featureProjectDTO.setUsed_year(featureProject.getUsed_year());
			featureProjectDTO.setFeature_extended(featureProject.isFeature_extended());
			featureProjectDTO.setAlternate_poc(copyUserToUserDTO(featureProject.getAlternate_poc()));
		}
		return featureProjectDTO;
	}

	public FeatureDTO copyFeatureToFeatureDTO(Feature feature) {
		FeatureDTO featureDTO = new FeatureDTO();
		if (feature != null && feature.getFeature_ref() != null && feature.getFeature_ref().length() > 0) {
			featureDTO.setFeature_ref(feature.getFeature_ref());
			featureDTO.setFeature_name(feature.getFeature_name());
			featureDTO.setCategory(copyCategoryToCategoryDTO(feature.getCategory()));
			featureDTO.setSub_category(copySubCategoryToSubCategoryDTO(feature.getSub_category()));
			featureDTO.setDesc(feature.getDesc());
			featureDTO.setFeature_type(feature.getFeature_type());
			featureDTO.setProject_contact_point(copyUserToUserDTO(feature.getProject_contact_point()));
			featureDTO.setArtifact_detail(feature.getArtifact_detail());
			featureDTO.setUsed_year(feature.getUsed_year());
			featureDTO.setFeature_extended(feature.isFeature_extended());
			featureDTO.setAlternate_contact_point(copyUserToUserDTO(feature.getAlternate_contact_point()));
		}
		return featureDTO;
	}
}
