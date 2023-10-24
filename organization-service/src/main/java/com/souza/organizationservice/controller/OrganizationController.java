package com.souza.organizationservice.controller;

import com.souza.organizationservice.dto.OrganizationDto;
import com.souza.organizationservice.service.impl.OrganizationServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/organization")
@AllArgsConstructor
public class OrganizationController {

    private OrganizationServiceImpl organizationService;

    @PostMapping
    public ResponseEntity<OrganizationDto> saveOrganization(
            @RequestBody OrganizationDto organizationDto
    ) {
        var savedOrganization = organizationService.saveOrganization(organizationDto);
        return new ResponseEntity<>(savedOrganization, HttpStatus.CREATED);
    }

    @GetMapping("/{code}")
    public ResponseEntity<OrganizationDto> getOrganizationByCode(
            @PathVariable String code
    ) {
        var organization = organizationService.getOrganizationByCode(code);
        return new ResponseEntity<>(organization, HttpStatus.OK);
    }

}
