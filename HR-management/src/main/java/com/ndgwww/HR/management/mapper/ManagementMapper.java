package com.ndgwww.HR.management.mapper;

import com.ndgwww.HR.management.pojo.Management;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ManagementMapper {
    int deleteByPrimaryKey(String username);

    int insert(Management record);

    int insertSelective(Management record);

    Management selectByPrimaryKey(String username);

    int updateByPrimaryKeySelective(Management record);

    int updateByPrimaryKey(Management record);

    Management selectLogin(Management username);
}