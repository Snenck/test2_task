package com.qf.entity;

import lombok.Data;

import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private String stuName;
    private int age;
    private boolean sex;
    private int classId;

    public Student(int id, String stuName, int age, boolean sex, int classId) {
        this.id = id;
        this.stuName = stuName;
        this.age = age;
        this.sex = sex;
        this.classId = classId;
    }
    public Student(){}

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", stuName='" + stuName + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", classId=" + classId +
                '}';
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
