package com.qf.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.qf.dao.IStudentDao;
import com.qf.entity.Student;
import com.qf.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentDao studentDao;
    @Override
    public List<Student> getAll() {
        return studentDao.selectList(null);
    }

    @Override
    public Student getStudentById(int id) {
        return studentDao.selectById(id);
    }

    @Override
    public int updateStudent(Student student) {

        return studentDao.updateById(student);
    }

    @Override
    public int addStudent(Student student) {

        return studentDao.insert(student);
    }

    @Override
    public int delStudentById(int id) {
        return studentDao.deleteById(id);
    }

    @Override
    public List<Student> getAllByClassId(int classId) {
        Map<String,Object> map = new HashMap<>();
        map.put("class_id",classId);
        return studentDao.selectByMap(map);
    }
}
