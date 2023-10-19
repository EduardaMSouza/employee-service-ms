package com.souza.departmentservice.repository;

import com.souza.departmentservice.dto.DepartmentDto;
import com.souza.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByDepartmentCode(String code);
}
