package org.example.backend.service;

import org.example.backend.Employee;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class EmployeeFacade {
    @Inject
    private EmployeeRepository repository;


    public Employee findById(Long id) {
        return repository.findById(id);
    }
}
