package com.souza.organizationservice.repository;

import com.souza.organizationservice.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRespository extends JpaRepository<Organization, Long> {
    Organization findByOrganizationCode(String code);
}
