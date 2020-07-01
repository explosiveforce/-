package com.ndgwww.HR.management.Service;

import com.ndgwww.HR.management.pojo.Employee;

import java.util.List;

public interface EmployeeService {
    //查询所有员工信息
    List<Employee> selectAllEmployee ();
    //根据部门id查询
    List<Employee> selectDepartIdEmployee (String departmentid);
    //动态更新员工数据
    int updateByPrimaryKeySelective(Employee record);
    int insertSelective(Employee record);
    int deleteByPrimaryKey(String id);
}
