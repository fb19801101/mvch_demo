package com.mvc.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class StudentPK implements Serializable {
    private int id;
    private String userNo;

    @Column(name = "id", nullable = false)
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "user_no", nullable = false, length = 20)
    @Id
    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentPK studentPK = (StudentPK) o;
        return id == studentPK.id &&
                Objects.equals(userNo, studentPK.userNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userNo);
    }
}
