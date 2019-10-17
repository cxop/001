package com.decryto.service.impl;

import com.decryto.bean.RolePermit;
import com.decryto.mapper.RolePermitMapper;
import com.decryto.service.RolePermitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolePermitServiceImpl implements RolePermitService {
    @Autowired
    private RolePermitMapper rolePermitMapper;

    @Override
    public int deletePermit(Integer id) {

        return rolePermitMapper.delPermit(id);
    }

    @Override
    public int intPermit(List<RolePermit> permitId) {

        return rolePermitMapper.intPermit(permitId);
    }
}
