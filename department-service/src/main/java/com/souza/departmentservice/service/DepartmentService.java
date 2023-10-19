package com.souza.departmentservice.service;

import com.souza.departmentservice.dto.DepartmentDto;
import com.souza.departmentservice.entity.Department;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentByCode(String code);
}
