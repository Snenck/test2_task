package com.qf.entity;

import lombok.Data;


public class MyStudent{
    private String tcName;
    private int id;
    private String stuName;
    private int age;
    private boolean sex;
    private int classId;

    public MyStudent(){}
    public MyStudent(String tcName, int id, String stuName, int age, boolean sex, int classId) {
        tcName = tcName;
        this.id = id;
        this.stuName = stuName;
        this.age = age;
        this.sex = sex;
        this.classId = classId;
    }

    @Override
    public String toString() {
        return "MyStudent{" +
                "tcName='" + tcName + '\'' +
                ", id=" + id +
                ", stuName='" + stuName + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", classId=" + classId +
                '}';
    }

    public String getTcName() {
        return tcName;
    }

    public void setTcName(String tcName) {
        this.tcName = tcName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }
}
