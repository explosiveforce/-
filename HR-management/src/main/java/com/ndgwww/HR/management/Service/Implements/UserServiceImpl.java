package com.ndgwww.HR.management.Service.Implements;
import com.ndgwww.HR.management.Service.UserService;
import com.ndgwww.HR.management.mapper.mapper2.UserMapper;
import com.ndgwww.HR.management.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
@Service
public class UserServiceImpl implements UserService {

    @Resource
   UserMapper userMapper;






    @Override
    public User Email(String email) {
        return userMapper.Email(email);
    }

    @Override
    public User Login(String username) {
        return userMapper.Login(username);
    }

    @Override
    public Integer Zhuce(String username,String password,String email) {
        return userMapper.Zhuce(username,password,email);
    }
}
