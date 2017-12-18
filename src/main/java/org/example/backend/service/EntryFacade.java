package org.example.backend.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class EntryFacade  {

    @Inject
    private EntryRepository repository;

    public Long countBySchedule(Long schedule){
        return repository.countBySchedule(schedule);
    }
}