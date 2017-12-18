package org.example.backend.service;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.Repository;
import org.example.backend.Entries;

@Repository(forEntity = Entries.class)
public interface EntryRepository extends EntityRepository<Entries, Integer> {
    void add();

    @Query("select count(*) from Entries e where e.schedule = ?1")
    Long countBySchedule(Long schedule);
}
