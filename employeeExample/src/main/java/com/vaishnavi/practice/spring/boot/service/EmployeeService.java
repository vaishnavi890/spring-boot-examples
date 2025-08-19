package com.vaishnavi.practice.spring.boot.service;

import com.vaishnavi.practice.spring.boot.model.Employee;
import com.vaishnavi.practice.spring.boot.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return repository.findById(id);
    }

    public Employee addEmployee(Employee employee) {
        return repository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employeeDetails) {
        return repository.findById(id)
                .map(emp -> {
                    emp.setName(employeeDetails.getName());
                    emp.setRole(employeeDetails.getRole());
                    return repository.save(emp);
                }).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}
