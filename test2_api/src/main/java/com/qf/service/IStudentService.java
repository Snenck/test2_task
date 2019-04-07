package com.qf.service;

import com.qf.entity.Student;

import java.util.List;

public interface IStudentService {
    public List<Student> getAll();
    public Student getStudentById(int id);
    public int updateStudent(Student student);
    public int addStudent(Student student);
    public int delStudentById(int id);
    public List<Student> getAllByClassId(int classId);
}
