package com.beans;

import java.util.List;

public interface DBInterface {
    List getAllExcursions();

    List getAllSessions();

    List getAllDragons();

    int getFreePlacesCount(int schedule_id);

    void enroll(int schedule_id, String email);

    void addDragon(String name, String description, String photo);

    void addExcursion(String name, String description, boolean isActive, String photo);

    boolean removeRowFromTable(int id, String entityName);

    List getSessionsByExcursionId(int excursion_id);

    List getSessionsByGuideId(int guide_id);

    boolean authorize(int user_id, int password_hash);
}
