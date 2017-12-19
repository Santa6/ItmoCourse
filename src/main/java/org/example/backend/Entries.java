package org.example.backend;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Entries extends AbstractEntity{
    @Id
    private Long id;
    private String eMail;
    private Long schedule;
    private Long generated;

    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "e_mail", nullable = false, length = -1)
    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    @Basic
    @Column(name = "id_schedule", nullable = false)
    public Long getSchedule() {
        return schedule;
    }

    public void setSchedule(Long idSchedule) {
        this.schedule = idSchedule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entries entries = (Entries) o;

        if (id != null ? !id.equals(entries.id) : entries.id != null) return false;
        if (eMail != null ? !eMail.equals(entries.eMail) : entries.eMail != null) return false;
        if (schedule != null ? !schedule.equals(entries.schedule) : entries.schedule != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (eMail != null ? eMail.hashCode() : 0);
        result = 31 * result + (schedule != null ? schedule.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "generated", nullable = false)
    public Long getGenerated() {
        return generated;
    }

    public void setGenerated(Long generated) {
        this.generated = generated;
    }
}
