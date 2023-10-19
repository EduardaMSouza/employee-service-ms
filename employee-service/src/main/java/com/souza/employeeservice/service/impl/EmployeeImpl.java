package com.souza.employeeservice.service.impl;

import com.souza.employeeservice.dto.EmployeeDto;
import com.souza.employeeservice.entity.Employee;
import com.souza.employeeservice.exception.EmailAlreadyInUseException;
import com.souza.employeeservice.exception.ResourceNotFoundException;
import com.souza.employeeservice.repository.EmployeeRepository;
import com.souza.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class EmployeeImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    private ModelMapper modelMapper;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        var existingEmployee = employeeRepository.existsByEmail(employeeDto.getEmail());
        if(existingEmployee) {
            throw new EmailAlreadyInUseException("Email already in use");
        }
        var employee = modelMapper.map(employeeDto, Employee.class);
        var savedEmployee = employeeRepository.save(employee);
        return modelMapper.map(savedEmployee, EmployeeDto.class);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        var employee = employeeRepository.findById(id);
        System.out.println(employee);
        if(employee.isEmpty()) {
            throw new ResourceNotFoundException("Employee id not found");
        }
        return modelMapper.map(employee, EmployeeDto.class);
    }
}
