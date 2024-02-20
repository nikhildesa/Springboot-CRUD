package com.myprojects.springboottutorial.Controller;


import com.myprojects.springboottutorial.Entity.Department;
import com.myprojects.springboottutorial.service.DepartmentService;
import com.myprojects.springboottutorial.service.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class DepartmentController {


    @Autowired
    DepartmentService departmentService;

    @PostMapping("/departments")  // This is to add a department
    public Department saveDepartment(@RequestBody Department department){

        return departmentService.saveDepartment(department);

    }

    @GetMapping("/departments") // Get all departments
    public List<Department> fetchDepartmentList(){
        return departmentService.fetchDepartmentList();
    }

    @PostMapping("/departments/{id}") // Get department by id
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId){
        return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{id}") // Delete department by id
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        return departmentService.deleteDepartmentById(departmentId);
    }

    @PutMapping("departments/{id}") //Update department by id
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department){
        return departmentService.updateDepartment(departmentId, department);

    }

    @GetMapping("departments/{name}")  // Get department by name
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
        return departmentService.fetchDepartmentByName(departmentName);
    }



}
