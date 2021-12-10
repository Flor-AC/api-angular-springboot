package com.astiservices.apirest.department.infrastructure;

import com.astiservices.apirest.department.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryDepartment extends JpaRepository<Department,Long>{
    
}
