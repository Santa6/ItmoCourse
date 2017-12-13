package com;

import com.backend.data.entity.ScheduleEntity;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface ScheduleRepository extends EntityRepository<ScheduleEntity, Integer> {

}
