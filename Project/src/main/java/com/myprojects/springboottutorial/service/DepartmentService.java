package com.myprojects.springboottutorial.service;

import com.myprojects.springboottutorial.Entity.Department;

import java.util.List;

public interface DepartmentService {

    public Department saveDepartment(Department department);

    List<Department> fetchDepartmentList();

    Department fetchDepartmentById(Long departmentId);

    String deleteDepartmentById(Long departmentId);

    Department updateDepartment(Long departmentId, Department department);

    Department fetchDepartmentByName(String departmentName);
}
