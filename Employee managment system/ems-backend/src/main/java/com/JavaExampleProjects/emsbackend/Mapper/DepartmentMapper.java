package com.JavaExampleProjects.emsbackend.Mapper;

import com.JavaExampleProjects.emsbackend.Dto.DepartmentDto;
import com.JavaExampleProjects.emsbackend.Entity.Department;

public class DepartmentMapper {

    //Konwersja department jpa entity do department dto

    public static DepartmentDto mapToDepartmentDto(Department department){
        return new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription()
        );
    }

    //Konwersja departmentDto do departmentJpa

    public static Department mapToDepartment(DepartmentDto departmentDto){
        return new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription()
        );
    }


}
