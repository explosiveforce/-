package com.ndgwww.HR.management.Service.Implements;

import com.ndgwww.HR.management.Service.ManagementService;
import com.ndgwww.HR.management.mapper.EmployeeMapper;
import com.ndgwww.HR.management.mapper.ManagementMapper;
import com.ndgwww.HR.management.pojo.Management;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class ManagementServiceImpl implements ManagementService {
    @Resource
    private ManagementMapper managementMapper;
    @Override
    public Management login(Management user) {
        return managementMapper.selectLogin(user);
    }

}
