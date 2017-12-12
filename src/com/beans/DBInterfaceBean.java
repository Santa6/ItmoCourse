package com.beans;

import com.JPAUtil;
import com.entity.*;


import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

@Stateless
public class DBInterfaceBean implements Serializable, DBInterface{
    private EntityManager entityManager;

    public DBInterfaceBean(){
        entityManager = new JPAUtil().getFactory();
    }

    @PostConstruct
    public void init(){
        entityManager = new JPAUtil().getFactory();
    }

    public List getAllExcursions(){
        return entityManager.createNamedQuery("Excursions.GetAll").getResultList();
    }

    public List getAllSessions(){
        return entityManager.createNamedQuery("Schedule.GetAll").getResultList();
    }

    public List getAllDragons(){
        return entityManager.createNamedQuery("Dragons.GetAll").getResultList();
    }

    public int getFreePlacesCount(int schedule_id){
        ScheduleEntity scheduleEntity = (ScheduleEntity) entityManager.createQuery("from ScheduleEntity s where s.id = :schedule_id").setParameter("schedule_id", schedule_id).getSingleResult();
        return scheduleEntity.getMaxEntries() - entityManager.createQuery("from EntriesEntity e where e.idSchedule = :schedule_id").setParameter("schedule_id", schedule_id).getResultList().size();
    }

    public void enroll(int schedule_id, String email){
        EntriesEntity entry = new EntriesEntity();
        entry.seteMail(email);
        entry.setIdSchedule(schedule_id);
        entityManager.persist(entry);
    }

    public void addDragon(String name, String description, String photo){
        DragonEntity dragon = new DragonEntity();
        dragon.setName(name);
        dragon.setDescription(description);
        dragon.setPhoto(photo);
        entityManager.persist(dragon);
    }

    public void addExcursion(String name, String description, boolean isActive, String photo){
        ExcursionEntity excursion = new ExcursionEntity();
        excursion.setName(name);
        excursion.setDescription(description);
        excursion.setActive(isActive);
        excursion.setPhoto(photo);
        entityManager.persist(excursion);
    }

    public boolean removeRowFromTable(int id, String entityName){
        return entityManager.createQuery("delete from " + entityName + " t where t.id=:id")
                         .setParameter("id", id).executeUpdate() == 0;
    }

    public List getSessionsByExcursionId(int excursion_id){
        return entityManager.createQuery("from ScheduleEntity s where s.excursionId = :excursion_id")
                            .setParameter("excursion_id", excursion_id).getResultList();
    }

    public List getSessionsByGuideId(int guide_id){
        return entityManager.createQuery("from ScheduleEntity s where s.idGuide = :guide_id")
                            .setParameter("guide_id", guide_id).getResultList();
    }

    public boolean authorize(int user_id, int password_hash){
        EmployeeEntity user = entityManager.find(EmployeeEntity.class, user_id);
        return user.getPasswordHash() == password_hash;
    }
}
