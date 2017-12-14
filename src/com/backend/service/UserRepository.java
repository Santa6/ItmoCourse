package com.backend.service;

import com.backend.data.entity.EmployeeEntity;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository(forEntity = EmployeeEntity.class)
public interface UserRepository extends EntityRepository<EmployeeEntity, Integer>{
    public EmployeeEntity findById(Integer id);
}
