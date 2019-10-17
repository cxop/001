package com.decryto.service.impl;

import com.decryto.bean.Permit;
import com.decryto.mapper.PermitMapper;
import com.decryto.service.PermitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("permitService")
public class PermitServiceImpl implements PermitService {
    @Autowired
    private PermitMapper permitMapper;

    @Override
    public List<Permit> queryPermit(Integer id) {
       List<Permit> permitList =  permitMapper.queryPermit(id);
        return permitList;
    }

    @Override
    public List<Permit> findAllPermit() {
        List<Permit> permit = permitMapper.findAllPermit();
        return permit;
    }

    @Override
    public List<Permit> findListNotLeaf() {

        return permitMapper.findListNotLeaf();
    }

    @Override
    public int insert(Permit permit) {

        return permitMapper.insert(permit);
    }

    @Override
    public int updateByPrimaryKey(Permit permit) {

        return permitMapper.updateByPrimaryKey(permit);
    }

    @Override
    public int deleteByPermaryKey(Integer id) {

        return permitMapper.deleteByPermaryKey(id);
    }

    @Override
    public Permit selectByPermaryKey(Integer id) {

        return permitMapper.selectByPermaryKey(id);
    }
}
