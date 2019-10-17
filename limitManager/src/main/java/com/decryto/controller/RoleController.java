package com.decryto.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.decryto.bean.Permit;
import com.decryto.bean.Role;
import com.decryto.bean.RolePermit;
import com.decryto.service.PermitService;
import com.decryto.service.RolePermitService;
import com.decryto.service.RoleService;
import com.decryto.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermitService permitService;
    @Autowired
    private RolePermitService rolePermitService;
    @ResponseBody
    @RequestMapping("/add")
    public int addRole(Role role) {

        return roleService.addRole(role);
    }
    @ResponseBody
    @RequestMapping("/update")
    public int updateRole(Role role) {
        return roleService.updateRole(role);
    }

    @ResponseBody
    @RequestMapping("/del")
    public String delRole(Integer id) {
        Integer n = 0 ;
            if (id!=null){
                n=roleService.delRole(id);
            }
        return JSON.toJSONString(n);
    }

    @ResponseBody
    @RequestMapping("/queryAllRole")
    public String queryAllRole() {
        List<Role> roles = roleService.queryAllRole();
        Role role = new Role();
        role.setCode(0);
        role.setMessage("");
        role.setCount(roles.size());
        role.setRoleList(roles);
        return JSON.toJSONString(role);
    }

    @RequestMapping("/findRole")
    @ResponseBody
    public String findRoleById(Role role){

       Role r= roleService.findRoleById(role.getId());
        return JSON.toJSONString(r);
    }

    //查询当前角色的名称
    @RequestMapping("/initRolePermit")
    @ResponseBody
    public String initRolePermit(Integer id){//传入当前角色id
        //查询当前角色名称
        Role role = roleService.selectByPrimaryKey(id);
        //返回所有的权限列表
        List<Permit> permitList = permitService.findAllPermit();
        //返回当前角色对应的权限列表

        Map map = new HashMap<>();
        map.put("role",role);

        JSONArray array = JsonUtil.listToTree(
                JSON.parseArray(JSON.toJSONString(permitList)),"id","permitParentId","children");
        map.put("permitList", array);
        return JSON.toJSONString(map);
    }



    //添加角色+对应权限
    @ResponseBody
    @RequestMapping("/queryAll")
    public String queryAll(){

       List<Permit> list =  permitService.findAllPermit();
        JSONArray array = JsonUtil.listToTree(
                JSON.parseArray(JSON.toJSONString(list)),"id","permitParentId","children");
        Map map = new HashMap();
        map.put("array",array);
        return JSON.toJSONString(map);
    }
    @ResponseBody
    @RequestMapping("/saveRoleAndPermit")
    public String saveRP(String roleName,HttpServletRequest request){
        String[] list = request.getParameterValues("listId[]");
        //添加角色
        Role role = new Role();
         role.setRoleName(roleName);
        int roleRow = roleService.addRole(role);
        //查询id
        Role role1 = roleService.selByName(roleName);
        List<RolePermit> rolePermitList = new ArrayList<>();
        for (int i = 0;i<list.length;i++){
            RolePermit rolePermit = new RolePermit();

            rolePermit.setPermitId(Integer.parseInt(list[i]));
            rolePermitList.add(rolePermit);
            System.out.println();
        }
        System.out.println(rolePermitList);
        int v = rolePermitService.intPermit(rolePermitList);
        return JSON.toJSONString(v);
    }
}
