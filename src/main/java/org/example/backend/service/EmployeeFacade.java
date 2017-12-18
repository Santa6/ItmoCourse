package org.example.backend.service;

import org.example.backend.Employee;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.Serializable;

@Stateless
public class EmployeeFacade implements Serializable{
    @Inject
    private EmployeeRepository repository;


    public Employee findById(Long id) {
        return repository.findById(id);
    }
}
