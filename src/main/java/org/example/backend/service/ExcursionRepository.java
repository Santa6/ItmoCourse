package org.example.backend.service;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;
import org.example.backend.Excursion;

import java.util.List;

@Repository(forEntity = Excursion.class)
public interface ExcursionRepository extends EntityRepository<Excursion, Integer> {
    public List<Excursion> findByNameLikeIgnoreCase(String name);
}
