package com.ndgwww.HR.management.Controller.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class HelloController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @RequestMapping("/query")
    public Map<String,Object> hello(){
        List<Map<String,Object>> list = jdbcTemplate.queryForList("select * from department");
        return list.get(1);
    }
}
