package com.zks.control;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
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
public class UserController {
    @RequestMapping(value = "/alluser", method = RequestMethod.GET)
    public JSONObject showAllUser() throws Exception {
        UserService userService = new UserService();
        String alluser = JSON.toJSONString( userService.loadUser());
        JSONArray array= JSONArray.parseArray(alluser);
        JSONObject result = new JSONObject();
        result.put("alluser",array);
        return result;
    }
}
