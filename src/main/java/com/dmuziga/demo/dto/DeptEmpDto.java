package com.dmuziga.demo.dto;

import lombok.Data;

@Data
public class DeptEmpDto {

    private String empName;
    private String empEmail;
    private String departmenDesc;

    public DeptEmpDto(String empName, String empEmail, String departmenDesc) {
        this.empName = empName;
        this.empEmail = empEmail;
        this.departmenDesc = departmenDesc;
    }


    @Override
    public String toString() {
        return "DeptEmpDto{" +
                "empName='" + empName + '\'' +
                ", empEmail='" + empEmail + '\'' +
                ", departmenDesc='" + departmenDesc + '\'' +
                '}';
    }
}
