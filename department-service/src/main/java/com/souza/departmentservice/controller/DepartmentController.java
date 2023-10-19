package com.souza.departmentservice.controller;

import com.souza.departmentservice.dto.DepartmentDto;
import com.souza.departmentservice.service.impl.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/department")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment( @RequestBody DepartmentDto departmentDto) {
        var savedDepartment = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping("/{code}")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(
            @PathVariable String code
            ) {
        var department = departmentService.getDepartmentByCode(code);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

}
