package com.example.springboot.controller;

import com.example.springboot.entity.Department;
import com.example.springboot.error.DepartmentNotFoundException;
import com.example.springboot.services.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER= LoggerFactory.getLogger(DepartmentController.class);
    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("you are in the department ");
      return departmentService.saveDepartment(department);
    }
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        return departmentService.fetchDepartmentList();
    }
    @GetMapping("/departments/{id}")
    public Optional<Department> fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
          return departmentService.fetchDepartmentById(departmentId);
    }
    @DeleteMapping("/department/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "department deleted successfully";
    }
    @PutMapping("/department/{id}")
    public Department updateDepartment(@PathVariable("id")Long departmentId, @RequestBody Department department){
        return departmentService.updateDepartment(departmentId,department);
    }
    @GetMapping("/department/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.fetchDepartmentByNameIgnoreCase(departmentName);
    }
}
