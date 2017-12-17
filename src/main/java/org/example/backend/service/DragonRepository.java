package org.example.backend.service;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;
import org.example.backend.Dragon;

@Repository(forEntity = Dragon.class)
public interface DragonRepository extends EntityRepository<Dragon, Integer>{
}
