package com.backend.data.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "schedule", schema = "s225127", catalog = "studs")
public class ScheduleEntity {
    private Integer id;
    private Timestamp beginning;
    private Timestamp ending;
    private Integer excursionId;
    private Integer idGuide;
    private Integer maxEntries;
    private String name;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
    public Integer getExcursionId() {
        return excursionId;
    }

    public void setExcursionId(Integer excursionId) {
        this.excursionId = excursionId;
    }

    @Basic
    @Column(name = "id_guide", nullable = false)
    public Integer getIdGuide() {
        return idGuide;
    }

    public void setIdGuide(Integer idGuide) {
        this.idGuide = idGuide;
    }

    @Basic
    @Column(name = "max_entries", nullable = false)
    public Integer getMaxEntries() {
        return maxEntries;
    }

    public void setMaxEntries(Integer maxEntries) {
        this.maxEntries = maxEntries;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScheduleEntity that = (ScheduleEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (beginning != null ? !beginning.equals(that.beginning) : that.beginning != null) return false;
        if (ending != null ? !ending.equals(that.ending) : that.ending != null) return false;
        if (excursionId != null ? !excursionId.equals(that.excursionId) : that.excursionId != null) return false;
        if (idGuide != null ? !idGuide.equals(that.idGuide) : that.idGuide != null) return false;
        if (maxEntries != null ? !maxEntries.equals(that.maxEntries) : that.maxEntries != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (beginning != null ? beginning.hashCode() : 0);
        result = 31 * result + (ending != null ? ending.hashCode() : 0);
        result = 31 * result + (excursionId != null ? excursionId.hashCode() : 0);
        result = 31 * result + (idGuide != null ? idGuide.hashCode() : 0);
        result = 31 * result + (maxEntries != null ? maxEntries.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
