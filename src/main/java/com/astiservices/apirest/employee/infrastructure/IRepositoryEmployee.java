package com.astiservices.apirest.employee.infrastructure;

import com.astiservices.apirest.employee.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryEmployee extends JpaRepository<Employee, Long>{
    
}
