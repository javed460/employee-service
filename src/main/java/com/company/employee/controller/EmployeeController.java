package com.company.employee.controller;

import com.company.employee.domain.Employee;
import com.company.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeRepository repository;

    @GetMapping
    public List<Employee> getEmployees() {
        return repository.findAllByTenant();
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        employee.setOrgId(com.company.employee.tenant.TenantContext.getTenantId());
        return repository.save(employee);
    }
}