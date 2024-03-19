package com.JavaExampleProjects.emsbackend.Repository;

import com.JavaExampleProjects.emsbackend.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  EmployeeRepository extends JpaRepository<Employee, Long> {
}
