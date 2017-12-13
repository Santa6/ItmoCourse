package com.backend.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "checks", schema = "s225127", catalog = "studs")
public class ChecksEntity {
    private String sessionId;
    private Double x;
    private double y;
    private double r;
    private boolean result;
    private int id;

    @Basic
    @Column(name = "session_id", nullable = false, length = -1)
    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @Basic
    @Column(name = "x", nullable = true, precision = 0)
    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    @Basic
    @Column(name = "y", nullable = false, precision = 0)
    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Basic
    @Column(name = "r", nullable = false, precision = 0)
    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    @Basic
    @Column(name = "result", nullable = false)
    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChecksEntity that = (ChecksEntity) o;

        if (Double.compare(that.y, y) != 0) return false;
        if (Double.compare(that.r, r) != 0) return false;
        if (result != that.result) return false;
        if (id != that.id) return false;
        if (sessionId != null ? !sessionId.equals(that.sessionId) : that.sessionId != null) return false;
        if (x != null ? !x.equals(that.x) : that.x != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result1;
        long temp;
        result1 = sessionId != null ? sessionId.hashCode() : 0;
        result1 = 31 * result1 + (x != null ? x.hashCode() : 0);
        temp = Double.doubleToLongBits(y);
        result1 = 31 * result1 + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(r);
        result1 = 31 * result1 + (int) (temp ^ (temp >>> 32));
        result1 = 31 * result1 + (result ? 1 : 0);
        result1 = 31 * result1 + id;
        return result1;
    }
}
