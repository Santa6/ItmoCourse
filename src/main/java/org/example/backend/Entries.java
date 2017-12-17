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
    private Integer idSchedule;

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
    public Integer getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(Integer idSchedule) {
        this.idSchedule = idSchedule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entries entries = (Entries) o;

        if (id != null ? !id.equals(entries.id) : entries.id != null) return false;
        if (eMail != null ? !eMail.equals(entries.eMail) : entries.eMail != null) return false;
        if (idSchedule != null ? !idSchedule.equals(entries.idSchedule) : entries.idSchedule != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (eMail != null ? eMail.hashCode() : 0);
        result = 31 * result + (idSchedule != null ? idSchedule.hashCode() : 0);
        return result;
    }
}
