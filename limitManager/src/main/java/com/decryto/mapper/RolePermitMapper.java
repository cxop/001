package com.decryto.mapper;

import com.decryto.bean.RolePermit;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolePermitMapper {
    //删除用户id对应的权限id
    int delPermit(@Param("id") Integer id);
    //添加新的权限id
    int intPermit(@Param("permitIdList") List<RolePermit> permitIdList);


}
