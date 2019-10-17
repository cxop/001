package com.decryto.service.impl;

import com.decryto.bean.Role;
import com.decryto.mapper.RoleMapper;
import com.decryto.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public int addRole(Role role) {

        return roleMapper.addRole(role);
    }

    @Override
    public int updateRole(Role role) {
        return roleMapper.updateRole(role);
    }

    @Override
    public int delRole(Integer id) {

        return roleMapper.delRole(id);
    }

    @Override
    public List<Role> queryAllRole() {

        return roleMapper.queryAllRole();
    }

    @Override
    public Role findRoleById(Integer id) {

        return roleMapper.findRoleById(id);
    }
    @Override
    public Role selectByPrimaryKey(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Role> selAllRole() {
        return roleMapper.selAllRole();
    }

    @Override
    public Role selByName(String roleName) {
        return roleMapper.selByName(roleName);
    }
}
