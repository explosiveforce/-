package com.ndgwww.HR.management.mapper;

import com.ndgwww.HR.management.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface EmployeeMapper {
    //查询所有员工信息
    List<Employee> selectAllEmployee ();
    //根据部门id查询
    List<Employee> selectDepartIdEmployee (String departmentid);
    int deleteByPrimaryKey(String id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(String id);
    //动态更新员工数据
    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

}