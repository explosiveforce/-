package com.ndgwww.HR.management.Controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.ndgwww.HR.management.Config.RespBean;
import com.ndgwww.HR.management.Service.DepartmentService;
import com.ndgwww.HR.management.pojo.Department;
import com.ndgwww.HR.management.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//返回的数据都是json
@RequestMapping("/department")
//@CrossOrigin
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    //查询所有部门
    @RequestMapping(value = "/selectdepartment",method = RequestMethod.GET)
    public List selectdepartment(){
        return departmentService.selectdepartment();
    }
    //删除部门
    @RequestMapping(value = "/Delectepartment",method = RequestMethod.GET)
    public RespBean Delectepartment(@RequestParam("id") String id){
        int resp=departmentService.Updateepartment(id);
        if(resp>0){
            return new RespBean("success","删除成功");
        }else {
            return new RespBean("error","删除失败");
        }
    }
    //动态的更新部门信息（修改部门）
    @RequestMapping(value = "/updateAllepartment",method = RequestMethod.POST)
    public RespBean updateAllepartment(@RequestBody Department department) throws Exception {
        int resp=departmentService.updateAll(department);
        if(resp>0){
            return new RespBean("success","部门信息更新成功");
        }else {
            return new RespBean("error","部门信息更新失败");
        }
    }
    //新增部门信息
    @RequestMapping(value = "/insertAllepartment",method = RequestMethod.POST)
    public RespBean insertAllepartment(@RequestBody Department department) throws Exception {
        int resp = departmentService.insertAll(department);
        if (resp > 0) {
            return new RespBean("success", "新增成功");
        } else {
            return new RespBean("error", "新增失败");
        }
    }

}

