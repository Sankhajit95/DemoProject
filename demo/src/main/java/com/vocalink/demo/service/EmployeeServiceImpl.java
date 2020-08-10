package com.vocalink.demo.service;

import com.vocalink.demo.exception.EmployeeAlreadyPresentException;
import com.vocalink.demo.exception.NoEmployeePresentException;
import com.vocalink.demo.model.Employee;
import com.vocalink.demo.repository.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public String saveEmployeeDetails(Employee employee) throws EmployeeAlreadyPresentException {
        if(!employeeDao.existsById(employee.getEmpId())) {
            employeeDao.save(employee);
            return "Employee details saved successfully!";
        } else
            throw new EmployeeAlreadyPresentException("Employee already exists!");
    }

    @Override
    public Optional<Employee> getEmployeeDetails(Integer empId) {
        return employeeDao.findById(empId);
    }
    
    @Override
    public List<Employee> getEmployeeDetailsList() {
        return employeeDao.findAll();
    }

    @Override
    public String updateEmployeeDetails(Employee employee) throws NoEmployeePresentException {
        Employee existingEmployee = employeeDao.findById(employee.getEmpId()).orElse(null);
        if(null != existingEmployee) {
            existingEmployee.setEmpName(employee.getEmpName());
            employeeDao.save(existingEmployee);
            return "Employee details updated successfully!";
        } else
            throw new NoEmployeePresentException("Employee not found");
    }

    @Override
    public String removeEmployeeDetails(Integer empId) {
        employeeDao.deleteById(empId);
        return "Employee details deleted successfully!";
    }

}
