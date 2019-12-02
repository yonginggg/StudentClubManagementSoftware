package com.zks.control;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zks.service.NoticeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
//@ResponseBody
public class NoticeController {
    @RequestMapping(value = "allnotice", method = RequestMethod.GET)
    public JSONObject showAllNotice() throws Exception {
        NoticeService noticeService = new NoticeService();
        String allnotice = JSON.toJSONString( noticeService.loadNotice());
        JSONArray array= JSONArray.parseArray(allnotice);
        JSONObject result = new JSONObject();
        result.put("allnotice",array);
        return result;
    }
    @RequestMapping(value = "noticebyschool", method = RequestMethod.GET)
    public JSONObject showNoticeBySchool() throws Exception {
        NoticeService noticeService = new NoticeService();
        String noticebyschool = JSON.toJSONString( noticeService.loadNoticeBySchool());
        JSONArray array= JSONArray.parseArray(noticebyschool);
        JSONObject result = new JSONObject();
        result.put("noticebyassociation",array);
        return result;
    }
}
