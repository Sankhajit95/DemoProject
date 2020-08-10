package com.vocalink.demo.service;

import com.vocalink.demo.exception.EmployeeAlreadyPresentException;
import com.vocalink.demo.exception.NoEmployeePresentException;
import com.vocalink.demo.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    String saveEmployeeDetails(Employee employee) throws EmployeeAlreadyPresentException;

    Optional<Employee> getEmployeeDetails(Integer empId);
    
    List<Employee> getEmployeeDetailsList();

    String updateEmployeeDetails(Employee employee) throws NoEmployeePresentException;

    String removeEmployeeDetails(Integer empId);
}
