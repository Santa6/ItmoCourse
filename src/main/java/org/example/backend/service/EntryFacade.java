package org.example.backend.service;

import org.example.backend.Entries;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class EntryFacade  {

    @Inject
    private EntryRepository repository;

    public Long countBySchedule(Long schedule){
        return (Long) repository.countByScheduleEqual(schedule).get(0);
    }

    public List<Entries> findByGenerated(Long generated){
        return repository.findByGenerated(generated);
    }

    public void removeByGenerated(Long generated) {
        repository.removeByGenerated(generated);
    }

    public void remove(Entries entry) {
        repository.remove(entry);
    }

    public void save(Entries entity) {
        repository.save(entity);
    }
}
