package com.dmuziga.demo.dao;

import com.dmuziga.demo.dto.DeptEmpDto;
import com.dmuziga.demo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

  @Query("SELECT new com.dmuziga.demo.dto.DeptEmpDto(e.name,e.email,d.description ) "
          + " FROM Employee e " +
          "JOIN Department d on e.id=d.id")
    public List<DeptEmpDto> fetchEmpDeptDataInnerJoin();

    public List<Department> findAll();



}
