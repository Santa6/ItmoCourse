package org.example.backend.service;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;
import org.example.backend.Entries;

@Repository(forEntity = Entries.class)
public interface EntryRepository extends EntityRepository<Entries, Integer> {
    void add();
}
