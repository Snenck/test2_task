package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.TClass;
import com.qf.service.ITClassService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/tc")
public class TClassController {
    @Reference
    private ITClassService itClassService;

    @RequestMapping("/tcList")
    public String ListClass(ModelMap map) {
        List<TClass> list = itClassService.getAll();
        map.put("list", list);
        return "tClassList";
    }

    /*添加*/
    @RequestMapping("/toadd")
    public String toadd() {
        return "tcadd";
    }

    @RequestMapping("add")
    public String add(TClass tClass,ModelMap map){
        int i = itClassService.addTClass(tClass);
        String msg="添加失败";
        if(i>0){
         msg="添加成功";
        }
        map.put("msg",msg);
        return "totClassList";
    }
    /*修改*/
    @RequestMapping("/toupdate/{id}")
    public String toupdate(@PathVariable int id,ModelMap map){
        TClass tClass = itClassService.getTClassById(id);
        map.put("tc",tClass);
        return "tcupdate";
    }
    @RequestMapping("/update")
    public String update(TClass tClass,ModelMap map){
        System.out.println(tClass+"taw");
        int i = itClassService.updateTClass(tClass);
        String msg="修改失败";
        if(i>0){
            msg="修改成功";
        }
        map.put("msg",msg);
        return "totClassList";
    }
    /*删除*/
    @RequestMapping("/del/{id}")
    public String del(@PathVariable int id,ModelMap map){
        int i = itClassService.delTClassById(id);
        String msg="删除失败";
        if(i>0){
            msg="删除成功";
        }
        map.put("msg",msg);
        return "totClassList";
    }
}
