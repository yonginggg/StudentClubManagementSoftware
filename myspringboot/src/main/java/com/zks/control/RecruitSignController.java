package com.zks.control;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zks.service.RecruitSignService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
@ResponseBody
public class RecruitSignController {
    //显示所有申请表
    @RequestMapping(value = "/allrecruitnotice", method = RequestMethod.GET)
    public JSONObject showAllRecruitSign() throws Exception {
        RecruitSignService recruitSign = new RecruitSignService();
        String allRecruitSign = JSON.toJSONString( recruitSign.loadAllRecruitSign());
        JSONArray array= JSONArray.parseArray(allRecruitSign);
        JSONObject result = new JSONObject();
        result.put("allrecruitSign",array);
        return result;
    }
    //显示该社团下所有申请表
    @RequestMapping(value = "/allassociationrecruit", method = RequestMethod.POST)
    public JSONObject showAllRecruitSignByAssociation(@RequestParam("userId") String userId) throws Exception {
        RecruitSignService recruitSign = new RecruitSignService();
        String allRecruitSign = JSON.toJSONString( recruitSign.loadAllRecruitSignByAssociation(userId));
        JSONArray array= JSONArray.parseArray(allRecruitSign);
        JSONObject result = new JSONObject();
        result.put("allrecruitSignByAssociation",array);
        return result;
    }
}
