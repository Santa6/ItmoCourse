package org.example.backend.service;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;
import org.example.backend.Schedule;

@Repository(forEntity = Schedule.class)
public interface ScheduleRepository extends EntityRepository<Schedule, Integer> {

}
