package com.entity;

import javax.persistence.*;

@Entity
@Table(name = "entries", schema = "s225127", catalog = "studs")
public class EntriesEntity {
    private int id;
    private String eMail;
    private int idSchedule;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    public int getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(int idSchedule) {
        this.idSchedule = idSchedule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntriesEntity that = (EntriesEntity) o;

        if (id != that.id) return false;
        if (idSchedule != that.idSchedule) return false;
        if (eMail != null ? !eMail.equals(that.eMail) : that.eMail != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (eMail != null ? eMail.hashCode() : 0);
        result = 31 * result + idSchedule;
        return result;
    }
}
