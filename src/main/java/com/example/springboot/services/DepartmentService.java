package com.example.springboot.services;

import com.example.springboot.entity.Department;
import com.example.springboot.error.DepartmentNotFoundException;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Optional<Department> fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    public void deleteDepartmentById(Long departmentId);

    public Department updateDepartment(Long departmentId,Department department);

    public Department fetchDepartmentByNameIgnoreCase(String departmentName);
}
