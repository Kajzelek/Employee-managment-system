package com.JavaExampleProjects.emsbackend.Service;

import com.JavaExampleProjects.emsbackend.Dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    public DepartmentDto createDepartment(DepartmentDto departmentDto);
    public DepartmentDto getDepartmentById(Long departmentId);
    public List<DepartmentDto> getAllDepartments();
    public DepartmentDto updateDepartment(Long departmentId, DepartmentDto updatedDepartment);
    void deleteDepartment(Long departmentId);
}
