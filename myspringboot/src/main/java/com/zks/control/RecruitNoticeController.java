package com.zks.control;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zks.service.RecruitNoticeService;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/api")
@CrossOrigin
@ResponseBody
public class RecruitNoticeController {
    //创建招新表
    @RequestMapping(value = "/createrecruitnotice", method = RequestMethod.POST)
    public JSONObject createrecruiteNotice(@RequestParam("userId") int userId, @RequestParam("recruitNoticeContent") String recruitNoticeContent,
                                           @RequestParam("recruitNoticeStartTime") String recruitNoticeStartTime, @RequestParam("recruitNoticeEndTime") String recruitNoticeEndTime,
                                           @RequestParam("associationsId") int associationsId) throws Exception {
        RecruitNoticeService recruitNotice = new RecruitNoticeService();
        java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");
        Date now = new Date();
        JSONObject result = recruitNotice.createRecruitNotice(userId,recruitNoticeContent,formatter.parse(recruitNoticeStartTime),formatter.parse(recruitNoticeEndTime),now,associationsId);
        return result;
    }
    //显示所有招新表
    @RequestMapping(value = "/allrecruitnotice1", method = RequestMethod.GET)
    public JSONObject createrecruiteNotice() throws Exception {
        RecruitNoticeService recruitNotice = new RecruitNoticeService();
        String allRecruitNotice = JSON.toJSONString( recruitNotice.loadAllRecruitNotice());
        JSONArray array= JSONArray.parseArray(allRecruitNotice);
        JSONObject result = new JSONObject();
        result.put("allrecruitnotice1",array);
        return result;
    }
    //删除招新表
    @RequestMapping(value = "/deleterecruitnotice", method = RequestMethod.POST)
    public JSONObject deleterecruiteNotice(@RequestParam("recruitNoticeId") int recruitNoticeId) throws Exception {
        RecruitNoticeService recruitNotice = new RecruitNoticeService();
        String allRecruitNotice = JSON.toJSONString( recruitNotice.deleteRecruitNotice(recruitNoticeId));
        JSONArray array= JSONArray.parseArray(allRecruitNotice);
        JSONObject result = new JSONObject();
        result.put("deleterecruitnotice",array);
        return result;
    }
}
