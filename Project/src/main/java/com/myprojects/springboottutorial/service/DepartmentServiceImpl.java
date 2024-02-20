package com.myprojects.springboottutorial.service;

import com.myprojects.springboottutorial.Entity.Department;
import com.myprojects.springboottutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements  DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {

        return departmentRepository.save(department);

    }

    @Override
    public List<Department> fetchDepartmentList() {

        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) {

        return departmentRepository.findById(departmentId).get();

    }

    @Override
    public String deleteDepartmentById(Long departmentId) {

        departmentRepository.deleteById(departmentId);

        return "Deleted department for " + departmentId;
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {

        Department db = departmentRepository.findById(departmentId).get();

        if (Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
            db.setDepartmentName(department.getDepartmentName());
        }

        if (Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
            db.setDepartmentCode(department.getDepartmentCode());
        }

        if (Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            db.setDepartmentAddress(department.getDepartmentAddress());
        }

        return departmentRepository.save(db);

    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {

        List<Department> dbList = departmentRepository.findAll();
        int i = 0;
        Department db = null;
        for (i = 0; i < dbList.size(); i += 1) {
            db = dbList.get(i);
            if (Objects.equals(db.getDepartmentName(), departmentName)) {
                break;
            }
        }
        return db;
    }
}



