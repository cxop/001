package com.decryto.service;

import com.decryto.bean.RolePermit;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RolePermitService {

    int deletePermit(@Param("id") Integer id);
    int intPermit(List<RolePermit> permitId );


}
