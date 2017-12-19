package org.example.backend.service;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;
import org.example.backend.Schedule;

import java.sql.Timestamp;
import java.util.List;

@Repository(forEntity = Schedule.class)
public interface ScheduleRepository extends EntityRepository<Schedule, Integer> {

    List<Schedule> findByExcursionIdAndBeginningGreaterThanOrderByBeginning(Long id, Timestamp beginning);
}
