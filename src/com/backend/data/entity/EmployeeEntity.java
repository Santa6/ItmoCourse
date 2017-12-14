package com.backend.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "employee", schema = "s225127", catalog = "studs")
public class EmployeeEntity {
    private Integer id;
    private String name;
    private Integer passwordHash;
    private Boolean isguide;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 80)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "password_hash", nullable = false)
    public Integer getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(Integer passwordHash) {
        this.passwordHash = passwordHash;
    }

    @Basic
    @Column(name = "isguide", nullable = false)
    public Boolean getIsguide() {
        return isguide;
    }

    public void setIsguide(Boolean isguide) {
        this.isguide = isguide;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeEntity that = (EmployeeEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (passwordHash != null ? !passwordHash.equals(that.passwordHash) : that.passwordHash != null) return false;
        if (isguide != null ? !isguide.equals(that.isguide) : that.isguide != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (passwordHash != null ? passwordHash.hashCode() : 0);
        result = 31 * result + (isguide != null ? isguide.hashCode() : 0);
        return result;
    }
}
