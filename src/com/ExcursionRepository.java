package com;

import com.backend.data.entity.ExcursionEntity;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import java.util.List;

@Repository(forEntity = ExcursionEntity.class)
public interface ExcursionRepository extends EntityRepository<ExcursionEntity, Integer> {
    public List<ExcursionEntity> findByNameLikeIgnoreCase(String name);
}
