package com.zks.control;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zks.service.RecruitNoticeService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api")
@CrossOrigin
@ResponseBody
public class RecruitNoticeController {
    //创建招新表
    @RequestMapping(value = "/createrecruitnotice", method = RequestMethod.POST)
    public JSONObject createrecruiteNotice(@RequestParam("userId") int userId, @RequestParam("recruitNoticeContent") String recruitNoticeContent,
                                           @RequestParam("recruitNoticeStartTime") Date recruitNoticeStartTime, @RequestParam("recruitNoticeEndTime") Date recruitNoticeEndTime,
                                           @RequestParam("recruitNoticeReleaseTime") Date recruitNoticeReleaseTime, @RequestParam("associationsId") int associationsId) throws Exception {
        RecruitNoticeService recruitNotice = new RecruitNoticeService();
        JSONObject result = recruitNotice.createRecruitNotice(userId,recruitNoticeContent,recruitNoticeStartTime,recruitNoticeEndTime,recruitNoticeReleaseTime,associationsId);
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
