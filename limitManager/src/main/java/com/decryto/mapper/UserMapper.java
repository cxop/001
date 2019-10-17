package com.decryto.mapper;

import com.decryto.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
//登录验证
    User findUser(User user);
//用户管理
    List<User> queryAllUser();

//增删改
    int saveUser(User user);
    int updateUser(User user);
    int delUser(Integer id);


    //管理员管理模块
    //查询所有用户
    List<User> findUserList();
    //更新用户信息
    int uptUser(User user);
    //删除用户信息(角色+权限节点)
    int delPUser(Integer userRoleId);
    //添加管理员

}
