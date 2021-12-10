package com.astiservices.apirest.employee.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name = "tb_employee")
@ApiModel("Model Employee")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(generator = "employee_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "employee_generator", sequenceName = "s_employee_sequence", initialValue = 1, allocationSize = 1)
    @ApiModelProperty(value = "The employee's id", required = true)
    private Long idEmployee;

    @NotEmpty()
    @Size(max = 255)
    @ApiModelProperty(value = "The employee's name", required = true)
    private String nameEmployee;
    
    @NotEmpty()
    @Size(max = 255)
    @ApiModelProperty(value = "The employee's address", required = true)
    private String addressEmployee;
    
    @NotEmpty()
    @Size(max = 10)
    @ApiModelProperty(value = "The employee's phone number", required = true)
    private String phoneNumberEmployee;
    

    public Employee() {
    }
    
    public Long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Long idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public String getAddressEmployee() {
        return addressEmployee;
    }

    public void setAddressEmployee(String addressEmployee) {
        this.addressEmployee = addressEmployee;
    }

    public String getPhoneNumberEmployee() {
        return phoneNumberEmployee;
    }

    public void setPhoneNumberEmployee(String phoneNumberEmployee) {
        this.phoneNumberEmployee = phoneNumberEmployee;
    }
    
}
