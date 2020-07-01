package com.ndgwww.HR.management.Service.Implements;

import com.ndgwww.HR.management.Service.TryService;
import com.ndgwww.HR.management.mapper.TryMapper;
import com.ndgwww.HR.management.pojo.Try;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class TryServiceImpl implements TryService {
    @Resource
    TryMapper tryMapper;

    @Override
    public int updateByPrimaryKeySelective(Try record) {
        return tryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<Try> queryForList(String result) {
        return tryMapper.queryForList(result);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return tryMapper.deleteByPrimaryKey(id);
    }
}
