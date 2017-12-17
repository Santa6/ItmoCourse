package org.example.backend.service;

import org.example.backend.Dragon;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class DragonFacade {

    @Inject
    DragonRepository repository;

    public void remove(Dragon dragon){
        repository.remove(repository.findBy(dragon.getId()));
    }

    public List<Dragon> findAll() {
        return repository.findAll();
    }

    public Dragon save(Dragon entity) {
        return repository.save(entity);
    }
}
