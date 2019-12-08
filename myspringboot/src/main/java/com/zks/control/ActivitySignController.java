package com.zks.control;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zks.service.ActivityService;
import com.zks.service.ActivitySignService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
@ResponseBody
public class ActivitySignController {
    // 活动报名
    @RequestMapping(value = "/createactivitysign", method = RequestMethod.POST)
    public JSONObject createActivitySign(@RequestParam("userid") String userId,@RequestParam("activityid") Integer activityId) throws Exception {
        ActivitySignService activitySignService = new ActivitySignService();
        JSONObject result = activitySignService.createActivitySign(userId,activityId);
        return result;
    }

    // 审核报名
    @RequestMapping(value = "/changesignstate", method = RequestMethod.POST)
    public JSONObject changeSignState(@RequestParam("activitySignId") int activitySignId,@RequestParam("answer") Boolean answer) throws Exception {
        ActivitySignService activitySignService = new ActivitySignService();
        JSONObject result = activitySignService.changeSignState(activitySignId,answer);
        return result;
    }

    // 显示等待审核的报名（审核通过、审核拒绝）
    @RequestMapping(value = "/loadactivitysignbystate", method = RequestMethod.POST)
    public JSONObject loadActivitySignByState(@RequestParam("state") String state,@RequestParam("activityId") int activityId) throws Exception {
        ActivitySignService activitySignService = new ActivitySignService();
        String loadactivitysignbystate = JSON.toJSONString( activitySignService.loadActivitySignByState(state,activityId));
        JSONArray array= JSONArray.parseArray(loadactivitysignbystate);
        JSONObject result = new JSONObject();
        result.put("loadactivitysignbystate",array);
        return result;
    }

    //显示学生报名通过的活动
    @RequestMapping(value = "/myactivity", method = RequestMethod.POST)
    public JSONObject myActivity(@RequestParam("userId") String userId) throws Exception {
        ActivitySignService activitySignService = new ActivitySignService();
        String myactivity = JSON.toJSONString( activitySignService.loadMyActivity(userId));
        JSONArray array= JSONArray.parseArray(myactivity);
        JSONObject result = new JSONObject();
        result.put("myactivity",array);
        return result;
    }
}
