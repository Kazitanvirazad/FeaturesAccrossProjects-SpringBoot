package com.featuresaccrossprojects.featuresdata.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.featuresaccrossprojects.featuresdata.dao.ClientLead;
import com.featuresaccrossprojects.featuresdata.dao.Domain;
import com.featuresaccrossprojects.featuresdata.dao.Feature;
import com.featuresaccrossprojects.featuresdata.dao.Practice;
import com.featuresaccrossprojects.featuresdata.dao.Project;
import com.featuresaccrossprojects.featuresdata.dao.Sector;
import com.featuresaccrossprojects.featuresdata.dto.ClientLeadDTO;
import com.featuresaccrossprojects.featuresdata.dto.DomainDTO;
import com.featuresaccrossprojects.featuresdata.dto.FeatureDTO;
import com.featuresaccrossprojects.featuresdata.dto.PracticeDTO;
import com.featuresaccrossprojects.featuresdata.dto.ProjectDTO;
import com.featuresaccrossprojects.featuresdata.dto.SectorDTO;
import com.featuresaccrossprojects.featuresdata.service.CategoryDataService;
import com.featuresaccrossprojects.featuresdata.service.RegionDataService;
import com.featuresaccrossprojects.featuresdata.service.SubCategoryDataService;
import com.featuresaccrossprojects.featuresdata.service.UserDataService;

@Component
public class DtoToDaoConverter {

	@Autowired
	private RegionDataService regionDataService;

	@Autowired
	private UserDataService userDataService;

	@Autowired
	private CategoryDataService categoryDataService;

	@Autowired
	private SubCategoryDataService subCategoryDataService;

	public Project copyProjectDTOToProject(ProjectDTO projectDTO) {
		Project project = new Project().setUniqueIDValue();
		if (projectDTO != null) {
			project.setProject_name(projectDTO.getProject_name());
			project.setRegions(regionDataService.getRegions(projectDTO.getRegions()));
			project.setSector(copySectorDTOToSector(projectDTO.getSector()));
			String userId = projectDTO.getProject_contact_point() != null
					&& projectDTO.getProject_contact_point().getUser_id() != null
							? projectDTO.getProject_contact_point().getUser_id()
							: null;
			if (userId != null)
				project.setProject_contact_point(userDataService.getUserById(userId));
			project.setMulti_brand(projectDTO.isMulti_brand());
			project.setBrandnames(projectDTO.getBrandnames());
			project.setMulti_site(projectDTO.isMulti_site());
			project.setProject_notes(projectDTO.getProject_notes());
			project.setLast_served_year(projectDTO.getLast_served_year());
			project.setClientLead(copyClientLeadDTOToClientLead(projectDTO.getClientLead()));
			project.setPractice(copyPracticeDTOToPractice(projectDTO.getPractice()));
			project.setDomain(copyDomainDTOToDomain(projectDTO.getDomain()));
		}
		return project;
	}

	public Feature copyFeatureDTOToFeature(FeatureDTO featureDTO) {
		Feature feature = new Feature().setUniqueIDValue();
		if (featureDTO != null) {
			feature.setFeature_ref(featureDTO.getFeature_ref());
			feature.setFeature_name(featureDTO.getFeature_name());
			feature.setCategory(categoryDataService.getCategoryData(featureDTO.getCategory()));
			feature.setSub_category(subCategoryDataService.getSubCategoryData(featureDTO.getSub_category()));
			feature.setDesc(featureDTO.getDesc());
			feature.setFeature_type(featureDTO.getFeature_type());
			String userId = featureDTO.getProject_contact_point() != null
					&& featureDTO.getProject_contact_point().getUser_id() != null
							? featureDTO.getProject_contact_point().getUser_id()
							: null;
			if (userId != null)
				feature.setProject_contact_point(userDataService.getUserById(userId));
			feature.setArtifact_detail(featureDTO.getArtifact_detail());
			feature.setUsed_year(featureDTO.getUsed_year());
			feature.setFeature_extended(featureDTO.isFeature_extended());
			userId = featureDTO.getAlternate_contact_point() != null
					&& featureDTO.getAlternate_contact_point().getUser_id() != null
							? featureDTO.getAlternate_contact_point().getUser_id()
							: null;
			feature.setAlternate_contact_point(userDataService.getUserById(userId));
		}
		return feature;
	}

	public Sector copySectorDTOToSector(SectorDTO sectorDTO) {
		Sector sector = new Sector();
		if (sectorDTO != null) {
			sector.setSector_name(sectorDTO.getSector_name());
		}
		return sector;
	}

	public ClientLead copyClientLeadDTOToClientLead(ClientLeadDTO clientLeadDTO) {
		ClientLead clientLead = new ClientLead();
		if (clientLeadDTO != null) {
			clientLead.setClient_type(clientLeadDTO.getClient_type());
		}
		return clientLead;
	}

	public Practice copyPracticeDTOToPractice(PracticeDTO practiceDTO) {
		Practice practice = new Practice();
		if (practiceDTO != null) {
			practice.setPractice_name(practiceDTO.getPractice_name());
		}
		return practice;
	}

	public Domain copyDomainDTOToDomain(DomainDTO domainDTO) {
		Domain domain = new Domain();
		if (domainDTO != null) {
			domain.setDomain_name(domainDTO.getDomain_name());
		}
		return domain;
	}
}
