package com.dmuziga.demo.service;

import com.dmuziga.demo.dao.DepartmentRepository;

import com.dmuziga.demo.dto.DeptEmpDto;
import com.dmuziga.demo.entity.Department;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
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

    @Override
    public void createExcelFile(String filePath, List<DeptEmpDto> deptEmpDtos) {

        if (filePath!=null && !"".equals(filePath.trim())){

            try
            {
                /* Create excel workbook. */
                Workbook excelWookBook = new XSSFWorkbook();

                /* */
                CreationHelper createHelper = excelWookBook.getCreationHelper();

                /* Create employee info sheet. */
                Sheet departmentEmpSheet = excelWookBook.createSheet("Department Info and Employee");

                // Create a Font for styling header cells
                Font headerFont = excelWookBook.createFont();
                headerFont.setBold(true);
                headerFont.setFontHeightInPoints((short) 14);
                headerFont.setColor(IndexedColors.RED.getIndex());

                // Create a CellStyle with the font
                CellStyle headerCellStyle = excelWookBook.createCellStyle();
                headerCellStyle.setFont(headerFont);

                /* Create employee info row. Row number start with 0.
                 * The input parameter for method createRow(int rowNumber) is the row number that will be created.
                 * */

                /* First create header row. */
                Row headerRow = departmentEmpSheet.createRow(0);

                headerRow.createCell(0).setCellValue("Name");
                headerRow.createCell(1).setCellValue("Email");
                headerRow.createCell(2).setCellValue("Department");


                /* Loop for the department dto list, add each employee data info with the department into one row. */
                if(deptEmpDtos!=null)
                {
                    int size = deptEmpDtos.size();
                    for(int i=0;i<size;i++)
                    {
                        DeptEmpDto eDto = deptEmpDtos.get(i);

                        /* Create row to save employee info. */
                        Row row = departmentEmpSheet.createRow(i+1);

                        row.createCell(0).setCellValue(eDto.getEmpName());
                        row.createCell(1).setCellValue(eDto.getEmpEmail());
                        row.createCell(2).setCellValue(eDto.getDepartmenDesc());

                    }
                }

                /* Write to excel file */
                FileOutputStream fOut = new FileOutputStream(filePath);
                excelWookBook.write(fOut);
                fOut.close();

                System.out.println("File " + filePath + " is created successfully. ");
            }catch(Exception ex)
            {
                ex.printStackTrace();
            }

        }



    }
}
