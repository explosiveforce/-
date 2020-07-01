package com.ndgwww.HR.management.Config;

import com.ndgwww.HR.management.pojo.Department;
import org.apache.ibatis.jdbc.SQL;

public class DepartConfig {

    //更新
    public String update(Department department) {
        return new SQL() {{
            UPDATE("department");
            if (department.getName() != null) {
                SET("name = #{name}");
            }
            if (department.getType() != null) {
                SET("type = #{type}");
            }
            if (department.getTelephone() != null) {
                SET("telephone = #{telephone}");
            }
            if (department.getFax() != null) {
                SET("fax = #{fax}");
            }
            if (department.getDescription() != null) {
                SET("description = #{description}");
            }
            if (department.getPredepartment() != null) {
                SET("predepartment = #{predepartment}");
            }
            if (department.getDate() != null) {
                SET("date = #{date}");
            }
            WHERE("id = #{id}");
        }}.toString();
    }
        //新增
        public String insert (Department department){
            return new SQL() {{
                INSERT_INTO("department");
                if (department.getId() != null) {
                    VALUES("id", "#{id}");
                }
                if (department.getName() != null) {
                    VALUES("name", "#{name}");
                }
                if (department.getType() != null) {
                    VALUES("type", "#{type}");
                }
                if (department.getTelephone() != null) {
                    VALUES("telephone", "#{telephone}");
                }
                if (department.getFax() != null) {
                    VALUES("fax", "#{fax}");
                }
                if (department.getDescription() != null) {
                    VALUES("description", "#{description}");
                }
                if (department.getPredepartment() != null) {
                    VALUES("predepartment", "#{predepartment}");
                }
                if (department.getDate() != null) {
                    VALUES("date", "#{date}");
                }
            }}.toString();

        }
    }
