package org.example.backend.service;

import org.example.backend.Schedule;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.sql.Timestamp;
import java.util.List;

@Stateless
public class ScheduleFacade {

    @Inject
    private ScheduleRepository repository;

    public List<Schedule> findByExcursionId(Long id) {
        return repository.findByExcursionIdAndBeginningGreaterThanOrderByBeginning(id, new Timestamp(System.currentTimeMillis()));
    }
}
