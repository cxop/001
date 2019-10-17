package com.decryto.service.impl;

import com.decryto.bean.User;
import com.decryto.mapper.UserMapper;
import com.decryto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUser(User user) {
       User user1 = userMapper.findUser(user);
        return user1;
    }

    @Override
    public List<User> queryAllUser() {
        List<User> userList = userMapper.queryAllUser();
        return userList;
    }

    /*增删改方法*/

    @Override
    public int saveUser(User user) {
        return userMapper.saveUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int delUser(Integer id) {
        return userMapper.delUser(id);
    }

    @Override
    public List<User> findUserList() {

        return userMapper.findUserList();
    }

    @Override
    public int uptUser(User user) {
        return userMapper.uptUser(user);
    }

    @Override
    public int delPUser(Integer userRoleId) {
        int s = userMapper.delPUser(userRoleId);
        return s;
    }
}
