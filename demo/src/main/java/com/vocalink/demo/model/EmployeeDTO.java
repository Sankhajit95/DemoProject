package com.vocalink.demo.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO {

    private int empId;

    private String empName;

    private String email;

    private String password;

    private double salary;
}
