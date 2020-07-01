package com.ndgwww.HR.management.Controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ndgwww.HR.management.Config.RespBean;
import com.ndgwww.HR.management.Service.EmployeeService;
import com.ndgwww.HR.management.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController//返回的数据都是json
@RequestMapping("/employee")
//@CrossOrigin
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    //分页查询所有员工信息
    @RequestMapping(value = "/selectAllEmployee",method = RequestMethod.GET)
    public PageInfo<Employee> selectAllEmployee(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "3") int pageSize){
        PageHelper.startPage(pageNo,pageSize);
        List<Employee> list = employeeService.selectAllEmployee();
        //将查询到的数据封装到PageInfo对象
        PageInfo<Employee> pageInfo=new PageInfo(list);
        return pageInfo;
    }
    //这是根据部门id查询部门下的员工
    @RequestMapping(value = "/selectDepartIdEmployee",method = RequestMethod.POST)
    public List selectDepartIdEmployee(@RequestParam("departmentid")String departmentid){
        return employeeService.selectDepartIdEmployee(departmentid);
    }
    //动态更新数据
    @RequestMapping(value = "/updateByPrimaryKeySelective",method = RequestMethod.POST)
    public RespBean updateByPrimaryKeySelective(@RequestBody Employee employee){
        int resp= employeeService.updateByPrimaryKeySelective(employee);
        if(resp>0){
            return new RespBean("success","员工信息更新成功");
        }else {
            return new RespBean("error","员工信息更新失败");
        }
    }
   //新增员工信息
    @RequestMapping(value = "/insertSelective",method = RequestMethod.POST)
    public RespBean insertSelective(@RequestBody Employee employee) {
        int resp = employeeService.insertSelective(employee);
        if (resp > 0) {
            return new RespBean("success", "欢迎新成员信息插入成功");
        } else {
            return new RespBean("error", "员工信息插入失败");
        }
    }
    //删除员工信息：真删除
    @RequestMapping(value = "/deleteByPrimaryKey",method = RequestMethod.POST)
    public RespBean deleteByPrimaryKey(@RequestParam("id")String id){
        int resp = employeeService.deleteByPrimaryKey(id);
        if (resp > 0) {
            return new RespBean("success", "删除成功");
        } else {
            return new RespBean("error", "删除失败");
        }
    }

}
