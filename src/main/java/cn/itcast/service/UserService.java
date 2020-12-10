package cn.itcast.service;

import cn.itcast.domain.User;

public interface UserService {

    /**
     * 判断用户登录
     * @return 找到返回User对象，没有找到返回null
     * */
    User login(String userName,String password,Integer role);

}
