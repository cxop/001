package com.decryto.service;

import com.decryto.bean.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    //验证信息
    User findUser(User user);
    //查询所有
    List<User> queryAllUser();

    //增删改
    int saveUser(User user);
    int updateUser(User user);
    int delUser(Integer id);

    //管理员列表
    List<User> findUserList();
    int uptUser(User user);
    int delPUser(Integer userRoleId);
}
