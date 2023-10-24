package com.souza.organizationservice.service.impl;


import com.souza.organizationservice.dto.OrganizationDto;
import com.souza.organizationservice.entity.Organization;
import com.souza.organizationservice.repository.OrganizationRespository;
import com.souza.organizationservice.service.OrganizationService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Setter
@Getter
@Service
public class OrganizationServiceImpl implements OrganizationService {

    private ModelMapper modelMapper;

    private OrganizationRespository organizationRespository;

    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        var organization = modelMapper.map(organizationDto, Organization.class);
        var savedOrganization = organizationRespository.save(organization);
        return modelMapper.map(savedOrganization, OrganizationDto.class);
    }

    public OrganizationDto getOrganizationByCode(String code) {
        var organization = organizationRespository.findByOrganizationCode(code);
        return modelMapper.map(organization, OrganizationDto.class);
    }
}
