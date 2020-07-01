package com.ndgwww.HR.management.Service;

import com.ndgwww.HR.management.pojo.Department;

import java.util.List;

public interface DepartmentService {
    public List<Department> selectdepartment();

    public Integer Updateepartment(String id);

    public  Integer updateAll(Department department) throws Exception;
    public  Integer insertAll(Department department) throws Exception;

}
