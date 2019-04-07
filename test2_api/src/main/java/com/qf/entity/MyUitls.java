package com.qf.entity;

import java.util.ArrayList;
import java.util.List;

public class MyUitls {
    public static MyStudent getMyStudent(Student student){
        MyStudent myStudent = new MyStudent();
        myStudent.setAge(student.getAge());
        myStudent.setClassId(student.getClassId());
        myStudent.setId(student.getId());
        myStudent.setSex(student.isSex());
        myStudent.setStuName(student.getStuName());
        return myStudent;
    }
    public static List<MyStudent> getMyStudnentList(List<Student> list){
        List<MyStudent> myList = new ArrayList<>();
        for (Student student:list) {
            myList.add(getMyStudent(student));
        }
        return myList;
    }
}
