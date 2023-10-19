package com.souza.employeeservice.service;

import com.souza.employeeservice.dto.ApiResponseDto;
import com.souza.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    ApiResponseDto getEmployeeById(Long id);
}
