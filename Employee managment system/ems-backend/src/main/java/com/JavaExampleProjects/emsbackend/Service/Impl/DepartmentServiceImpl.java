package com.JavaExampleProjects.emsbackend.Service.Impl;

import com.JavaExampleProjects.emsbackend.Dto.DepartmentDto;
import com.JavaExampleProjects.emsbackend.Entity.Department;
import com.JavaExampleProjects.emsbackend.Exception.ResourceNotFoundException;
import com.JavaExampleProjects.emsbackend.Mapper.DepartmentMapper;
import com.JavaExampleProjects.emsbackend.Repository.DepartmentRepository;
import com.JavaExampleProjects.emsbackend.Service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;
    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public DepartmentDto getDepartmentById(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(
                () -> new ResourceNotFoundException("Department is not exists with a given id: " + departmentId)
        );

        return DepartmentMapper.mapToDepartmentDto(department);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream().map((department) -> DepartmentMapper.mapToDepartmentDto(department))
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDto updateDepartment(Long departmentId, DepartmentDto updatedDepartment) {
        Department department  = departmentRepository.findById(departmentId).orElseThrow(
                () -> new ResourceNotFoundException("Department not exists with given ID: " + departmentId)
        );


        department.setDepartmentName(updatedDepartment.getDepartmentName());
        department.setDepartmentDescription(updatedDepartment.getDepartmentDescription());

        Department updatedDepartmentObj = departmentRepository.save(department);

        return DepartmentMapper.mapToDepartmentDto(updatedDepartmentObj);
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(
                () -> new ResourceNotFoundException("Department not exists with given ID: " + departmentId)
        );

        departmentRepository.delete(department);
    }


}
