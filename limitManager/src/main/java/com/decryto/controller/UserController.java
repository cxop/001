package com.decryto.controller;

import com.alibaba.fastjson.JSON;
import com.decryto.bean.User;
import com.decryto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/findUser")
    @ResponseBody
    public String findAllUser(User user, HttpSession session){
        User userInfo = userService.findUser(user);
        if (userInfo!=null){
            session.setAttribute("user",userInfo);
            return JSON.toJSONString("true");
        }

        return JSON.toJSONString("error");
    }
    @RequestMapping("/queryAllUser")
    @ResponseBody
    public String queryAllUser(){
        List<User> userList = userService.queryAllUser();
        Map map = new HashMap();
        if (userList==null){
            map.put("status",0);
            return JSON.toJSONString(map);
        }
        map.put("userList",userList);
        map.put("status",0);
        return JSON.toJSONString(map);
    }


}
