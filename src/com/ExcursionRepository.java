package com;

import com.backend.data.entity.ExcursionEntity;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface ExcursionRepository extends EntityRepository<ExcursionEntity, Integer> {
}
