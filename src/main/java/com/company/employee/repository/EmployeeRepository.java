package com.company.employee.repository;

import com.company.employee.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e WHERE e.orgId = :#{T(com.company.employee.tenant.TenantContext).getTenantId()}")
    List<Employee> findAllByTenant();
}