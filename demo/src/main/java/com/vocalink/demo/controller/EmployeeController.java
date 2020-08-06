package com.vocalink.demo.controller;

import com.vocalink.demo.exception.EmployeeAlreadyPresentException;
import com.vocalink.demo.exception.NoEmployeePresentException;
import com.vocalink.demo.model.Employee;
import com.vocalink.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public String addEmployeeDetails(@RequestBody Employee employee) throws EmployeeAlreadyPresentException {
        return employeeService.saveEmployeeDetails(employee);
    }

    @GetMapping("/{empId}")
    public Optional<Employee> getEmployeeDetails(@PathVariable Integer empId) {
        return employeeService.getEmployeeDetails(empId);
    }

    @PutMapping("/update")
    public String updateEmployeeDetails(@RequestBody Employee employee) throws NoEmployeePresentException {
        return employeeService.updateEmployeeDetails(employee);
    }

    @DeleteMapping("/{empId}")
    public String deleteEmployeeDetails(@PathVariable Integer empId) {
        return employeeService.removeEmployeeDetails(empId);
    }
}
