package com.souza.employeeservice.service.impl;

import com.souza.employeeservice.dto.ApiResponseDto;
import com.souza.employeeservice.dto.DepartmentDto;
import com.souza.employeeservice.dto.EmployeeDto;
import com.souza.employeeservice.dto.OrganizationDto;
import com.souza.employeeservice.entity.Employee;
import com.souza.employeeservice.exception.EmailAlreadyInUseException;
import com.souza.employeeservice.exception.ResourceNotFoundException;
import com.souza.employeeservice.repository.EmployeeRepository;
import com.souza.employeeservice.service.APIClient;
import com.souza.employeeservice.service.EmployeeService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


@Service
@AllArgsConstructor
public class EmployeeImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    private ModelMapper modelMapper;

    private WebClient webClient;

//    private APIClient  apiClient;

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

//    @CircuitBreaker(name = "${spring.application.name}", fallbackMethod =  "getDefaultDepartment")
    @Override
    public ApiResponseDto getEmployeeById(Long id) {
        var employee = employeeRepository.findById(id).get();


        DepartmentDto departmentDto = webClient
                .get()
                .uri("http://localhost:8080/api/department/" + employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();
        OrganizationDto organizationDto = webClient
                .get()
                .uri("http://localhost:8083/api/organization/" + employee.getOrganizationCode())
                .retrieve()
                .bodyToMono(OrganizationDto.class)
                .block();
        ApiResponseDto apiResponseDto = new ApiResponseDto();

        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
//        DepartmentDto departmentDto = apiClient.getDepartmentByCode(employee.getDepartmentCode());
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);
        apiResponseDto.setOrganizationDto(organizationDto);

        if(employee == null) {
            throw new ResourceNotFoundException("Employee id not found");
        }
        return apiResponseDto;
    }
}
