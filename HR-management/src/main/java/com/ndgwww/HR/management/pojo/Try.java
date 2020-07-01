package com.ndgwww.HR.management.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Try {
    private String id;

    private Date starttime;

    private Date endtime;

    private String comment;

    private Integer result;

    private Date dealdate;

    private String remark;

    private Employee employee;
}