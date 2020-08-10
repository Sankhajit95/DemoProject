package com.vocalink.demo.controller;

import com.vocalink.demo.exception.EmployeeAlreadyPresentException;
import com.vocalink.demo.exception.NoEmployeePresentException;
import com.vocalink.demo.model.Employee;
import com.vocalink.demo.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@RestController
@CrossOrigin

@RequestMapping("/employees")

@Api(value = "Employee Resource REST Endpoint", description = "Shows Employee Info")

public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


   
    @ApiOperation(value = "For addding new employee")
    @PostMapping()
    public String addEmployeeDetails( @RequestBody Employee employee) throws EmployeeAlreadyPresentException {
        return employeeService.saveEmployeeDetails(employee);
    }

    @ApiOperation(value = "For getting employee details by Id")
    @GetMapping("/{empId}")
    public ResponseEntity<Optional<Employee>> getEmployeeDetails(@PathVariable Integer empId) {
    	Optional<Employee> employee = employeeService.getEmployeeDetails(empId);
    	return  ResponseEntity.status(HttpStatus.OK).body(employee);
    }
    
    @ApiOperation(value = "For getting all employee details")
    @GetMapping
    public ResponseEntity<List<Employee>> getEmployeeDetailsList() {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeeDetailsList());
    }
    
    @ApiOperation(value = "For editing employee details")
    @PutMapping
    public String updateEmployeeDetails( @RequestBody Employee employee) throws NoEmployeePresentException {
        return employeeService.updateEmployeeDetails(employee);
    }

    @ApiOperation(value = "For deleting employee by Id")
    @DeleteMapping("/{empId}")
    public String deleteEmployeeDetails(@PathVariable Integer empId) {
        return employeeService.removeEmployeeDetails(empId);
    }
}
