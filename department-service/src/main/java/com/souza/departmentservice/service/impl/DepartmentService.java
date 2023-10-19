package com.souza.departmentservice.service.impl;

import com.souza.departmentservice.dto.DepartmentDto;
import com.souza.departmentservice.entity.Department;
import com.souza.departmentservice.exception.ResourceNotFoundException;
import com.souza.departmentservice.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class DepartmentService implements com.souza.departmentservice.service.DepartmentService {

    private DepartmentRepository departmentRepository;

    private ModelMapper modelMapper;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        var department = modelMapper.map(departmentDto, Department.class);

        var savedDepartment = departmentRepository.save(department);

        return modelMapper.map(savedDepartment, DepartmentDto.class);
    }

    @Override
    public DepartmentDto getDepartmentByCode(String code) {
        var department = departmentRepository.findByDepartmentCode(code);
        if(department == null) {
            throw new ResourceNotFoundException("Department not found");
        }
        var departmentDto = modelMapper.map(department, DepartmentDto.class);
        return departmentDto;
    }
}
