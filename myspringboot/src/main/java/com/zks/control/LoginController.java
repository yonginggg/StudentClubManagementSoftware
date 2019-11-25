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

@RestController
@RequestMapping("/api")
@CrossOrigin
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public JSONObject login(@RequestParam("username") String userid, @RequestParam("password") String userpwd) throws Exception {

        UserService userService = new UserService();
        JSONObject result = userService.login(userid, userpwd);

        return result;
    }
}
