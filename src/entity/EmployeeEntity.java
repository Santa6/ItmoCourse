package entity;

import javax.persistence.*;

@Entity
@Table(name = "employee", schema = "s223860", catalog = "studs")
public class EmployeeEntity {
    private int id;
    private String name;
    private int passwordHash;
    private boolean isguide;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    public int getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(int passwordHash) {
        this.passwordHash = passwordHash;
    }

    @Basic
    @Column(name = "isguide", nullable = false)
    public boolean isIsguide() {
        return isguide;
    }

    public void setIsguide(boolean isguide) {
        this.isguide = isguide;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeEntity that = (EmployeeEntity) o;

        if (id != that.id) return false;
        if (passwordHash != that.passwordHash) return false;
        if (isguide != that.isguide) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + passwordHash;
        result = 31 * result + (isguide ? 1 : 0);
        return result;
    }
}
