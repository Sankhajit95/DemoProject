package com.vocalink.demo.controller;

import com.vocalink.demo.exception.EmployeeAlreadyPresentException;
import com.vocalink.demo.exception.NoEmployeePresentException;
import com.vocalink.demo.model.Employee;
import com.vocalink.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping()
    public String addEmployeeDetails(@RequestBody Employee employee) throws EmployeeAlreadyPresentException {
        return employeeService.saveEmployeeDetails(employee);
    }

    @GetMapping("/{empId}")
    public ResponseEntity<Optional<Employee>> getEmployeeDetails(@PathVariable Integer empId) {
    	Optional<Employee> employee = employeeService.getEmployeeDetails(empId);
    	return  ResponseEntity.status(HttpStatus.OK).body(employee);
    }
    
    @GetMapping
    public ResponseEntity<List<Employee>> getEmployeeDetailsList() {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeeDetailsList());
    }
    

    @PutMapping
    public String updateEmployeeDetails(@RequestBody Employee employee) throws NoEmployeePresentException {
        return employeeService.updateEmployeeDetails(employee);
    }

    @DeleteMapping("/{empId}")
    public String deleteEmployeeDetails(@PathVariable Integer empId) {
        return employeeService.removeEmployeeDetails(empId);
    }
}
