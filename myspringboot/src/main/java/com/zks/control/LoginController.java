package com.zks.control;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.zks.model.BeanUser;
import com.zks.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api")
@CrossOrigin
@ResponseBody
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public JSONObject login(@RequestParam("type") String type, @RequestParam("userId") String userid, @RequestParam("userPwd") String userpwd) throws Exception {
        UserService userService = new UserService();
        JSONObject result = userService.login(type, userid, userpwd);
        return result;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public JSONObject register(@RequestParam("userId") String userId, @RequestParam("userName") String userName,
                               @RequestParam("oldPwd") String oldPwd, @RequestParam("newPwd") String newPwd,
                               @RequestParam("userSex") String userSex, @RequestParam("userMajor") String userMajor,
                               @RequestParam("userClass") String userClass, @RequestParam("userTel") String userTel) throws Exception {
        UserService userService = new UserService();
        JSONObject result = userService.register(userId, userName,  oldPwd,  newPwd, userSex, userMajor, userClass, userTel);
        return result;
    }
}
