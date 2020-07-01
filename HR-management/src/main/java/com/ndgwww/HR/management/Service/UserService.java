package com.ndgwww.HR.management.Service;

import com.ndgwww.HR.management.pojo.User;

public interface UserService {

    public User Email(String email);

    public User Login(String username);

    public Integer Zhuce(String username, String password, String email);



}
