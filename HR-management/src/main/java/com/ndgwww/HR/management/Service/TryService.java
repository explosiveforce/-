package com.ndgwww.HR.management.Service;

import com.ndgwww.HR.management.pojo.Try;

import java.util.List;

public interface TryService {
    int updateByPrimaryKeySelective(Try record);
    List<Try> queryForList(String result);
    int deleteByPrimaryKey(String id);
}
