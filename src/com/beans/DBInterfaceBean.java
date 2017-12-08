package com.beans;

import com.JPAUtil;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import java.util.List;

@Stateful(name = "DBInterfaceEJB")
public class DBInterfaceBean {
    private EntityManager entityManager;

    public DBInterfaceBean() {
        entityManager = new JPAUtil().getFactory();
    }

    public List getAllExcursions(){
        return entityManager.createNamedQuery("Schedule.GetAll").getResultList();
    }

}
