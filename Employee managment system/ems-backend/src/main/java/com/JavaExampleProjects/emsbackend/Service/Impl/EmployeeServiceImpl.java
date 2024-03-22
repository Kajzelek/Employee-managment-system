package com.JavaExampleProjects.emsbackend.Service.Impl;

import com.JavaExampleProjects.emsbackend.Dto.EmployeeDto;
import com.JavaExampleProjects.emsbackend.Entity.Employee;
import com.JavaExampleProjects.emsbackend.Mapper.EmployeeMapper;
import com.JavaExampleProjects.emsbackend.Repository.EmployeeRepository;
import com.JavaExampleProjects.emsbackend.Service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployee(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId).
                orElseThrow(() ->
                        new ResourceAccessException("Employee is not exist with given id: " + employeeId));
        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);
        return employeeDto;
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {

        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());

        /*

        krótki opis działania tego Returna

        1) employees.stream() -> Lista employees zamieniana jest w strumień, na którym można dokonywać pewnych modyfikacji
        2) .map((employee) -> EmployeeMapper.mapToEmployeeDto(employee)) -> W strumieniu mapowane są obiekty
           nazwane jako employee typu (Employee), a następnie przekształcane są w obiekty typu (EmployeeDto)
        3).collect(Collectors.toList()); -> Zmodyfikowany strumień finalnie zostaje przekształcony w liste

        * */

    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceAccessException("Employee is not exists with given id: " + employeeId)
        );

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        Employee updatedEmployeeObj = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);

    }

    @Override
    public void deleteEmployee(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceAccessException("Employee is not exists with given id: " + employeeId)
        );

        employeeRepository.delete(employee);
    }
}
