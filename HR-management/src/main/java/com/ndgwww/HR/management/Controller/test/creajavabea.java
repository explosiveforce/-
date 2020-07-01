package com.ndgwww.HR.management.Controller.test;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.ndgwww.HR.management.pojo.Department;

import java.lang.reflect.Field;

public class creajavabea {
    public static void main(String[] args) {
        System.out.println(getResultsStr(Department.class));
    }
    public static String getResultsStr(Class origin) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("@Results({\n");
        for (Field field : origin.getDeclaredFields()) {
            String property = field.getName();
            //映射关系：对象属性(驼峰)->数据库字段(下划线)
            String column = new PropertyNamingStrategy.SnakeCaseStrategy().translate(field.getName());
            stringBuilder.append(String.format("@Result(property = \"%s\", column = \"%s\"),\n", property, column));
        }
        stringBuilder.append("})");
        return stringBuilder.toString();
    }
}
