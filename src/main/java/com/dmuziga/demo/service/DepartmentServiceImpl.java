package com.dmuziga.demo.service;

import com.dmuziga.demo.dao.DepartmentRepository;

import com.dmuziga.demo.dto.DeptEmpDto;
import com.dmuziga.demo.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;


    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    public List<DeptEmpDto> customeQuery() {

        return departmentRepository.fetchEmpDeptDataInnerJoin();
    }


}
