package com.ndgwww.HR.management.Controller;

import com.ndgwww.HR.management.Config.RespBean;
import com.ndgwww.HR.management.Service.ManagementService;
import com.ndgwww.HR.management.Service.TryService;
import com.ndgwww.HR.management.pojo.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/try")
public class TryController {
    @Autowired
    private TryService tryService;
    //这个一个连表查询，查询实习员工的信息，参数result值如下：
    //3不通过1转正2延期-1未处理：EG：传-1 查询所有实习员工，传1查询近期转正员工
    @PostMapping(value = "/queryForList")
    public List queryForList(@RequestParam("result")String result){
        return tryService.queryForList(result);
    }
    //这是一个动态更新语句可以根据id修改任何字段除了实习开始和结束时间无法修改
    //可用于修改被抓，评价，转正
    @PostMapping(value = "/updateByPrimaryKeySelective")
    public RespBean updateByPrimaryKeySelective(@RequestBody Try tryv){
        int resp = tryService.updateByPrimaryKeySelective(tryv);
        if(resp>0){
            return new RespBean("success","更新成功");
        }else {
            return new RespBean("error","更新失败");
        }
    }
    //离职语句用这个，一旦离职实习生，那么员工表对应的也会删除（实习员工也是员工）
    @PostMapping(value = "/queryForList")
    public RespBean deleteByPrimaryKey(@RequestParam("id")String id){
        int resp = tryService.deleteByPrimaryKey(id);
        if(resp>0){
            return new RespBean("success","员工离职成功");
        }else {
            return new RespBean("error","员工离职失败");
        }
    }
}
