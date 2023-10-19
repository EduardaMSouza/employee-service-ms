package com.souza.employeeservice.service;

import com.souza.employeeservice.dto.EmployeeDto;
import com.souza.employeeservice.entity.Employee;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long id);
}
