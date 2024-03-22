package com.JavaExampleProjects.emsbackend.Repository;

import com.JavaExampleProjects.emsbackend.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
