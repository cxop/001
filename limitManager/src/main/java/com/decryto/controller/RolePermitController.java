package com.decryto.controller;

import com.alibaba.fastjson.JSON;
import com.decryto.bean.Role;
import com.decryto.bean.RolePermit;
import com.decryto.service.RolePermitService;
import com.decryto.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/rolePermit")
public class RolePermitController {

    @Autowired
    private RolePermitService rolePermitService;
    @Autowired
    private RoleService roleService;

    //修改角色名和权限id
    @ResponseBody
    @RequestMapping("/upt")
    public String updateRP(Integer id,String roleName,HttpServletRequest request){
    String[] list = request.getParameterValues("listId[]");
    int n = rolePermitService.deletePermit(id);

    List<RolePermit> rolePermitList = new ArrayList<>();
    for (int i = 0;i<list.length;i++){
        RolePermit rolePermit = new RolePermit();
        rolePermit.setRoleId(id);
        rolePermit.setPermitId(Integer.parseInt(list[i]));
        rolePermitList.add(rolePermit);
        System.out.println();
    }
        System.out.println(rolePermitList);
        System.out.println(rolePermitList);
        int v = rolePermitService.intPermit(rolePermitList);

        return JSON.toJSONString(v+n);
    }

    /*添加角色,对应的权限id*/
    @ResponseBody
    @RequestMapping("/int")
    public String insertRP(Role role,List<RolePermit> rolePermitList){

        int row = roleService.addRole(role);
       /* int n = rolePermitService.insertPermit(rolePermitList);*/
        return "";
    }



}
