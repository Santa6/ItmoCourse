package org.example.backend;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Schedule extends AbstractEntity{
    @Id
    private Long id;
    private Timestamp beginning;
    private Timestamp ending;
    private Integer excursionId;
    private Integer idGuide;
    private Integer maxEntries;
    private String name;

    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

        Schedule schedule = (Schedule) o;

        if (id != null ? !id.equals(schedule.id) : schedule.id != null) return false;
        if (beginning != null ? !beginning.equals(schedule.beginning) : schedule.beginning != null) return false;
        if (ending != null ? !ending.equals(schedule.ending) : schedule.ending != null) return false;
        if (excursionId != null ? !excursionId.equals(schedule.excursionId) : schedule.excursionId != null)
            return false;
        if (idGuide != null ? !idGuide.equals(schedule.idGuide) : schedule.idGuide != null) return false;
        if (maxEntries != null ? !maxEntries.equals(schedule.maxEntries) : schedule.maxEntries != null) return false;
        if (name != null ? !name.equals(schedule.name) : schedule.name != null) return false;

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
