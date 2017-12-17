package org.example.backend.service;

import org.example.backend.Employee;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository(forEntity = Employee.class)
public interface EmployeeRepository extends EntityRepository<Employee, Integer>{

    public Employee findById(Integer id);

}
