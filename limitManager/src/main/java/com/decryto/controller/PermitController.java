package com.decryto.controller;

import com.alibaba.fastjson.JSON;
import com.decryto.bean.Permit;
import com.decryto.bean.User;
import com.decryto.service.PermitService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/permit")
@Controller
public class PermitController {

    @Autowired
    private PermitService permitService;
    //查询权限
    @ResponseBody
    @RequestMapping("/queryPermit")
    public String queryPermit(HttpSession session){
        User user = (User) session.getAttribute("user");
        Integer uid = user.getId();
        List<Permit> permitList = null;

        if (uid!=null){
            permitList = permitService.queryPermit(uid);
        }
        /*转为树形结构  tree*/
       /* JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(permitList));
        JSONArray jsonArray1 = JsonUtil.listToTree(jsonArray,"id","permitParentId","child");*/
        return JSON.toJSONString(permitList);
    }
//查询菜单列表
    @RequestMapping("/findAllPermit")
    @ResponseBody
    public String findAllPermit(){
        List<Permit> permitList  = permitService.findAllPermit();
        Permit permit = new Permit();
        permit.setMessage("");
        permit.setPermitList(permitList);
        permit.setCode(0);
        permit.setCount(permitList.size());

        //分页效果
        return JSON.toJSONString(permit);
    }

    @RequestMapping("/pageHelperTest")
    @ResponseBody
    public String findsAllPermit(Integer pageNum,Integer pageSize){

        Page<Permit> page = PageHelper.startPage(pageNum,pageSize);
        //自带拦截器, 将查询的数据自带分开
        List<Permit> permitList = permitService.findAllPermit();
       PageInfo<Permit> pageInfo = new PageInfo<>(permitList);
        return JSON.toJSONString(pageInfo);
    }

}
