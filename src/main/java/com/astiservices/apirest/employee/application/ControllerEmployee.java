package com.astiservices.apirest.employee.application;

import com.astiservices.apirest.employee.domain.Employee;
import com.astiservices.apirest.employee.infrastructure.IRepositoryEmployee;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ControllerEmployee {
    
    @Autowired
    private IRepositoryEmployee respositoryEmployees;
    
    @RequestMapping(value="/employees", method = RequestMethod.GET)
    @ApiOperation(value = "Find all employees", notes = "Return all empoyees")
    public List<Employee> getAllEmployees(){
        return respositoryEmployees.findAll();
    }
    
    @RequestMapping(value="/employees/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Find a employee", notes = "Return a empoyee by ID")
    public Employee getEmployee(@PathVariable Long id){
        Optional<Employee> employees = respositoryEmployees.findById(id);
        if(employees.isPresent()){
            return employees.get();
        } else {
            return null;
        }
    }
    
    @RequestMapping(value="/employees", method = RequestMethod.POST)
    @ApiOperation(value = "Create an employee", notes = "Create a new employee")
    public boolean saveEmployee(@RequestBody Employee employee){
        try {
            respositoryEmployees.save(employee);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    @RequestMapping(value="/employees", method = RequestMethod.PUT)
    @ApiOperation(value = "Update an employee", notes = "Update an employee")
    public boolean updateEmployee(@RequestBody Employee employee){
        try {
            respositoryEmployees.save(employee);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    @RequestMapping(value="/employees/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Delete an employee", notes = "Delete an employee by ID")
    public boolean deleteEmployee(@PathVariable Long id){
        try {
            respositoryEmployees.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
