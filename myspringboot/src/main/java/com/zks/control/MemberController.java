package com.zks.control;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zks.service.MemberService;
import com.zks.service.NoticeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
@ResponseBody
public class MemberController {
    //显示成员信息
    @RequestMapping(value = "/member", method = RequestMethod.POST)
    public JSONObject showMember(@RequestParam("userId") String userId,@RequestParam("associationId") Integer associationId) throws Exception {
        MemberService memberService = new MemberService();
        String member = JSON.toJSONString(memberService.selectMember(userId,associationId));
        JSONArray array= JSONArray.parseArray(member);
        JSONObject result = new JSONObject();
        result.put("member",array);
        return result;
    }
}
