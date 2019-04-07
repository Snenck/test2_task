package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.MyStudent;
import com.qf.entity.MyUitls;
import com.qf.entity.Student;
import com.qf.entity.TClass;
import com.qf.service.IStudentService;
import com.qf.service.ITClassService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/stu")
public class StuController {
    @Reference
    private IStudentService iStudentService;
    @Reference
    private ITClassService itClassService;
    @RequestMapping("/stuList")
    public String toshowStudent(ModelMap map){
        List<Student> list = iStudentService.getAll();
        for (Student stu:list
             ) {
            System.out.println(stu);

        }
        List<MyStudent> myStudnentList = MyUitls.getMyStudnentList(list);
        int classid=0;
        String classname="";
        for (int i=0;i<myStudnentList.size();i++){
            int tclassId=myStudnentList.get(i).getClassId();
            if(tclassId==classid){
                myStudnentList.get(i).setTcName(classname);
            }else {
                TClass tc = itClassService.getTClassById(myStudnentList.get(i).getClassId());
                myStudnentList.get(i).setTcName(tc.getName());
                classid=tc.getId();
                classname=tc.getName();
            }
            System.out.println(myStudnentList.get(i));
        }

        map.put("list",myStudnentList);
        return "stuLsit";
    }

    /*添加学生*/
    @RequestMapping("/toadd")
    public String toadd(){
        return "stuadd";
    }
    @RequestMapping("/add")
    @ResponseBody
    public String add(MyStudent myStudent){
        String msg="添加失败";
        int i = 0;
        try{
            TClass tClass = itClassService.getByName(myStudent.getTcName());
            myStudent.setClassId(tClass.getId());
            Student student = getStudentByMyStudent(myStudent);
            i = iStudentService.addStudent(student);
        }catch (Exception e){
            return "<a href='stuList'>跳转到展示页面</a>"+msg;
        }

        if(i>0){
            msg="添加成功";
        }
        return "<a href='stuList'>跳转到展示页面</a>"+msg;
    }
    /*获取要修改的学生信息*/
    @RequestMapping("toupdate/{id}")
    public String toUpdate(@PathVariable("id") int id, ModelMap map){
        Student student = iStudentService.getStudentById(id);
        MyStudent myStudent = MyUitls.getMyStudent(student);
        TClass tClass = itClassService.getTClassById(myStudent.getClassId());
        myStudent.setTcName(tClass.getName());
        map.put("stu",myStudent);
        return "update";
    }
    /*修改学生*/
    @RequestMapping("/update")
    @ResponseBody
    public String update(MyStudent myStudent){
        int i=0;
        String  msg="修改成功";
        try{
            TClass tClass = itClassService.getByName(myStudent.getTcName());
            myStudent.setClassId(tClass.getId());
            Student student = getStudentByMyStudent(myStudent);
            i=iStudentService.updateStudent(student);
        }catch (Exception e){
            msg="修改失败,请查看是否有该班级";
            System.out.println(e);
            return "<a href='stuList'>跳转到展示页面</a>"+msg;
        }
        if(i<0){
            msg="修改失败";
        }
        return "<a href='stuList'>跳转到展示页面</a>"+msg;
    }
    /*删除学生*/
    @RequestMapping("del/{id}")
    public String del(@PathVariable int id,ModelMap map){
        int i = iStudentService.delStudentById(id);
        String msg="删除失败";
        if(i>0){
            msg="删除成功";
        }
        map.put("msg",msg);
        return "toStuList";
    }
    public Student getStudentByMyStudent(MyStudent myStudent){
        Student student = new Student();
        student.setAge(myStudent.getAge());
        student.setSex(myStudent.isSex());
        student.setId(myStudent.getId());
        student.setClassId(myStudent.getClassId());
        student.setStuName(myStudent.getStuName());
        return student;
    }
    /*selStuByTCName*/
    @RequestMapping("/selStuByTCName")
    public String selStuByTCName(String name,ModelMap map){
        map.put("name",name);
        System.out.println(name);
        TClass tClass = itClassService.getByName(name);
        if(tClass!=null){
            List<Student> studentList = iStudentService.getAllByClassId(tClass.getId());
            List<MyStudent> myStudnentList = MyUitls.getMyStudnentList(studentList);
            for (int i=0;i<myStudnentList.size();i++){
                myStudnentList.get(i).setTcName(name);
            }
            map.put("list",myStudnentList);
        }else {
            map.put("msg","该班没有学生");
        }
        return "selStAndTC";
    }
}
