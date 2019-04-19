package com.dmuziga.demo.dto;

public class DeptEmpDto {

    private String empName;
    private String empEmail;
    private String departmenDesc;

    public DeptEmpDto() {
    }

    public DeptEmpDto(String empName, String empEmail, String departmenDesc) {
        this.empName = empName;
        this.empEmail = empEmail;
        this.departmenDesc = departmenDesc;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getDepartmenDesc() {
        return departmenDesc;
    }

    public void setDepartmenDesc(String departmenDesc) {
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
