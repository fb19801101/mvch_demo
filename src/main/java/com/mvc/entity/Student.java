package com.mvc.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@IdClass(StudentPK.class)
public class Student {
    private int id;
    private String userNo;
    private String userName;
    private String userPwd;
    private String userSex;
    private Date userBirth;
    private String userClass;
    private Date dateCreate;
    private Date dateUpdate;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @Column(name = "user_no", nullable = false, length = 20)
    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    @Basic
    @Column(name = "user_name", nullable = false, length = 20)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "user_pwd", nullable = true, length = 20)
    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    @Basic
    @Column(name = "user_sex", nullable = false, length = 20)
    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    @Basic
    @Column(name = "user_birth", nullable = true)
    public Date getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(Date userBirth) {
        this.userBirth = userBirth;
    }

    @Basic
    @Column(name = "user_class", nullable = true, length = 20)
    public String getUserClass() {
        return userClass;
    }

    public void setUserClass(String userClass) {
        this.userClass = userClass;
    }

    @Basic
    @Column(name = "date_create", nullable = false)
    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    @Basic
    @Column(name = "date_update", nullable = false)
    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                Objects.equals(userNo, student.userNo) &&
                Objects.equals(userName, student.userName) &&
                Objects.equals(userPwd, student.userPwd) &&
                Objects.equals(userSex, student.userSex) &&
                Objects.equals(userBirth, student.userBirth) &&
                Objects.equals(userClass, student.userClass) &&
                Objects.equals(dateCreate, student.dateCreate) &&
                Objects.equals(dateUpdate, student.dateUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userNo, userName, userPwd, userSex, userBirth, userClass, dateCreate, dateUpdate);
    }
}
