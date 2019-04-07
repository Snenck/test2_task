package com.qf.service;

import com.qf.entity.TClass;

import java.util.List;

public interface ITClassService {
    public List<TClass> getAll();
    public TClass getTClassById(int id);
    public int updateTClass(TClass tClass);
    public int addTClass(TClass tClass);
    public int delTClassById(int id);
    public TClass getByName(String name);
}
