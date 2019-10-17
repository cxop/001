package com.decryto.service;

import com.decryto.bean.Role;

import java.util.List;

public interface RoleService {

    List<Role> queryAllRole();
    Role findRoleById(Integer id);
    int addRole(Role role);
    int updateRole(Role role);
    int delRole(Integer id);
    Role selectByPrimaryKey(Integer id);

    List<Role> selAllRole();

    Role selByName(String roleName);
}
