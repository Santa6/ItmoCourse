package org.example.backend.service;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Matti Tahvonen
 */
public class CdiConfig {

    @Produces
    @Dependent
    @PersistenceContext(unitName = "dragondb")
    public EntityManager entityManager;
    
}
