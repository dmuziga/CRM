package com.dmuziga.demo.controller;

import com.dmuziga.demo.dto.DeptEmpDto;
import com.dmuziga.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    LocalDate localDate = LocalDate.now();

    String excelFilePath = "D:/PersonalProject/Data/" + localDate.toString() + ".xlsx";


        @GetMapping("/list")
        public String listDepartment(Model theModel){

            List<DeptEmpDto> thedepartments = departmentService.customeQuery();

            departmentService.createExcelFile(excelFilePath,thedepartments);



            theModel.addAttribute("departmentemp", thedepartments);

            return "departments/list-departments";
        }


    }


