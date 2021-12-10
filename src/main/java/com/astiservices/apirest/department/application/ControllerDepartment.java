package com.astiservices.apirest.department.application;

import com.astiservices.apirest.department.domain.Department;
import com.astiservices.apirest.department.infrastructure.IRepositoryDepartment;
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
public class ControllerDepartment {

    @Autowired
    private IRepositoryDepartment repositoryDepartment;

    @RequestMapping(value = "/departments", method = RequestMethod.GET)
    @ApiOperation(value = "Find all departments", notes = "Return all departments")
    public List<Department> getAllDepartment() {
        return repositoryDepartment.findAll();
    }

    @RequestMapping(value = "/departments/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Find a department", notes = "Return a department by ID")
    public Department getDepartment(@PathVariable Long id) {
        Optional<Department> department = repositoryDepartment.findById(id);
        if(department.isPresent()){
            return department.get();
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/departments", method = RequestMethod.POST)
    @ApiOperation(value = "Create a department", notes = "Create a new department")
    public Boolean saveDepartment(@RequestBody Department department) {
        try {
            repositoryDepartment.save(department);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @RequestMapping(value = "/departments", method = RequestMethod.PUT)
    @ApiOperation(value = "Update a department", notes = "Update a department")
    public Boolean updateDepartment(@RequestBody Department department) {
        try {
            repositoryDepartment.save(department);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    @RequestMapping(value = "/departments/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Delete a department", notes = "Delete a department by ID")
    public Boolean deleteDepartment(@PathVariable Long id){
      try{
          repositoryDepartment.deleteById(id);
          return true;
      } catch (Exception e) {
          return false;
      }
    }    
}
