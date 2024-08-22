package com.example.springboot.services;

import com.example.springboot.entity.Department;
import com.example.springboot.error.DepartmentNotFoundException;
import com.example.springboot.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }
    @Override
    public List<Department> fetchDepartmentList(){
        return departmentRepository.findAll();
    }
    @Override
    public Optional<Department> fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department=departmentRepository.findById(departmentId);
        if(!department.isPresent()){
            throw new DepartmentNotFoundException("Department not found");
        }


        return Optional.of(department.get());
    }
    @Override
    public void deleteDepartmentById(Long departmentId){
        departmentRepository.deleteById(departmentId);
    }
    @Override
    public Department updateDepartment(Long departmentId,Department department){
        Department depDB=departmentRepository.findById(departmentId).get();
        if(Objects.nonNull(department.getDepartmentName())&&!"".equalsIgnoreCase(department.getDepartmentName())){
            department.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentCode())&&!"".equalsIgnoreCase(department.getDepartmentCode())){
            department.setDepartmentCode(department.getDepartmentCode());
        }
        if(Objects.nonNull(department.getDepartmentAddress())&&!"".equalsIgnoreCase(department.getDepartmentAddress())){
            department.setDepartmentAddress(department.getDepartmentAddress());
        }
      return departmentRepository.save(depDB);
    }


    @Override
    public Department fetchDepartmentByNameIgnoreCase(String departmentName){
        return departmentRepository.findByDepartmentName(departmentName);
    }
}
