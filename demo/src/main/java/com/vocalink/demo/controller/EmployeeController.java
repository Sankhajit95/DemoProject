package com.vocalink.demo.controller;

import com.vocalink.demo.exception.EmployeeAlreadyPresentException;
import com.vocalink.demo.exception.NoEmployeePresentException;
import com.vocalink.demo.model.Employee;
import com.vocalink.demo.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/emp")
@Api(value = "Employee Resource REST Endpoint", description = "Shows Employee Info")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @ApiOperation(value = "For addding new employee")
    @PostMapping("/create")
    public String addEmployeeDetails(@RequestBody Employee employee) throws EmployeeAlreadyPresentException {
        return employeeService.saveEmployeeDetails(employee);
    }

    @ApiOperation(value = "For getting employee details by Id")
    @GetMapping("/{empId}")
    public Optional<Employee> getEmployeeDetails(@PathVariable Integer empId) {
        return employeeService.getEmployeeDetails(empId);
    }

    @ApiOperation(value = "For editing employee details")
    @PutMapping("/update")
    public String updateEmployeeDetails(@RequestBody Employee employee) throws NoEmployeePresentException {
        return employeeService.updateEmployeeDetails(employee);
    }

    @ApiOperation(value = "For deleting employee by Id")
    @DeleteMapping("/{empId}")
    public String deleteEmployeeDetails(@PathVariable Integer empId) {
        return employeeService.removeEmployeeDetails(empId);
    }
}
