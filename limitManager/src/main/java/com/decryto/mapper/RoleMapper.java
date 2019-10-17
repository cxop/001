package com.decryto.mapper;

import com.decryto.bean.Permit;
import com.decryto.bean.Role;
import com.decryto.bean.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {
    //角色对应权限信息
     User findRolePermit();

    List<Role> queryAllRole();

    Role findRoleById(Integer id);

    int addRole(Role role);

    int updateRole(Role role);
    int delRole(Integer id);
    //通过主键查询角色
    Role selectByPrimaryKey(Integer id);

    //管理员模块
    List<Role> selAllRole();
    //根据名字查询id
    Role selByName(String roleName);
}
