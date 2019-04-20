package com.dmuziga.demo.service;


import com.dmuziga.demo.dao.DepartmentRepository;
import com.dmuziga.demo.dto.DeptEmpDto;
import com.dmuziga.demo.entity.Department;

import java.util.List;


public interface DepartmentService  {

    public List<Department> findAll();
    public List<DeptEmpDto> customeQuery();
    public void createExcelFile(String filePath, List<DeptEmpDto> deptEmpDtos);






}
