package com.decryto.mapper;

import com.decryto.bean.Permit;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermitMapper {
    /*树形节点*/
    List<Permit> queryPermit(Integer id);
    // 添加菜单
    int insert(Permit permit);
    int updateByPrimaryKey(Permit permit);
    int deleteByPermaryKey(Integer id);
    List<Permit> findAllPermit();
    Permit selectByPermaryKey(Integer id);

   /* 查询所有非叶子节点菜单列表
    select * from permit where is_left = "false";*/
   List<Permit> findListNotLeaf();
    /*查询所有菜单*/



}
