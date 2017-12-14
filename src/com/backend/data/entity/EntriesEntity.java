package com.backend.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "entries", schema = "s225127", catalog = "studs")
public class EntriesEntity {
    private Integer id;
    private String eMail;
    private Integer idSchedule;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

        EntriesEntity that = (EntriesEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (eMail != null ? !eMail.equals(that.eMail) : that.eMail != null) return false;
        if (idSchedule != null ? !idSchedule.equals(that.idSchedule) : that.idSchedule != null) return false;

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
