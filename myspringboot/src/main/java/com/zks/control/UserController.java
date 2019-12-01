package com.zks.control;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zks.service.UserService;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/allmanager", method = RequestMethod.GET)
    public JSONObject showAllManager() throws Exception {
        UserService userService = new UserService();
        String alluser = JSON.toJSONString( userService.loadManager());
        JSONArray array= JSONArray.parseArray(alluser);
        JSONObject result = new JSONObject();
        result.put("allmanager",array);
        return result;
    }

    @RequestMapping(value = "/changePwd", method = RequestMethod.POST)
    public JSONObject login(@RequestParam("userId") String userId, @RequestParam("userPwd") String userPwd, @RequestParam("userNewPwd") String userNewPwd, @RequestParam("userNewPwd2") String userNewPwd2) throws Exception {
        UserService userService = new UserService();
        JSONObject result = userService.changePwd(userId, userPwd, userNewPwd,userNewPwd2);
        return result;
    }
}
