package com.zks.control;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zks.service.ActivityService;
import com.zks.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
@RestController
@RequestMapping("/api")
@CrossOrigin
@ResponseBody
public class ActivityController {
    // 管理员查看活动(待审核：1、审核记录：2）
    @RequestMapping(value = "/allactivity", method = RequestMethod.POST)
    public JSONObject showActivity(@RequestParam("type") int type) throws Exception {
        ActivityService activityService = new ActivityService();
        String allactivity = JSON.toJSONString( activityService.loadActivity(type));
        JSONArray array= JSONArray.parseArray(allactivity);
        JSONObject result = new JSONObject();
        result.put("allactivity",array);
        return result;
    }

    // 管理员审核活动
    @RequestMapping(value = "/examineactivity", method = RequestMethod.POST)
    public JSONObject examineActivity(@RequestParam("activityid") int activityid,@RequestParam("answer") Boolean answer) throws Exception {
        ActivityService activityService = new ActivityService();
        JSONObject result = activityService.changeState(activityid,answer);
        return result;
    }

    // 显示全校活动
    @RequestMapping(value = "/schoolactivity", method = RequestMethod.GET)
    public JSONObject showAssociationActivity() throws Exception {
        ActivityService activityService = new ActivityService();
        String schoolactivity = JSON.toJSONString( activityService.loadActivityBySchool());
        JSONArray array= JSONArray.parseArray(schoolactivity);
        JSONObject result = new JSONObject();
        result.put("schoolactivity",array);
        return result;
    }

    // 显示社团活动
    @RequestMapping(value = "/associationactivity", method = RequestMethod.POST)
    public JSONObject showAssociationActivity(@RequestParam("post") String post,@RequestParam("associationName") String associationName,@RequestParam("departmentId") int departmentId) throws Exception {
        ActivityService activityService = new ActivityService();
        String associationactivity = JSON.toJSONString( activityService.loadActivityByAssociation(post,associationName,departmentId));
        JSONArray array= JSONArray.parseArray(associationactivity);
        JSONObject result = new JSONObject();
        result.put("associationactivity",array);
        return result;
    }

    // 创建活动
    @RequestMapping(value = "/createActivity", method = RequestMethod.POST)
    public JSONObject createActivity(@RequestParam("range") String range,@RequestParam("name") String name,@RequestParam("introduction") String introduction,@RequestParam("startTime") Date startTime,@RequestParam("endTime") Date endTime,@RequestParam("deadLine") Date deadLine,@RequestParam("palaceid") int palaceid,@RequestParam("associationid") int associationid,@RequestParam("departmentid") int departmentid) throws Exception {
        ActivityService activityService = new ActivityService();
        JSONObject result = activityService.createActivity(range,name,introduction,startTime, endTime, deadLine,palaceid,associationid,departmentid);
        return result;
    }

}
