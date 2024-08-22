package com.example.springboot.repository;

import com.example.springboot.entity.Department;
import com.example.springboot.services.DepartmentService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
   public Department findByDepartmentName(String departmentName);
   public Department findByDepartmentNameIgnoreCase(String departmentName);


}
