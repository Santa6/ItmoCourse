package com;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private EntityManagerFactory entityManagerFactory;

    public EntityManager getFactory(){
        if (entityManagerFactory == null){
            entityManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        }
        return entityManagerFactory.createEntityManager();
    }
}
