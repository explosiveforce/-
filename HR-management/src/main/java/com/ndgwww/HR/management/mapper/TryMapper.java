package com.ndgwww.HR.management.mapper;

import com.ndgwww.HR.management.pojo.Try;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TryMapper {
    int deleteByPrimaryKey(String id);

    int insert(Try record);

    int insertSelective(Try record);

    Try selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Try record);

    int updateByPrimaryKey(Try record);

    List<Try>queryForList(String result);

}