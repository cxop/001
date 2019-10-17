package com.decryto.controller;

import com.alibaba.fastjson.JSON;
import com.decryto.bean.Permit;
import com.decryto.service.PermitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("perOper")
public class PermitOperate {
    @Autowired
    private PermitService permitService;

    @RequestMapping("/addPermit")
    @ResponseBody
    public String findListNotLeaf(){
        List<Permit> permitList = permitService.findListNotLeaf();
        return JSON.toJSONString(permitList);
    }

    /*添加*/
    @RequestMapping("/insert")
    @ResponseBody
    public String saveOrUpdatePermit(Permit permit){

       int n = permitService.insert(permit);
        System.out.println();
        return JSON.toJSONString(n);
    }
    //修改
    @RequestMapping("/update")
    @ResponseBody
    public String updatePermit(Permit permit){

        int n =  permitService.updateByPrimaryKey(permit);

        return JSON.toJSONString(n);
    }

    @RequestMapping("/delPermitById")
    @ResponseBody
    public String delPermitById(Integer id){
        int n = permitService.deleteByPermaryKey(id);
        return JSON.toJSONString(n);
    }
}
