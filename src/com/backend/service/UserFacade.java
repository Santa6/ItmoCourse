package com.backend.service;

import com.backend.data.entity.EmployeeEntity;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class UserFacade {

    @Inject
    private UserRepository userRepository;

    public EmployeeEntity findById(Integer id){
        try{
            return userRepository.findById(id);
        }
        catch (Exception e){
            return null;
        }
    }

    public EmployeeEntity save(EmployeeEntity employee){
        return userRepository.save(employee);
    }

}
