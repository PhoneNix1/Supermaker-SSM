package cn.itcast.service.impl;

import cn.itcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.domain.User;
import cn.itcast.dao.UserMapper;
@Service("userService")

public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String userName, String password,Integer role) {
        // TODO Auto-generated method stub
        return userMapper.findWithLoginAndPassword(userName, password,role);
    }

}


