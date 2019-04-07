package com.qf.service.impl;

import com.alibaba.dubbo.common.bytecode.Wrapper;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qf.dao.ITClassDao;
import com.qf.entity.TClass;
import com.qf.service.ITClassService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TClassServiceImpl implements ITClassService {
    @Autowired
    private ITClassDao itClassDao;
    @Override
    public List<TClass> getAll() {
        return itClassDao.selectList(null);
    }

    @Override
    public TClass getTClassById(int id) {
        return itClassDao.selectById(id);
    }

    @Override
    public int updateTClass(TClass tClass) {
        return itClassDao.update(tClass,null);
    }

    @Override
    public int addTClass(TClass tClass) {
        return itClassDao.insert(tClass);
    }

    @Override
    public int delTClassById(int id) {
        Map<String,Object> map =new HashMap<>();
        map.put("id",id);
        return itClassDao.deleteByMap(map);
    }

    @Override
    public TClass getByName(String name) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("name", name);
        TClass tClass = itClassDao.selectOne(queryWrapper);
        return tClass;
    }

}
