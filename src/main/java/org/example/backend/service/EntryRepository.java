package org.example.backend.service;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Modifying;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.Repository;
import org.example.backend.Entries;

import java.util.List;

@Repository(forEntity = Entries.class)
public interface EntryRepository extends EntityRepository<Entries, Integer> {
    @Query("select sum(e.count) from Entries e where e.schedule = ?1")
    List countByScheduleEqual(Long schedule);

    List<Entries> findByGenerated(Long generated);

    @Modifying
    @Query("delete from Entries e where e.generated = ?1")
    void removeByGenerated(Long generated);
}
