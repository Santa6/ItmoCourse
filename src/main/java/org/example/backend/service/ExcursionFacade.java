package org.example.backend.service;

import org.example.backend.Dragon;
import org.example.backend.Excursion;


import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;


@Stateless
public class ExcursionFacade{

    @Inject
    private ExcursionRepository repository;

    public void remove(Excursion excursion){
        repository.remove(repository.findBy(excursion.getId()));
    }

    public List<Excursion> findAll() {
        return repository.findAll();
    }

    public Excursion save(Excursion entity) {
        return repository.save(entity);
    }
}
