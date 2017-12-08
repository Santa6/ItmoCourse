package com.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "schedule", schema = "s223860", catalog = "studs")
@NamedQuery(name="Schedule.GetAll", query = "select excursions from ScheduleEntity excursions")
public class ScheduleEntity {
    private int id;
    private String name;
    private Timestamp beginning;
    private Timestamp ending;
    private int excursionId;
    private int idGuide;
    private int maxEntries;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name="name", nullable = false)
    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "beginning", nullable = false)
    public Timestamp getBeginning() {
        return beginning;
    }

    public void setBeginning(Timestamp beginning) {
        this.beginning = beginning;
    }

    @Basic
    @Column(name = "ending", nullable = false)
    public Timestamp getEnding() {
        return ending;
    }

    public void setEnding(Timestamp ending) {
        this.ending = ending;
    }

    @Basic
    @Column(name = "excursion_id", nullable = false)
    public int getExcursionId() {
        return excursionId;
    }

    public void setExcursionId(int excursionId) {
        this.excursionId = excursionId;
    }

    @Basic
    @Column(name = "id_guide", nullable = false)
    public int getIdGuide() {
        return idGuide;
    }

    public void setIdGuide(int idGuide) {
        this.idGuide = idGuide;
    }

    @Basic
    @Column(name = "max_entries", nullable = false)
    public int getMaxEntries() {
        return maxEntries;
    }

    public void setMaxEntries(int maxEntries) {
        this.maxEntries = maxEntries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScheduleEntity that = (ScheduleEntity) o;

        if (id != that.id) return false;
        if (excursionId != that.excursionId) return false;
        if (idGuide != that.idGuide) return false;
        if (maxEntries != that.maxEntries) return false;
        if (beginning != null ? !beginning.equals(that.beginning) : that.beginning != null) return false;
        if (ending != null ? !ending.equals(that.ending) : that.ending != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (beginning != null ? beginning.hashCode() : 0);
        result = 31 * result + (ending != null ? ending.hashCode() : 0);
        result = 31 * result + excursionId;
        result = 31 * result + idGuide;
        result = 31 * result + maxEntries;
        return result;
    }
}
