package com.decryto.service;

import com.decryto.bean.Permit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PermitService {
    List<Permit> queryPermit(Integer id);
    //查询权限
    List<Permit> findAllPermit();
    List<Permit> findListNotLeaf();

    /*权限菜单的增删改查*/
    int insert(Permit permit);
    int updateByPrimaryKey(Permit permit);
    int deleteByPermaryKey(Integer id);
    Permit selectByPermaryKey(Integer id);
}
