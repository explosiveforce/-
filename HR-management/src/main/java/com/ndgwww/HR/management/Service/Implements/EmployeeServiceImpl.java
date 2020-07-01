package com.ndgwww.HR.management.Service.Implements;

import com.ndgwww.HR.management.Service.EmployeeService;
import com.ndgwww.HR.management.mapper.EmployeeMapper;
import com.ndgwww.HR.management.pojo.Employee;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    private EmployeeMapper employeeMapper;
    @Override
    public List<Employee> selectAllEmployee() {
        return employeeMapper.selectAllEmployee();
    }

    @Override
    public List<Employee> selectDepartIdEmployee(String departmentid) {
        return employeeMapper.selectDepartIdEmployee(departmentid);
    }

    @Override
    public int updateByPrimaryKeySelective(Employee record) {
        return employeeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int insertSelective(Employee record) {
        return employeeMapper.insertSelective(record);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return employeeMapper.deleteByPrimaryKey(id);
    }
}
